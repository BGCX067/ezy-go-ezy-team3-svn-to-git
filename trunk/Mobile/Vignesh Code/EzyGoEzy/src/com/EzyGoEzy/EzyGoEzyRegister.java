package com.EzyGoEzy;

import com.EzyGoEzy.User.AccountManager;
import com.EzyGoEzy.User.User;
import com.EzyGoEzy.User.UserAccountManager;
import com.EzyGoEzy.Utils.AccountTypes;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EzyGoEzyRegister extends Activity {
	Button btnRegister;
	EditText etUsername;
	EditText etPassword;
	EditText etFullName;
	EditText etPhoneNumber;
	EditText etEmailId;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        btnRegister = (Button)findViewById(R.id.btn_Register);
        etUsername = (EditText)findViewById(R.id.et_userName);
        etPassword = (EditText)findViewById(R.id.et_password);
        etFullName = (EditText)findViewById(R.id.et_fullName);
        etPhoneNumber = (EditText)findViewById(R.id.et_phoneNo);
        etEmailId = (EditText)findViewById(R.id.et_emailId);
       
        
        btnRegister.setOnClickListener(new OnClickListener() 
        		{
			 
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int phoneNumber = Integer.parseInt(etPhoneNumber.getText().toString());
				User user = new User(etUsername.getText().toString(), etPassword.getText().toString(),etEmailId.getText().toString() , etFullName.getText().toString(), phoneNumber, AccountTypes.PREPAID);
				AccountManager accountManager = new UserAccountManager(EzyGoEzyRegister.this);
				accountManager.createUser(user);
				Intent intentHome = new Intent(EzyGoEzyRegister.this,EzyGoEzyHome.class);
		        startActivity(intentHome);
			}
		});
    }
}
