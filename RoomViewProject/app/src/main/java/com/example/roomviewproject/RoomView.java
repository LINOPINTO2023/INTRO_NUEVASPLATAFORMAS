package com.example.roomviewproject;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;

import java.util.List;

public class RoomView extends View {

    private Canvas _canvas;
    private List<PointRoom> points;
    private Context context;
    private int[] drawableResources = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o
    };

    private int[][] positions = {
            {10, 10, 170, 170},      // top-left
            {910, 10, 1070, 170},    // top-right
            {10, 1610, 170, 1770},   // bottom-left
            {910, 1610, 1070, 1770}, // bottom-right
            {10, 410, 170, 570},     // left-middle-top
            {10, 810, 170, 970},     // left-middle-middle
            {10, 1210, 170, 1370},   // left-middle-bottom
            {910, 410, 1070, 570},   // right-middle-top
            {910, 810, 1070, 970},   // right-middle-middle
            {910, 1210, 1070, 1370}, // right-middle-bottom
            {410, 10, 570, 170},     // top-middle-left
            {610, 10, 770, 170},     // top-middle-right
            {410, 1610, 570, 1770},  // bottom-middle-left
            {610, 1610, 770, 1770},  // bottom-middle-right
    };

    public RoomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void setData(List<PointRoom> points) {
        this.points = points;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        _canvas = canvas;
        drawRoom();
        drawPictures();
    }

    private void drawRoom() {
        if (points != null && points.size() > 0) {
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setStrokeWidth(10f);
            paint.setStyle(Paint.Style.STROKE);

            Path path = new Path();
            path.moveTo(points.get(0).getX(), points.get(0).getY());

            for (int i = 1; i < points.size(); i++) {
                path.lineTo(points.get(i).getX(), points.get(i).getY());
            }
            path.close();

            _canvas.drawPath(path, paint);
        }
    }

    private void drawPictures() {
        for (int i = 0; i < drawableResources.length && i < positions.length; i++) {
            Drawable pictureDrawable = AppCompatResources.getDrawable(context, drawableResources[i]);
            if (pictureDrawable != null) {
                pictureDrawable.setBounds(positions[i][0], positions[i][1], positions[i][2], positions[i][3]);
                pictureDrawable.draw(_canvas);
            }
        }
    }
}
