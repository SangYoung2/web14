package com.koreait.spring_pj.mapper;

import com.koreait.spring_pj.domain.UserEntity;
import com.koreait.spring_pj.domain.UserRole;
import com.koreait.spring_pj.vos.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;
import java.util.Set;

@Mapper
public interface UserMapper {
    // 유저의 ID를 전달해서, 유저의 정보와 권한을 가지고 있는 VO객체를 반환하는 DB매핑
    UserVO userVO_with_roles(String userID);
    // 유저 회원가입1 - 회원 정보
    boolean user_register(UserEntity userEntity);
    // 유저 회원가입2 - 권한 설정
    boolean user_register_authorize(String userID);
}







