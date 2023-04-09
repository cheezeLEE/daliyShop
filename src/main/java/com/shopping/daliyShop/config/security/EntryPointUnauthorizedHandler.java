package com.shopping.daliyShop.config.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint { /* 인증되지 않은 경우 예외처리를 위한 인터페이스 구현 */

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); /* 권한이 없으므로 401상태 반환 */
        response.sendRedirect(getRedirectTargetUrl(request)); /* 권한이 없으면 이전 페이지로 리다이렉트함 */
    }

    /* 이전 페이지의 URI를 받아옴 */
    private String getRedirectTargetUrl(HttpServletRequest request) {
        String referer = request.getHeader("referer");
        String target = "";
        /* 이전 페이지가 null이거나 login상태가 없으면 파라미터 추가 */
        if(referer == null || !referer.contains("login=false")){
            target = "?login=false";
        }
        return referer != null ? referer + target : "/index" + target;
    }
}
