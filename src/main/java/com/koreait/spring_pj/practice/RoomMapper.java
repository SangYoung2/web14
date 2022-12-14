package com.koreait.spring_pj.practice;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper {
    Room get_room_with_user(int no);
}
