package com.nickotter.androidopengl.rotatingtriangle;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class RotatingTriangleGLSurfaceView extends GLSurfaceView {
	
	private static final String LOG_TAG = RotatingTriangleGLSurfaceView.class.getSimpleName();
    private RotatingTriangleGLRenderer _renderer;

	public RotatingTriangleGLSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		this._renderer = new RotatingTriangleGLRenderer();
		
		setRenderer(this._renderer);
	}
	
	public boolean onTouchEvent(final MotionEvent event) {
	    queueEvent(new Runnable() {
	        public void run() {
	            _renderer.setColor(event.getX() / getWidth(), event.getY() / getHeight(), 1.0f);
	            
	            //rotate around the y-axis
	            _renderer.setAngle(event.getX() / 10);
	        }
	    });
	    return true;
	}

}
