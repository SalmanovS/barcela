package com.barcelaSpring.entity;

import java.time.LocalDateTime;

public class test {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String order = String.valueOf(localDateTime.getDayOfMonth() +""+ localDateTime.getMonthValue() +""+ localDateTime.getYear() +""+
                localDateTime.getHour() +""+localDateTime.getMinute() +""+ localDateTime.getSecond());

        System.out.println(order);
    }
}
