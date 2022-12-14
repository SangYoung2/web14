package com.koreait.spring_pj.vos;

import com.koreait.spring_pj.domain.UserEntity;
import com.koreait.spring_pj.domain.UserRole;
import lombok.*;
import java.util.Set;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserVO extends UserEntity {
    private Set<UserRole> userRoles;
}









