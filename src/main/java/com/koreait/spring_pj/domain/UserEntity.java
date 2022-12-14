package com.koreait.spring_pj.domain;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private String userID;
    private String userPW;
    private String userName;
    private String userTel;
    private String userEmail;
    private boolean userSocial;
}
