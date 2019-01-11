package com.hubbleadvance.utils.ideveloper.common.utils;

import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public final class HttpUtil {
    public static HttpResult post(String url, String body, Map<String, String> headers) {
        HttpResult result = new HttpResult();
        try {
            HttpResponse<String> jsonResponse = Unirest.post(url).headers(headers).body(body).asString();
            result.setBody(jsonResponse.getBody());
            result.setStatus(jsonResponse.getStatus());
            result.setStatusText(jsonResponse.getStatusText());
        } catch (UnirestException e){
            log.error("post请求出错, equestUrl="+url+", equestBody="+body);
            e.printStackTrace();
        }
        return result;
    }
    
    public static HttpResult post(String url, String body) {
        HttpResult result = new HttpResult();
        try {
            HttpResponse<String> jsonResponse = Unirest.post(url).header("Content-Type","application/json").body(body).asString();
            result.setBody(jsonResponse.getBody());
            result.setStatus(jsonResponse.getStatus());
            result.setStatusText(jsonResponse.getStatusText());
        } catch (UnirestException e){
            log.error("post请求出错, equestUrl="+url+", equestBody="+body);
            e.printStackTrace();
        }
        return result;
    }    
}
