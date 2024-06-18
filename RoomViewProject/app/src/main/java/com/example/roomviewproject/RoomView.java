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
            R.drawable.g
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
        int[][] positions = {
                {50, 50, 210, 210},   // top-left
                {430, 50, 590, 210},  // top-right
                {50, 500, 210, 660},  // middle-left
                {430, 500, 590, 660}, // middle-right
                {50, 950, 210, 1110}, // bottom-left
                {430, 950, 590, 1110} // bottom-right
        };

        for (int i = 0; i < drawableResources.length && i < positions.length; i++) {
            Drawable pictureDrawable = AppCompatResources.getDrawable(context, drawableResources[i]);
            if (pictureDrawable != null) {
                pictureDrawable.setBounds(positions[i][0], positions[i][1], positions[i][2], positions[i][3]);
                pictureDrawable.draw(_canvas);
            }
        }
    }
}