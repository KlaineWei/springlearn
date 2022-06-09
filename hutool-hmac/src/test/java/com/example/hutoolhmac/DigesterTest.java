package com.example.hutoolhmac;

import cn.hutool.crypto.digest.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DigesterTest {
    @Test
    public void md5() {
        String text = "HelloWorld";

// 第一种：创建Digester对象，执行加密
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String digestHex = md5.digestHex(text);
        System.out.println(digestHex);

// 第二种：执行使用DigestUtil
        String md5Hex = DigestUtil.md5Hex(text);
        System.out.println(md5Hex);
    }

    @Test
    public void sha1() {
        String text = "HelloWorld";

// 第一种：创建Digester对象，执行加密
        Digester md5 = new Digester(DigestAlgorithm.SHA1);
        String digestHex = md5.digestHex(text);
        System.out.println(digestHex);

// 第二种：执行使用DigestUtil
        String md5Hex = DigestUtil.sha1Hex(text);
        System.out.println(md5Hex);
    }

    @Test
    public void hmacmd5(){
        String password = "12345678abc";
        byte[] key = "password".getBytes();
        HMac mac = new HMac(HmacAlgorithm.HmacMD5, key);

        String macHex = mac.digestHex(password);
        System.out.println(macHex);
    }

    @Test
    public void hmacsha256(){
        String password = "12345678abc";
        byte[] key = "jsou@*^@^%$@@".getBytes();
        HMac mac = new HMac(HmacAlgorithm.HmacSHA256, key);

        String macBase64 = mac.digestBase64(password, true);
        System.out.println(macBase64);
    }
}

