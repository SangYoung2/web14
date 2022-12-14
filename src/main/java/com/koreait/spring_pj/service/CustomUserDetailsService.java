package com.koreait.spring_pj.service;

import com.koreait.spring_pj.dto.UserSecurityDTO;
import com.koreait.spring_pj.mapper.UserMapper;
import com.koreait.spring_pj.vos.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Log4j2
@Service
//UserDetailsService를 구현하는 객체는 스프링 시큐리티에서 인증을 처리하는 객체가 된다
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    //실제 인증을 처리할 때 아래 메소드가 자동으로 호출된다
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("------- loadUserByUsername - username: " + username);
        log.info("------- " + username + "이 로그인 시도 하였습니다 ---------- ");
        //1. 해당 username을 가지는 VO객체 DB에서 받아오기
        UserVO userVO = userMapper.userVO_with_roles(username);
        //2. 해당 VO 객체가 존재하지 않는다면, UsernameNotFoundException을 throw, 예외발생시킴
        if (userVO == null){
            throw new UsernameNotFoundException( username + ": --------- 해당 유저는 존재하지 않음 -------------");
        }

        //3) 해당 VO 객체가 존재한다면 DTO를 생성해서 반환시키기
        return new UserSecurityDTO(
                username,
                userVO.getUserPW(),
                userVO.getUserName(),
                userVO.getUserTel(),
                userVO.getUserEmail(),
                userVO.isUserSocial(),
                userVO.getUserRoles().stream()
                        .map(x -> new SimpleGrantedAuthority("ROLE_" + x.name()))
                        .collect(Collectors.toList())
        );
    }
}









