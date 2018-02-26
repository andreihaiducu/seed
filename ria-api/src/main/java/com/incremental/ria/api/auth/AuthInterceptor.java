package com.incremental.ria.api.auth;

import com.incremental.ria.api.exception.ExceptionType;
import com.incremental.ria.api.exception.RiaException;
import com.incremental.ria.repository.commons.HasRole;
import com.incremental.ria.repository.commons.UserRole;
import com.incremental.ria.repository.model.User;
import com.incremental.ria.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    private AuthService authService;
    private AuthManager authManager;

    @Autowired
    public AuthInterceptor(AuthService authService, AuthManager authManager) {
        this.authService = authService;
        this.authManager = authManager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;

            if(method.getMethod().getAnnotation(HasRole.class) != null) {
                String token = request.getHeader("X-Auth-Token");
                if (token == null) {
                    // TODO: throw exception
                }

                User user = authService.validateToken(token);

                authManager.setLoggedInUser(user);

                UserRole neededRole = method.getMethod().getAnnotation(HasRole.class).value();

                if (!user.getRoles().contains(neededRole)) {
                    throw new RiaException(ExceptionType.UNAUTHORIZED, "Permission denied");
                }
            }
        }
        return true;
    }
}