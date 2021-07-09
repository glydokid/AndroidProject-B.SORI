package com.DSU.DSU_Check;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "nfclog";
    NfcAdapter nfc1;
    PendingIntent pendingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bundle intent = getIntent().getExtras();
        //final String ID = intent.getString("ID");
        //final String PW = intent.getString("PW");

        nfc1 = NfcAdapter.getDefaultAdapter(this);
//        pendingIntent = PendingIntent.getActivity(this,0,new Intent(this,this.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);


    }
    protected void onResume(){
        super.onResume();

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        nfc1 = NfcAdapter.getDefaultAdapter(this);
        nfc1.enableForegroundDispatch(this, pendingIntent, null, null);
    }

    protected  void onPause(){
        super.onPause();
        if (nfc1 != null) {
            nfc1.disableForegroundDispatch(this);
        }
    }

    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);

        if ((intent.getFlags() & Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY) == 0) {
            if (nfc1.ACTION_TECH_DISCOVERED.equals(intent.getAction()) || nfc1.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {

                // Do Something
                intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        }
    }

//        startActivity(intent2);


}