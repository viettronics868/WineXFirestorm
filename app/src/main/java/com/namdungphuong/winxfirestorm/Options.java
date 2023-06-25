package com.namdungphuong.winxfirestorm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

//import com.startapp.android.publish.StartAppAd;

public class Options extends PreferenceActivity implements OnSharedPreferenceChangeListener{

	//private StartAppAd startAppAd = new StartAppAd(this);

	EditTextPreference ep;
	SharedPreferences settings;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preef);
		settings=PreferenceManager.getDefaultSharedPreferences(this);
		getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
		ep=(EditTextPreference) findPreference("Name");
		ep.setSummary(settings.getString("Name", "New Player"));
		
	
	//	String name=
		//Log.d("arjun",name);
	
	
		
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		// TODO Auto-generated method stub
		if(key.equals("Name")){
			ep.setSummary(settings.getString("Name", "New Player"));
			
			
		}
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	
		finish();
	
	}
	
}
