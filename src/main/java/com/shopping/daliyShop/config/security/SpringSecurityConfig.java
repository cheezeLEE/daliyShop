package com.shopping.daliyShop.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginIdPwValidator loginIdPwValidator;

    @Autowired
    private EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;

    /**
     * css, 이미지 파일 등의 경우 인증되지 않은 상태에서도 보여주기 위한 함수
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/fonts/**", "/scss/**", "/img/**","/favicon.ico"); /* /static/이 아닌 static 내부의 경로로 작성해야함 */
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/order").authenticated() /* 인증이 필요하지 않은 경로를 예외처리함 (추가로 넣기 위해서는 ,로 구분해 주거나 *를 사용하면 됨) */
                .anyRequest().permitAll() /* 어떠한 URL로 접근하던지 인증이 필요함을 설정 */
            .and()
                .exceptionHandling() /* 예외처리를 핸들링하기 위한 핸들러 사용 */
                    .authenticationEntryPoint(entryPointUnauthorizedHandler) /* 인증 인가 예외처리 핸들러 */
            .and()
                .formLogin() /* FORM 방식 로그인을 사용할 것임을 알림 */
                .loginPage("/loginTest")
                .loginProcessingUrl("/loginProc") /* 로그인 form의 action */
                .usernameParameter("userId") /* 로그인 form의 ID의 name */
                .passwordParameter("userPw") /* 로그인 form의 PW의 name */
//                .defaultSuccessUrl("/index", true) /* 로그인 성공시 이동할 URL을 적음 */
                .permitAll()
            .and()
                .logout() /* 로그아웃 기능 추가 */
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index")
                .addLogoutHandler(new LogoutHandler() { //logout이 성공했을 때 처리할 내용
                    @Override
                    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
                        HttpSession session = request.getSession();
                        session.invalidate();
                    }
                })
                .logoutSuccessHandler(new LogoutSuccessHandler() { //logout 시 이동할 url 및 더 많은 로직 구현 가능
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.sendRedirect("/index"); //로그아웃 시 로그인 할 수 있는 페이지로 이동하도록 처리한다.
                    }
                })
                .deleteCookies("remember-me")
            .and()
                .csrf().disable(); /* csrf 토큰 비활성화 */
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginIdPwValidator);
    }
}
