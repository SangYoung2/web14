package com.koreait.spring_pj.vos;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReserveVO {
    private int reserveNo;
    private int reserveRoom;
    private String reserveUser;
    private LocalDate reserveDate;
}










