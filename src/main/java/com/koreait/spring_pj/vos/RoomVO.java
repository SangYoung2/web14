package com.koreait.spring_pj.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RoomVO {
    private int roomNo;
    private int roomSize;
    private int roomPrice;
}
