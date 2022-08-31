package com.example.webrtcvideocalls.room;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {

    @GetMapping("/main")
    public String main() {
        System.out.println("이것도?22223333");
        return "main";
    }
}
