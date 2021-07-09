package com.DSU.DSU_Check;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import static com.DSU.DSU_Check.LoginActivity.userID;

public class ThirdActivity extends AppCompatActivity {
    TextView tv;
    ImageView iv;
    public static String NullData = " ";

    private final Response.Listener<String> responseListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            iv.setImageResource(R.drawable.ck);
            tv.setText(getTime() + " 발열체크 완료 ");
        }
    };

    private final Response.ErrorListener responseErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            iv.setImageResource(R.drawable.disconect);
            tv.setText("네트워크 상태가 좋지 않아요.\n연결 상태를 확인하고 다시 시도해주세요.");
        }
    };

    @SuppressLint("SimpleDateFormat")
    private String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd k:mm:ss");

        return dateFormat.format(new Date());
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        tv = (TextView)findViewById(R.id.tv1);
        iv = (ImageView) findViewById(R.id.imageView4);


        String url = getUrl(getTime(), userID);
        SendData SendData = new SendData(url, NullData, NullData, responseListener, responseErrorListener);
        RequestQueue queue2 = Volley.newRequestQueue(ThirdActivity.this);
        queue2.add(SendData);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
    }

    private String getUrl(String time, String id) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("dsu.dothome.co.kr")
                .appendPath("log.php")
                .appendQueryParameter("time", time)
                .appendQueryParameter("id", id);

        return builder.build().toString();
    }


}