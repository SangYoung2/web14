package com.koreait.spring_pj.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Log4j2
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("===== OAuth2User loadUser =====");
        ClientRegistration clientRegistration = userRequest.getClientRegistration();
        // OAuth2User로 로그인한 클라이언트의 이름 => 카카오로그인 이므로 kakao가 나옴
        String clientName = clientRegistration.getClientName(); //kakao
        log.info("클라이언트 명: " + clientName);
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> paramMap = oAuth2User.getAttributes();
        paramMap.forEach((k, v) -> {
            log.info("KEY: " + k);
            log.info("VALUE: " + v);
        });

        String email = null;
        switch (clientName) {
            case "kakao":
                email = get_kakao_email(paramMap);
        }



        return oAuth2User;
    }

    private String get_kakao_email(Map<String, Object> paramMap){
        return (String)((Map)paramMap.get("kakao_account")).get("email");
    }
}
