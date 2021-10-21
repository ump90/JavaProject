package com.example.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Objects;

@SpringBootTest
class RedisApplicationTests {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void testString() {
        redisTemplate.opsForValue().set("testString", "just4test");

        System.out.println(redisTemplate.opsForValue().get("testString"));
        boolean flag = Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent("testString", "hello world"));
        System.out.println(false);
    }

    @Test
    public void testHash() {
        redisTemplate.opsForHash().put("tom", "name", "Tom Smith");
        redisTemplate.opsForHash().put("tom", "age", 18);
        redisTemplate.opsForHash().entries("tom").forEach((o, o2) -> {
            System.out.println(o + ":" + o2);
        });
        redisTemplate.opsForHash().delete("tom", "age");
    }

    @Test
    public void testList() {
        redisTemplate.opsForList().leftPushAll("list", 1, 2, 3, 4);
        redisTemplate.opsForList().rightPush("list", 5);
        Long lastIndex = redisTemplate.opsForList().size("list") - 1L;
        List<Object> list = redisTemplate.opsForList().range("list", 0, lastIndex);

        list.forEach(s -> {
            System.out.println((Integer) s);
        });

    }

    @Test
    public void testSet() {
        redisTemplate.opsForSet().add("set", 1, 2, 3, 4, 5, 6, 7);
        Objects.requireNonNull(redisTemplate.opsForSet().members("set")).forEach(System.out::println);
        System.out.println(redisTemplate.opsForSet().randomMember("set"));
    }

    @Test
    public void testZset() {
        redisTemplate.opsForZSet().add("Zset", "1", 1);
        redisTemplate.opsForZSet().add("Zset", "2", 2);
        redisTemplate.opsForZSet().add("Zset", "3", 3);
        redisTemplate.opsForZSet().incrementScore("Zset", "3", 4);
        redisTemplate.opsForZSet().range("Zset", 0, -1).forEach(System.out::println);
        System.out.println(redisTemplate.opsForZSet().score("Zset", "3"));

    }

    @Test
    public void testCommon() {
        redisTemplate.keys("*").forEach(System.out::println);
        System.out.println(redisTemplate.hasKey("set"));
        System.out.println(redisTemplate.type("list").name());
        redisTemplate.delete("Zset");
        System.out.println(redisTemplate.hasKey("Zset"));
    }

}
