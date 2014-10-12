package com.webview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * 
 * @author jm webview 事实上是 google 对 webkit 的集成 , 其默认还是使用的 V8 引擎.
 * 
 */

public class MainActivity extends Activity {

	private WebView view;
	private WebSettings setting;
	private Handler handler = new Handler();

	public class JSHandler {

		

		@JavascriptInterface
		public void test() {

			handler.post(new Runnable() {

				public void run() {
					view.loadUrl("javascript:wave()");
					Log.e("javascript:method : ....", "has invoked . ");
					Toast.makeText(MainActivity.this,"test javascript invoked", Toast.LENGTH_LONG).show();
				
				}

			});

		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		view = (WebView) findViewById(R.id.webView1);
		// 开启 javascript 支持
		setting = view.getSettings();
		setting.setJavaScriptEnabled(true);
	

		// 让页面在当前的控件中浏览 , 而不是去外界的浏览器
		view.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
			
		});

		view.addJavascriptInterface(new JSHandler(), "android_webView");

		view.loadUrl("file:///android_asset/locate.html");

	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && view.canGoBack()) {
			view.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
