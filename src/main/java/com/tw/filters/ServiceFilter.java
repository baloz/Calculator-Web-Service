package com.tw.filters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("unused")
@Component
public class ServiceFilter implements Filter {


    @Value("${calculatorapi.multiply}")
    private boolean enableMultiplication;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;


        if (req.getRequestURI().equals("/multiply") && !enableMultiplication){
            res.sendError(HttpServletResponse.SC_NOT_FOUND, "The Endpoint Is Not Found");
            System.out.println(enableMultiplication);
        }
        else{
            chain.doFilter(request, response);
        }


    }
}
