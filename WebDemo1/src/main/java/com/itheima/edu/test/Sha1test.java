package com.itheima.edu.test;

import org.apache.commons.codec.digest.DigestUtils;

public class Sha1test {
    public static void main(String[] args) {
        System.out.println(DigestUtils.sha1Hex("Hello world"));
        System.out.println(DigestUtils.sha512Hex("Hello world"));
    }
}
