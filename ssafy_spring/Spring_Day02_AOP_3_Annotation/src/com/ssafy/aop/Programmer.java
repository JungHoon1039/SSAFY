package com.ssafy.aop;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Programmer implements Person {
    // 필드는 생략

    // 프로그래머의 일상
    @Override
    public Integer coding() {
        System.out.println("열심히 코드를 작성한다."); // 핵심관심사항
        if (new Random().nextBoolean()) {
            throw new OuchException();
        }
        return (int) (Math.random() * 100) + 1;
    }
}
