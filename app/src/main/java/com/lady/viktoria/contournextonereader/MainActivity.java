package com.lady.viktoria.contournextonereader;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.bluetoothlegatt.BluetoothLeService;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnAct;
    TextView bgmac;
    Bundle b;
    String deviceBTMAC;
    String mDeviceAddress = "00:00:00:00:00:00";
    BluetoothLeService mBluetoothLeService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAct = (Button) findViewById(R.id.listpaireddevices);
        bgmac = (TextView)findViewById(R.id.bgmac);
        btnAct.setOnClickListener(this);

        try {
            b = getIntent().getExtras();
            deviceBTMAC = b.getString("BG Meter MAC Address");
            Log.v("deviceBTMAC", deviceBTMAC);
            bgmac.setText("BGMeter MAC: " + deviceBTMAC);
            Log.v("old_deviceBTMAC", mDeviceAddress);
            mDeviceAddress=deviceBTMAC;
            Log.v("new_deviceBTMAC", mDeviceAddress);
            mBluetoothLeService.connect(mDeviceAddress);

        }
        catch (Exception e) {
            Log.v("try_catch", "Error " + e.getMessage());
        }

    }


    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.listpaireddevices:
                Intent intent = new Intent (this, BGMeterActivity.class);
                startActivity (intent);
                break;
            default:
                break;
        }
    }
}