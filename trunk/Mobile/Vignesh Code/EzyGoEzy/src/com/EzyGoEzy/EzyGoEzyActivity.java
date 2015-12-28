package com.EzyGoEzy;

import com.EzyGoEzy.User.AccountManager;
import com.EzyGoEzy.User.User;
import com.EzyGoEzy.User.UserAccountManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EzyGoEzyActivity extends Activity {
    /** Called when the activity is first created. */
	TextView tvRegister;
	Button btnLogin;
	EditText etUserName;
	EditText etPassword;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        etUserName = (EditText)findViewById(R.id.tv_userName);
        etPassword = (EditText)findViewById(R.id.tv_password);
        tvRegister = (TextView)findViewById(R.id.tv_Register);
        btnLogin = (Button)findViewById(R.id.btn_Login);
        /*Intent intentHome = new Intent(this,EzyGoEzyHome.class);
        startActivity(intentHome);*/
        
        tvRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentRegister = new Intent(EzyGoEzyActivity.this,EzyGoEzyRegister.class);
		        startActivity(intentRegister);
			}
		} ); 
        
        btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String userName = etUserName.getText().toString();
				String password = etPassword.getText().toString();
				AccountManager accountManager = new UserAccountManager(EzyGoEzyActivity.this);
				User currentUser = null;
				boolean userExists = accountManager.getUser(userName, password, currentUser);
				if(userExists)
				{
					CurrentUser.set(currentUser);
					Intent intentHome = new Intent(EzyGoEzyActivity.this,EzyGoEzyHome.class);
			        startActivity(intentHome);
				}
			}
		});
        	
        	
    }
    protected void onResume()
    {
       super.onResume();
       if(CurrentUser.isSet)
   	   {
   		Intent intentHome = new Intent(EzyGoEzyActivity.this,EzyGoEzyHome.class);
	        startActivity(intentHome);	
       }
       
    }
}