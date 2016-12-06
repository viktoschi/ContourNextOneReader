package com.lady.viktoria.contournextonereader;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.Set;

public class BGMeterActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> btArrayAdapter
                = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);

        BluetoothAdapter bluetoothAdapter
                = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices
                = bluetoothAdapter.getBondedDevices();

        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                String deviceBTName = device.getName();
                String deviceBTMAC = device.getAddress();
                btArrayAdapter.add(deviceBTName + "\n" + deviceBTMAC);
            }
        }
        setListAdapter(btArrayAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        String macaddress = (String) getListAdapter().getItem(position);
        String deviceBTMAC[] = macaddress.split("\\r?\\n");
        Intent intent = new Intent(BGMeterActivity.this,MainActivity.class);
        Bundle dataBundle = new Bundle();
        dataBundle.putString("BG Meter MAC Address", deviceBTMAC[1]);
        intent.putExtras(dataBundle);
        startActivity(intent);
        finish();
    }
}