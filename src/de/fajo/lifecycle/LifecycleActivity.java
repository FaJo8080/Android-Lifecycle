package de.fajo.lifecycle;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class LifecycleActivity extends Activity {

	
	
	

	   /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Status", "onCreate");
        notify("onCreate");
        setContentView(R.layout.activity_lifecycle);
        Button oButton = (Button) this.findViewById(R.id.buttonSecondAc);
        
        oButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent secondAc = new Intent(LifecycleActivity.this, SecondActivity.class);
				startActivity(secondAc);
			}
		}); 
    }
    
    
    @Override
    protected void onStart() {
    	super.onStart();
    	notify("onStart");
    	Log.d("Status", "start");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
      super.onResume();
      notify("onResume");
      Log.d("Status", "resume");
    }

    
    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
      super.onStop();
      notify("onStop");
      Log.d("Status", "stop");
    }
    
    /** Called just before the activity is destroyed. */
    @Override
    protected void onDestroy() {
      super.onDestroy();
      notify("onDestroy");
      Log.d("Status", "destroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
      super.onRestoreInstanceState(savedInstanceState);
      notify("onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
      super.onSaveInstanceState(outState);
      notify("onSaveInstanceState");
    }

      
    private void notify(String methodName) {
    	String name = this.getClass().getName();
    	String[] strings = name.split("\\.");
    	Notification noti = new Notification.Builder(this)
    		.setContentTitle(methodName + " " + strings[strings.length-1]).setAutoCancel(true)
    		.setSmallIcon(R.drawable.ic_launcher)
    		.setContentText(name).build();
    	NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    	notificationManager.notify((int)System.currentTimeMillis(), noti);
	}
}
