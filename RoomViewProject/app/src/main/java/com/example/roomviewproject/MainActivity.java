package com.example.roomviewproject;

import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RoomView roomView = findViewById(R.id.roomView);

        List<PointRoom> points = new ArrayList<>();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

// Definir los puntos basados en las dimensiones de la pantalla
        points.add(new PointRoom(10, 10));
        points.add(new PointRoom(1070, 10));
        points.add(new PointRoom(1070, 1800));
        points.add(new PointRoom(10, 1800));
        roomView.setData(points);
    }
}
