package com.nickotter.androidopengl.cube;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CubeGLSurfaceView extends GLSurfaceView {
	
	private static final String LOG_TAG = CubeGLSurfaceView.class.getSimpleName();
    private CubeGLRenderer _renderer;

	public CubeGLSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		this._renderer = new CubeGLRenderer(true);
		
		setRenderer(this._renderer);
	}
	
	/*public boolean onTouchEvent(final MotionEvent event) {
	    queueEvent(new Runnable() {
	        public void run() {
	            _renderer.setColor(event.getX() / getWidth(), event.getY() / getHeight(), 1.0f);
	            
	            //rotate around the y-axis
	            _renderer.setAngle(event.getX() / 10);
	        }
	    });
	    return true;
	}*/

}
