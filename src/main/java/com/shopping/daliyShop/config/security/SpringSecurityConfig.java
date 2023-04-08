package com.shopping.daliyShop.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginIdPwValidator loginIdPwValidator;

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
                .antMatchers("/index", "/loginTest","/test/**","/thymeleafTest").permitAll() /* 인증이 필요하지 않은 경로를 예외처리함 (추가로 넣기 위해서는 ,로 구분해 주거나 *를 사용하면 됨) */
                .anyRequest().authenticated() /* 어떠한 URL로 접근하던지 인증이 필요함을 설정 */
            .and()
                .formLogin() /* FORM 방식 로그인을 사용할 것임을 알림 */
                .loginPage("/loginTest")
                .loginProcessingUrl("/loginProc")
                .usernameParameter("usrId")
                .passwordParameter("usrPw")
                .defaultSuccessUrl("/index", true) /* 로그인 성공시 이동할 URL을 적음 */
                .permitAll()
            .and()
                .logout() /* 로그아웃 기능 추가 */
            .and()
                .csrf().disable(); /* csrf 토큰 비활성화 */
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginIdPwValidator);
    }
}
