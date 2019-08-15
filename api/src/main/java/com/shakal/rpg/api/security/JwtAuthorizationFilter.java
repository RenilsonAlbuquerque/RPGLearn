package com.shakal.rpg.api.security;



import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.shakal.rpg.api.handler.SecurityHandlerExceptionBuilder;
import com.shakal.rpg.api.utils.Messages;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException{

        HttpServletResponse resp = (HttpServletResponse) response;
        try{
        	AuthenticationContext authentication = JwtTokenProvider
                    .getAuthentication((HttpServletRequest) request);

            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        }catch (SignatureException ex) {
            SecurityHandlerExceptionBuilder.handleError(resp,HttpServletResponse.SC_UNAUTHORIZED,
                    new BadCredentialsException(Messages.INVALID_TOKEN));
        }catch (MalformedJwtException ex1) {
            SecurityHandlerExceptionBuilder.handleError(resp,HttpServletResponse.SC_UNAUTHORIZED,
                    new BadCredentialsException(Messages.INVALID_TOKEN_FORMAT));
        }catch (BadCredentialsException ex2) {
            SecurityHandlerExceptionBuilder.handleError(resp,HttpServletResponse.SC_UNAUTHORIZED,ex2);
        }catch (Exception ex3) {
        	ex3.printStackTrace();
            SecurityHandlerExceptionBuilder.handleError(resp,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,ex3);
        }
    }


}