package com.koreait.spring_pj.service;

import com.koreait.spring_pj.dto.ReserveBoardDTO;
import com.koreait.spring_pj.mapper.ManagerMapper;
import com.koreait.spring_pj.vos.RoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    public List<ReserveBoardDTO> get_all_rooms(){
        return managerMapper.get_all_rooms();
    }

    //방 추가
    public boolean post_room(RoomVO roomVO){
        return managerMapper.post_room(roomVO);
    }
}
