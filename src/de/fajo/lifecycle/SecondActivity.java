package de.fajo.lifecycle;

import android.os.Bundle;

public class SecondActivity extends LifecycleActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}
}
