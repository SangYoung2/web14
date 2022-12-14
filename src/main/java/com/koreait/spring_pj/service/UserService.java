package com.koreait.spring_pj.service;

import com.koreait.spring_pj.domain.UserEntity;
import com.koreait.spring_pj.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public boolean user_register(UserEntity userEntity){
        //정직하게 회원가입 버튼을 통해 회원가입한 회원
        //해당 유저의 비밀번호를 인코딩해서 전송한다
        userEntity.setUserPW(passwordEncoder.encode(userEntity.getUserPW()));
        userEntity.setUserSocial(false);
        //해당 유저를 회원가입 시키고 권한 부여한다
        return mapper.user_register(userEntity) && mapper.user_register_authorize(userEntity.getUserID());
    }
}






