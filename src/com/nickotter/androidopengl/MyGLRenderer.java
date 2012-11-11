package com.nickotter.androidopengl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

public class MyGLRenderer implements Renderer {
	
	private float _red = 0.9f;
    private float _green = 0.2f;
    private float _blue = 0.2f;
    
	@Override
	public void onDrawFrame(GL10 gl) {
		// define the color we want to be displayed as the "clipping wall"
        gl.glClearColor(_red, _green, _blue, 1.0f);
        // clear the color buffer to show the ClearColor we called above...
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);

	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub

	}
	
	public void setColor(float r, float g, float b) {
	    _red = r;
	    _green = g;
	    _blue = b;
	}

}
