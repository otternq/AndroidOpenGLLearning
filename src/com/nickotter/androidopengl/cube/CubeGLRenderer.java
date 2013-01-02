package com.nickotter.androidopengl.cube;

import com.nickotter.androidopengl.shape.*;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

import java.lang.Math;

public class CubeGLRenderer implements Renderer {
	
	public CubeGLRenderer(boolean useTranslucentBackground) {
		mTranslucentBackground = useTranslucentBackground;
		mCube = new Cube();
	}
	
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glClearColor(0.0f,  0.5f, 0.5f, 1.0f);
		
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		
		gl.glTranslatef(0.0f,  (float)Math.sin(mTransY),  -7.0f);
		
		//rotate angle
		gl.glRotatef(mAngle,  0.0f, 1.0f, 0.0f);
		gl.glRotatef(mAngle, 1.0f, 0.0f, 0.0f);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		
		mCube.draw(gl);
		
		mTransY += .075f;
		mTransX += .075f;
		mAngle += .4;
	}
	
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		
		gl.glViewport(0, 0, width, height);
		
		float aspectRatio;
		float zNear = .1f;
		float zFar = 1000;
		float fieldOfView = 30.0f / 57.3f;
		float size;
		
		gl.glEnable(GL10.GL_NORMALIZE);
		
		aspectRatio = (float) width / (float) height;
		
		gl.glMatrixMode(GL10.GL_PROJECTION);
		size = zNear * (float) (Math.tan((double)(fieldOfView/2.0f)));
		
		gl.glFrustumf(-size, size, -size / aspectRatio, size / aspectRatio, zNear, zFar);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		
	}
	
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		
		gl.glDisable(GL10.GL_DITHER);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
		
		if (mTranslucentBackground) {
			gl.glClearColor(0, 0, 0, 0);
		} else {
			gl.glClearColor(1, 1, 1, 1);
		}
		
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		
	}
	
	private boolean mTranslucentBackground;
	private Cube mCube;
	private float mTransY;
	private float mTransX;
	private float mAngle;
	
	
}