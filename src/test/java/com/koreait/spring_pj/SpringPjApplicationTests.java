package com.koreait.spring_pj;

import com.koreait.spring_pj.domain.UserRole;
import com.koreait.spring_pj.dto.ReserveBoardDTO;
import com.koreait.spring_pj.mapper.ManagerMapper;
import com.koreait.spring_pj.mapper.ReserveMapper;
import com.koreait.spring_pj.mapper.UserMapper;
import com.koreait.spring_pj.practice.RoomMapper;
import com.koreait.spring_pj.vos.UserVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@Log4j2
@SpringBootTest
class SpringPjApplicationTests {
    @Autowired
    ReserveMapper reserveMapper;
    @Autowired
    UserMapper userMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    ManagerMapper managerMapper;

    @Test
    void practice_test(){
        log.info(roomMapper.get_room_with_user(1));
    }

    @Test
    void contextLoads() {
        UserVO vo = userMapper.userVO_with_roles("admin");
        log.info(vo.getUserID());
        log.info(vo.getUserName());
        log.info(vo.getUserEmail());
        log.info(vo.getUserTel());
        log.info(vo.getUserRoles());
    }

    @Test
    void get_reservations(){
        List<ReserveBoardDTO> dtos = managerMapper.get_all_rooms();
        for (ReserveBoardDTO dto : dtos) {
            log.info(dto.getReserveVO());
            log.info(dto.getRoomVO());
        }
    }

}








