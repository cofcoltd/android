package com.android.broadcast.receiver;

import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MessageBroadcast extends BroadcastReceiver {
	
	
	public MessageBroadcast() {
		System.out.println("Create MessageBroadCast  !!!");
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println(" Recevied message !! ..");
		
		Bundle bundle = intent.getExtras();
		Object[] pdus = (Object[]) bundle.get("pdus"); //(protocol description unit)
		
		SmsMessage[] messages = new SmsMessage[pdus.length];
		System.out.println("messages Length : "+messages.length);
		
		for (int i = 0; i < messages.length; i++) {
			messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
			System.out.println(messages[i].getDisplayMessageBody());
			System.out.println("发送时间 : "+new Date(messages[i].getTimestampMillis()));
			Toast.makeText( context , messages[i].getDisplayMessageBody() , Toast.LENGTH_SHORT).show();
		}
		
		
	}

}
