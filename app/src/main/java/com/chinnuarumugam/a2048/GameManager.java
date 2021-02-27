package com.chinnuarumugam.a2048;


import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GameManager extends SurfaceView implements SurfaceHolder.Callback {

    private  MainThread thread;

    public GameManager(Context context, AttributeSet attrs)
    {
        super(context,attrs);
        getHolder().addCallback(this);
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        thread = new MainThread(surfaceHolder, this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        thread.setSurfaceHolder(surfaceHolder);
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        boolean retry = true;
        while (retry){
            try {
                thread.setRunning(false);
                thread.join();
                retry = false;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public  void update(){
        System.out.println("Test from update");
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        System.out.println("Test from draw");
    }
}

