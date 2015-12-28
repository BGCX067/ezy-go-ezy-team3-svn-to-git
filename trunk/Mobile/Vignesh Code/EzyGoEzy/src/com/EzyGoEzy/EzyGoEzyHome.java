package com.EzyGoEzy;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class EzyGoEzyHome extends TabActivity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        TabHost tabHost=getTabHost();
        // no need to call TabHost.Setup()        
        
        //First Tab
        TabSpec spec1=tabHost.newTabSpec(getString(R.string.tab_balance));
        spec1.setIndicator(getString(R.string.tab_balance),getResources().getDrawable(R.drawable.icon));
        Intent in1=new Intent(this, EzyGoEzyBalance.class);
        spec1.setContent(in1);
        
        TabSpec spec2=tabHost.newTabSpec(getString(R.string.tab_route));
        spec2.setIndicator(getString(R.string.tab_route),getResources().getDrawable(R.drawable.icon));
        Intent in2=new Intent(this, EzyGoEzyRoute.class);
        spec2.setContent(in2);

        TabSpec spec3=tabHost.newTabSpec(getString(R.string.tab_notification));
        spec3.setIndicator(getString(R.string.tab_notification),getResources().getDrawable(R.drawable.icon));
        Intent in3 =new Intent(this, EzyGoEzyNotifications.class);
        spec3.setContent(in3);
        
        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);
        tabHost.setCurrentTab(0);
    }
}
