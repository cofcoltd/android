package com.android.activity;

import org.apache.http.protocol.RequestContent;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Intent intent;

	private Button main_btn_send, main_btn_signIn;
	private EditText main_editText_input;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);

		main_btn_send = (Button) findViewById(R.id.main_btn_send);
		main_btn_signIn = (Button) findViewById(R.id.main_btn_signIn);
		main_editText_input = (EditText) findViewById(R.id.main_editText_input);

		main_btn_send.setOnClickListener(new ViewClickListener());
		main_btn_signIn.setOnClickListener(new ViewClickListener());

	}

	class ViewClickListener implements View.OnClickListener {
		@Override
		public void onClick(View view) {

			switch (view.getId()) {
			case R.id.main_btn_send:

				intent = new Intent(MainActivity.this, ResultActivity.class);

				String cuz = main_editText_input.getText().toString();

				Bundle bundle = new Bundle();
				bundle.putString("cuz", cuz);

				intent.putExtras(bundle);

				startActivityForResult(intent, 100);

				break;

			case R.id.main_btn_signIn:

				intent = new Intent(MainActivity.this, SignInActivity.class);

				startActivityForResult(intent, 200);

				break;
			}
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		switch (requestCode) {
		case 100:  /** 请假的业务 */

			String feedback = data.getStringExtra("feedback");

			switch (resultCode) { 
			case RESULT_OK: /** 当请假成功时 */

				main_editText_input.setText("good luck : " + feedback);

				break;
			case RESULT_CANCELED: /** 请假未通过时 */     // 如果 是 按下 返回按钮 默认进入 cancel
				main_editText_input.setText("sorry , cuz is : " + feedback);

				break;
			}

			break;
		
		case 200: /** 签到的业务 */

			switch (resultCode) {
			case RESULT_OK:

				String msg = data.getStringExtra("time");
				Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT)
						.show();

				break;

			}

			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
