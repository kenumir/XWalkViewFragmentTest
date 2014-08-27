package com.example.xwalkfragmenttest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("ADD PAGE 1").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				openFragment("http://google.com/", false);
				return false;
			}
		});
		
		menu.add("ADD PAGE 2").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				openFragment("http://youtube.com/", false);
				return false;
			}
		});
		
		menu.add("REPLACE PAGE 3").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				openFragment("http://bing.com/", true);
				return false;
			}
		});
		
		menu.add("REPLACE PAGE 4").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				openFragment("https://crosswalk-project.org/", true);
				return false;
			}
		});
		
		return super.onCreateOptionsMenu(menu);
	}
	
	private void openFragment(String u, boolean useReplace) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		if (useReplace)
			ft.replace(R.id.webFrame, new WebFragment().setUrl(u));
		else
			ft.add(R.id.webFrame, new WebFragment().setUrl(u));
		ft.commit();
	}
	
	
}
