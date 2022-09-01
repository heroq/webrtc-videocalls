package com.example.webrtcvideocalls.room;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {

    @GetMapping("/")
    public String index() {

        return "index";
    }
}
