package com.example.webrtcvideocalls.redis;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 방 생성
     * @param key
     * @return
     */
    @GetMapping ("/room/set/{key}")
    @ResponseBody
    public String setRoom(@PathVariable String key) {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();

        // 랜덤 방 번호 지정 5글자
        Random rnd = new Random();
        StringBuffer sb = new StringBuffer();
        for( int i = 0; i < 5; i++) sb.append((rnd.nextInt(10)));
        vop.set(key, sb.toString());
        return "success";
    }

    /**
     * 방 가져오기
     * @param key
     * @return
     */
    @GetMapping("/room/get/{key}")
    @ResponseBody
    public String getRoom(@PathVariable String key) {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        String value = vop.get(key);
        return value;
    }

    /**
     * 방 목록
     * @return
     */
    @GetMapping("/room/get")
    @ResponseBody
    public String getRoomAll() {
        Gson gson = new Gson();
        Set<String> redisKeys = redisTemplate.keys("*");
        List<String> keysList = new ArrayList<>();
        if (redisKeys != null) {
            keysList.addAll(redisKeys);
        }
        return gson.toJson(keysList);
    }
}
