package com.kazatustudent.helper.api.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class LoggerFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request,
                            HttpServletResponse response,
                            FilterChain chain) throws IOException, ServletException {

        log.info("from: {}, uri: {}, method: {}", request.getRemoteAddr(), request.getRequestURI(), request.getMethod());

        chain.doFilter(request, response);
    }
}
