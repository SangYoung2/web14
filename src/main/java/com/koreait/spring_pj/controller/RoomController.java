package com.koreait.spring_pj.controller;

import com.koreait.spring_pj.dto.ReserveBoardDTO;
import com.koreait.spring_pj.service.ManagerService;
import com.koreait.spring_pj.vos.RoomVO;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private ManagerService managerService;

    @GetMapping()
    public List<ReserveBoardDTO> get_rooms(){
        return managerService.get_all_rooms();
    }

    @PostMapping()
    public void post_room(
            @RequestBody RoomVO roomVO
    ){
        log.info("=== POST ROOM (방 추가)실행 ===");
        managerService.post_room(roomVO);
    }

    @DeleteMapping
    public void delete_room(){
        log.info("=== DELETE ROOM (방 삭제)실행 ===");

    }
}
