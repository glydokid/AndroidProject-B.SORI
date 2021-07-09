package com.DSU.DSU_Check;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SendData extends StringRequest {
    // 서버 URL 설정 ( PHP 파일 연동 )
    private Map<String, String> map;
    public SendData(String url, String userID, String userPassword, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, url, listener, errorListener);
        map = new HashMap<>();
        map.put("",userID);
        map.put("", userPassword);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
      return map;
    }
}
