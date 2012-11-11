package com.nickotter.androidopengl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyGLSurfaceView extends GLSurfaceView {
	
	private static final String LOG_TAG = MyGLSurfaceView.class.getSimpleName();
    private MyGLRenderer _renderer;

	public MyGLSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		this._renderer = new MyGLRenderer();
		
		setRenderer(this._renderer);
	}
	
	public boolean onTouchEvent(final MotionEvent event) {
	    queueEvent(new Runnable() {
	        public void run() {
	            _renderer.setColor(event.getX() / getWidth(), event.getY() / getHeight(), 1.0f);
	        }
	    });
	    return true;
	}

}
