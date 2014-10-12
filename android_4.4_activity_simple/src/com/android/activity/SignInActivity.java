package com.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DigitalClock;

public class SignInActivity extends Activity {
	
	private Intent intent;
	
	private DigitalClock signin_clock_signinTime;
	private Button signin_btn_singin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_signin);
		
		intent = getIntent();
		
		signin_btn_singin = (Button)findViewById(R.id.signin_btn_singin);
		signin_clock_signinTime =(DigitalClock) findViewById(R.id.signin_clock_signinTime);
		
		
		signin_btn_singin.setOnClickListener(new ViewClickListener());
	}
	
	class ViewClickListener implements View.OnClickListener {
		@Override
		public void onClick(View view) {
			
			switch (view.getId()) {
			case R.id.signin_btn_singin:
				
				String msg = "打卡时间是 : "+signin_clock_signinTime.getText().toString();
				
				intent.putExtra("time", msg);
				
				setResult(RESULT_OK, intent);
				
				finish();
				
				break;

			default:
				break;
			}
			
		}
	}

}
