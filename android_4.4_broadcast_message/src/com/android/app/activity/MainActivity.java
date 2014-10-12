package com.android.app.activity;

import com.activity.R;
import com.android.broadcast.receiver.MessageBroadcast;

import android.os.Bundle;
import android.app.Activity;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button regBroadcast , unRegBroadcast;
	//创建一个 Broadcast 对象
	private MessageBroadcast messageBroadcast = null;
	
	private static final String SMS_ACTION = "android.provider.Telephony.SMS_RECEIVED";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        
        regBroadcast = (Button)findViewById(R.id.reg_Broadcast);
        unRegBroadcast = (Button) findViewById(R.id.unreg_Broadcast);
        
        regBroadcast.setOnClickListener(new ViewOCL());
        unRegBroadcast.setOnClickListener(new ViewOCL());
        
    }
    
    class ViewOCL implements View.OnClickListener {
    	@Override
    	public void onClick(View v) {
    		
    		switch (v.getId()) {
			case R.id.reg_Broadcast:
				//创建一个 Broadcast 对象
	    		messageBroadcast = new MessageBroadcast();
	    		//创建一个 IntentFilter 对象
	    		IntentFilter filter = new IntentFilter();
	    		filter.addAction(SMS_ACTION);  
	    		
	    		MainActivity.this.registerReceiver(messageBroadcast, filter); 
	    		
				break;
			case R.id.unreg_Broadcast:
				
				MainActivity.this.unregisterReceiver(messageBroadcast);
				break;
			}
    		
    	}
    }

}
