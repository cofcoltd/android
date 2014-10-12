package com.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	private RadioGroup group;

	private RadioButton rocks, papers, scissors;

	private Button btn_guess;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);

		group = (RadioGroup) findViewById(R.id.group);

		rocks = (RadioButton) findViewById(R.id.radio_rocks);
		papers = (RadioButton) findViewById(R.id.radio_papers);
		scissors = (RadioButton) findViewById(R.id.radio_scissors);

		btn_guess = (Button) findViewById(R.id.btn_guess);

		btn_guess.setOnClickListener(new ViewClickListener());

	}

	class ViewClickListener implements View.OnClickListener {

		@Override
		public void onClick(View view) {

			Intent intent = new Intent(MainActivity.this, ResultActivity.class);
			Bundle bundle = new Bundle();

			switch (view.getId()) {	
			
			case R.id.btn_guess:
				if (rocks.isChecked()) {
					bundle.putInt("hand", 0); //剪子
				} else if (papers.isChecked()) {
					bundle.putInt("hand", 1); //石头
				} else if (scissors.isChecked()) {
					bundle.putInt("hand", 2); //布
				} 
				break;

			default:
				break;
			}

			intent.putExtras(bundle);

			startActivity(intent);

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
