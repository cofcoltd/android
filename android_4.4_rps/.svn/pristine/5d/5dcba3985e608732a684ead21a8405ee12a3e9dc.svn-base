package com.android.activity;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {

	private TextView viewResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_result);

		viewResult = (TextView) findViewById(R.id.result_result);

		Intent intent = getIntent();
		int hand = intent.getExtras().getInt("hand");

		int computer = new Random().nextInt(3) ;

		int result = (hand - computer + 4) % 3 -1; //算法
		
		String txt = "平局";
		
		if(result == 1 ) {
			txt = " 胜利 ";
		} else if(result == -1 ) {
			txt = " 失败 ";
		}
		
		
		String msg = "您出的是 : " + change(hand) + " , android 出的是 : "
				+ change(computer) + " . " + txt;

		viewResult.setText(msg);
	}

	private String change(int r) {
		switch (r) {
		case 0:
			return "剪子";
		case 1:
			return "石头";
		case 2:
			return "布";
		}
		return null;
	}

}
