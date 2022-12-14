package com.koreait.spring_pj.dto;

import com.koreait.spring_pj.vos.ReserveVO;
import com.koreait.spring_pj.vos.RoomVO;
import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@ToString
public class ReserveBoardDTO {
    ReserveVO reserveVO;
    RoomVO roomVO;
}
