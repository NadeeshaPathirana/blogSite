package com.blog.blogSite.service.authservice.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.blogSite.exception.AuthenticationException;
import com.blog.blogSite.service.authservice.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * handles the user logins and authenticate the API requests
 */
@Component
public class ApplicationLoginInterceptor extends HandlerInterceptorAdapter {

    private final Logger log = LogManager.getLogger(getClass());

    /**
     * the request header parameter
     * authorization = "basic dGVzdDp0ZXN0" (for the hardcoded user name and password)
     */
    private static final String AUTH_HEADER_PARAMETER_AUTHERIZATION = "authorization";

    /**
     * user name and the password are hardcoded values
     */
    @Value("test")
    private String userName;

    @Value("test")
    private String password;

    @Autowired
    private AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Boolean isValidBasicAuthRequest = false;

        log.info("[Inside PRE Handle interceptor][" + request + "]" + "[" + request.getMethod() + "]"
                + request.getRequestURI());

        try {

            // get header value from request header
            String basicAuthHeaderValue = request.getHeader(AUTH_HEADER_PARAMETER_AUTHERIZATION);

            // process authentication
            isValidBasicAuthRequest = authService.validateBasicAuthentication(userName, password, basicAuthHeaderValue);

            // If this is invalid request
            if (!isValidBasicAuthRequest) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                throw new AuthenticationException();
            }

        } catch (Exception e) {
            log.error("Error occurred while authenticating the request : " + e.getMessage());
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }

        return isValidBasicAuthRequest;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        log.info("[Inside POST Handle Interceptor]" + request.getRequestURI());

    }

}
