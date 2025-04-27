package com.smart.core.algorithm;

import com.smart.core.domain.Person;
import org.junit.jupiter.api.Test;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/**
 * @author Lico-Tom
 * 2024/4/23 0:29
 * @version V1.0
 */
public class RSAAlgTest {


    @Test
    public void testRSA() throws GeneralSecurityException {
        // 明文:
        byte[] plain = "Hello, encrypt use RSA".getBytes(StandardCharsets.UTF_8);
        // 创建公钥／私钥对:
        Person alice = new Person("Alice");
        // 用Alice的公钥加密:
        byte[] pk = alice.getPublicKey();
        System.out.printf("public key: %x%n", new BigInteger(1, pk));
        byte[] encrypted = alice.encrypt(plain);
        System.out.printf("encrypted: %x%n", new BigInteger(1, encrypted));
        // 用Alice的私钥解密:
        byte[] sk = alice.getPrivateKey();
        System.out.printf("private key: %x%n", new BigInteger(1, sk));
        byte[] decrypted = alice.decrypt(encrypted);
        System.out.println(new String(decrypted, StandardCharsets.UTF_8));
    }
}
