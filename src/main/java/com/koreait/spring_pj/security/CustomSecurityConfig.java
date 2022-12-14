package com.koreait.spring_pj.security;

import com.koreait.spring_pj.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Log4j2
@Configuration
@EnableWebSecurity //WebSecurity를 사용하겠다는 의미
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true) //어노테이션으로 권한을 설정하기 위해서 붙여주는 어노테이션 (Security 설정 클래스에 붙여주면 된다) (prePostEnabled => 요청을 했을 때 처리하기 전에 시큐리티 활성화시킴)
public class CustomSecurityConfig {
    private final DataSource dataSource;
    private final CustomUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        log.info("-------- security configure ------------");
        //로그인 페이지 커스텀 세팅
        http.formLogin()
                .loginPage("/users/login")
                .successForwardUrl("/board");
        //CSRF 토큰 비활성화
        http.csrf().disable();
        //자동 로그인 설정
        http.rememberMe()
                .key("12345678")
                .tokenRepository(persistentTokenRepository())
                .userDetailsService(userDetailsService)
                .tokenValiditySeconds(60*60*24*30); //30일

        //oauth2 로그인 관련 설정 (카카오 로그인 설정)
        http.oauth2Login().loginPage("/users/login");

        return http.build();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
        repository.setDataSource(dataSource);
        return repository;
    }

    //정적 자원 (static 자원, css, js, image파일 등)을 시큐리티 적용에서 제외시키는 설정
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        log.info(" ------------- web security customizer configure ----------");
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
