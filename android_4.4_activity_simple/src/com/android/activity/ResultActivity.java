package com.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResultActivity extends Activity {

	private Intent intent;

	private Button result_btn_ok, result_btn_cancel;
	private EditText result_edit_feedback;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_result);

		result_edit_feedback = (EditText) findViewById(R.id.result_edit_feedback);
		result_btn_ok = (Button) findViewById(R.id.result_btn_ok);
		result_btn_cancel = (Button) findViewById(R.id.result_btn_cancel);

		intent = getIntent();

		String fav = intent.getExtras().getString("cuz");
		Toast.makeText(getApplicationContext(), fav, Toast.LENGTH_SHORT).show();

		 result_btn_ok.setOnClickListener(new ViewClickListener());
		 result_btn_cancel.setOnClickListener(new ViewClickListener());

	}
	
	
	
	
	@Override //覆盖 后退事件
	public void onBackPressed() {	
		
		intent.putExtra("feedback", " factually , i do not have time to deal with your applying . ");
		
		setResult(RESULT_CANCELED, intent);
		
		super.onBackPressed();
	}
	

	class ViewClickListener implements View.OnClickListener {
		@Override
		public void onClick(View view) {

			String feedback = result_edit_feedback.getText().toString();

			switch (view.getId()) {
			case R.id.result_btn_ok:

				intent.putExtra("feedback", feedback);
				setResult(RESULT_OK, intent);
				finish();
				break;

			case R.id.result_btn_cancel:

				intent.putExtra("feedback", feedback);
				setResult(RESULT_CANCELED, intent);
				finish();
				break;
			}
		}
	}

}
