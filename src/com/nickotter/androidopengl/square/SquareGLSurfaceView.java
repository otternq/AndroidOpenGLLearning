package com.nickotter.androidopengl.square;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class SquareGLSurfaceView extends GLSurfaceView {
	
	private static final String LOG_TAG = SquareGLSurfaceView.class.getSimpleName();
    private SquareGLRenderer _renderer;

	public SquareGLSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		this._renderer = new SquareGLRenderer(true);
		
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
