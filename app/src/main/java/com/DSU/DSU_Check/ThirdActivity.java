package com.DSU.DSU_Check;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


import static com.DSU.DSU_Check.LoginActivity.userID;

public class ThirdActivity extends AppCompatActivity {
    private static String currentDate;
    TextView tv;
    long mNow;
    public static String NullData = " ";

    Date mDate = new Date(mNow);

    public static String getTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd k:mm:ss");
        currentDate = dateFormat.format(new Date());
        return currentDate;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        tv = (TextView)findViewById(R.id.tv1);
        tv.setText(getTime() + " 발열체크 완료 ");
        SendData SendData = new SendData(NullData, NullData, null);
        RequestQueue queue2 = Volley.newRequestQueue(ThirdActivity.this);
        queue2.add(SendData);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
    }


}