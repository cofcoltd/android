package com.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SimpleService extends Service {
	
	private static final String SIMPLE_SERVICE = "simple_service";

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("service : 成功绑定了 服务 ");

		return null;
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("service : 解除了服务绑定 ");
		return super.onUnbind(intent);
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("service : 服务创建了 .");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("service : 服务 销毁了 .");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		System.out.println("service : 服务启动了 .");
		
		for (int i = 0; i < 5; i++) {
			System.out.println("service:  calculate : " + i );
		}
		
		return super.onStartCommand(intent, flags, startId);
		
	}
	
	


}
