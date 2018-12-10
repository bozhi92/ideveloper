package com.hubbleadvance.utils.ideveloper.common.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hubbleadvance.utils.ideveloper.controller.JsonResult;

public final class ResponseUtil {
    public static void returnJsonResult(HttpServletResponse res, JsonResult result) throws IOException {
        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");
        PrintWriter out = res.getWriter();
        //ObjectMapper mapper = new ObjectMapper();
        //String jsonOfRST = mapper.writeValueAsString(result);
        out.print(JSON.toJSONString(result));
        out.flush();
    }
}
