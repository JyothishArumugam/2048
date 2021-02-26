package com.chinnuarumugam.a2048;

import android.view.SurfaceHolder;

public class MainThread extends Thread{

    private SurfaceHolder surfaceHolder;
    private GameManager gameManager;

    public MainThread(SurfaceHolder surfaceHolder, GameManager gameManager){
        super();
    }
}
