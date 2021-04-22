package com.tw.filters;

import com.tw.calculator.CalculatorConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
public class ServiceFilter implements Filter {
    @Autowired
    private CalculatorConfiguration calculatorConfiguration;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        try {
            Method method = calculatorConfiguration.getClass().getMethod("is" + StringUtils.capitalize(req.getRequestURI().substring(1)));
            boolean result = (boolean) method.invoke(calculatorConfiguration);
            if (result) {
                chain.doFilter(request, response);
            } else {

                ((HttpServletResponse) res).sendError(HttpServletResponse.SC_NOT_FOUND, "The Endpoint Is Not Found");
            }
        } catch (NoSuchMethodException e) {
            ((HttpServletResponse) res).sendError(HttpServletResponse.SC_NOT_FOUND, "The Endpoint Is Not Found");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            ((HttpServletResponse) res).sendError(HttpServletResponse.SC_NOT_FOUND, "The Endpoint Is Not Found");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            ((HttpServletResponse) res).sendError(HttpServletResponse.SC_NOT_FOUND, "The Endpoint Is Not Found");
            e.printStackTrace();
        }


    }
}
