package com.DSU.DSU_Check;

import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SendData extends StringRequest {

    // 서버 URL 설정 ( PHP 파일 연동 )
    public static String URL1 = "http://dsu.dothome.co.kr/log.php?id="+com.DSU.DSU_Check.ThirdActivity.getTime()+"&pass="+LoginActivity.userID;
    private Map<String, String> map;


    public SendData(String userID, String userPassword, Response.Listener<String> listener) {
        super(Method.POST, URL1, listener, null);
        //Log.i("######test#######", " SendData is excuted");
        map = new HashMap<>();
        map.put("",userID);
        map.put("", userPassword);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
      return map;
    }
}
