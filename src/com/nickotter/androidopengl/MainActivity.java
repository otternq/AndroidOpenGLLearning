package com.nickotter.androidopengl;

import com.nickotter.androidopengl.rotatingtriangle.*;
import com.nickotter.androidopengl.square.SquareFragment;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	GLSurfaceView surfaceView;
	
    @TargetApi(11)
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //setContentView(R.layout.activity_main);
        
        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        
        // setup action bar for tabs
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        
        Tab tab = actionBar.newTab()
                .setText(R.string.title_activity_main)
                .setTabListener(new TabListener<MainFragment>(
                        this, "Basic", MainFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
            .setText(R.string.title_rotating_triangle)
            .setTabListener(new TabListener<RotatingTriangleFragment>(
                    this, "Basic", RotatingTriangleFragment.class));
        actionBar.addTab(tab);
        
        tab = actionBar.newTab()
        	.setText(R.string.title_square)
        	.setTabListener(new TabListener<SquareFragment>(
        			this, "Basic", SquareFragment.class));
        actionBar.addTab(tab);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /**
     * Handles menu selections
     * 
     * @param item The item that was selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	CharSequence title = item.getTitle();
    	
    	if (item.getItemId() == android.R.id.home) {
            // app icon in action bar clicked; go home
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
    	} else {
    		
    		System.out.println("Unable to handle " + title);
    		
    	}
        
    	return super.onOptionsItemSelected(item);
    }
    
    /** Called when the user touches the button */
    public void clickHandler(View view) {
        // Do something in response to button click
    }
}
