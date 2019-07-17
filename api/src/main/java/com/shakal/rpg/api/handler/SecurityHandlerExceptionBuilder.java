package com.shakal.rpg.api.handler;


import com.google.gson.Gson;
import com.shakal.rpg.api.exception.ExceptionReponseDetail;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityHandlerExceptionBuilder {


    public static ServletResponse handleError(HttpServletResponse response, int status, Exception exception) throws IOException {
        String json = new Gson().toJson(new ExceptionReponseDetail(
        		"Erro",
        		status,
        		exception.getMessage(),
        		exception.getClass().toString()
                ));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(json);
        response.setStatus(status);
        return response;
    }
}
