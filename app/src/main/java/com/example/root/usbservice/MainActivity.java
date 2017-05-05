package com.example.root.usbservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    TextView textInfo;
    TextView textSearchedEndpoint;

    TextView textDeviceName;
    TextView textStatus;

    private static final int targetVendorID = 6860;
    private static final int targetProductID = 1966;
    UsbDevice deviceFound = null;
    UsbInterface usbInterfaceFound = null;
    UsbEndpoint endpointIn = null;
    UsbEndpoint endpointOut = null;

    private static final String ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION";
    PendingIntent mPermissionIntent;

    UsbInterface usbInterface;
    UsbDeviceConnection usbDeviceConnection;

    EditText textOut;
    TextView textin;
    Button buttonSend;

    byte[] readBytes = new byte[64];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textStatus = (TextView) findViewById(R.id.textstatus);

        textDeviceName = (TextView) findViewById(R.id.textdevicename);
        textInfo = (TextView) findViewById(R.id.info);
        textSearchedEndpoint = (TextView) findViewById(R.id.searchedendpoint);

        // register the broadcast receiver


        textOut = (EditText)findViewById(R.id.textout);
        textin = (TextView)findViewById(R.id.textin);
        buttonSend = (Button)findViewById(R.id.send);
        buttonSend.setOnClickListener(buttonSendOnClickListener);
    }

    View.OnClickListener buttonSendOnClickListener =
            new View.OnClickListener(){

                @Override
                public void onClick(View v) {


                    startService(
                            new Intent(MainActivity.this, DataService.class));



                    ////////////////////////////////////////


                }};

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}