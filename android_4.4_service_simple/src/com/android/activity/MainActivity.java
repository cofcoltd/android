package com.android.activity;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn_start, btn_stop, btn_bind, btn_unbind;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);

		btn_start = (Button) findViewById(R.id.btn_start);
		btn_stop = (Button) findViewById(R.id.btn_stop);
		btn_bind = (Button) findViewById(R.id.btn_bind);
		btn_unbind = (Button) findViewById(R.id.btn_unbind);

		btn_start.setOnClickListener(new ViewClickListener());
		btn_stop.setOnClickListener(new ViewClickListener());
		btn_bind.setOnClickListener(new ViewClickListener());
		btn_unbind.setOnClickListener(new ViewClickListener());

	}

	class ViewClickListener implements View.OnClickListener {

		Intent intent = new Intent();

		@Override
		public void onClick(View view) {

			switch (view.getId()) {

			case R.id.btn_bind:
				// 绑定 Service 服务
				intent.setAction("com.android.service.SimpleService");
				bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);
				break;

			case R.id.btn_unbind:
				// 绑定 Service 服务
				
				unbindService(serviceConnection);
				break;

			case R.id.btn_start:
				// 设置 intent 的 Action 属性
				intent.setAction("com.android.service.SimpleService");
				startService(intent);
				break;
			case R.id.btn_stop:
				intent.setAction("com.android.service.SimpleService");
				stopService(intent);
				break;
			}

		}

	}

	/**
	 * serviceConnection 用于绑定 Service 服务
	 */
	private ServiceConnection serviceConnection = new ServiceConnection() {

		@Override
		// 获取 服务链接
		public void onServiceDisconnected(ComponentName arg0) {
			System.out.println("serviceConnection : 连接到 SimpleService服务");
		}

		@Override
		// 断开服务连接
		public void onServiceConnected(ComponentName arg0, IBinder arg1) {
			System.out.println("serviceConnection : 断开了 SimpleService服务");
		}

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
