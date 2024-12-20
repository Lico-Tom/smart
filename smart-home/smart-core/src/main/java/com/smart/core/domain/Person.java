package com.smart.core.domain;

import javax.crypto.Cipher;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author Lico-Tom
 * 2024/3/15 0:19
 * @version V1.0
 */
public class Person {

    String name;

    /**
     * 私钥:
     */
    PrivateKey sk;

    /**
     * 公钥:
     */
    PublicKey pk;

    public Person(String name) throws GeneralSecurityException {
        this.name = name;
        // 生成公钥／私钥对:
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair kp = kpGen.generateKeyPair();
        this.sk = kp.getPrivate();
        this.pk = kp.getPublic();
    }

    /**
     * 把私钥导出为字节
     * @return
     */
    public byte[] getPrivateKey() {
        return this.sk.getEncoded();
    }

    /**
     * 把公钥导出为字节
     * @return
     */
    public byte[] getPublicKey() {
        return this.pk.getEncoded();
    }

    /**
     * 用公钥加密:
     * @param message
     * @return
     * @throws GeneralSecurityException
     */
    public byte[] encrypt(byte[] message) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, this.pk);
        return cipher.doFinal(message);
    }

    /**
     * 用私钥解密:
     * @param input
     * @return
     * @throws GeneralSecurityException
     */
    public byte[] decrypt(byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.sk);
        return cipher.doFinal(input);
    }

}
