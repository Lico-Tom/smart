package com.smart.core.algorithm;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.*;
 
 
/**
 * @author lizhonghao
 */
public class AesAlg {

 
    /**
     * String类型加密:
     * @param key
     * @param input
     * @return
     * @throws GeneralSecurityException
     */
    public static String encryptEcb(String key, String input) throws GeneralSecurityException {
        byte[] bytes = AesAlg.encryptEcb(key, input.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 加密:
     * @param key
     * @param input
     * @return
     * @throws GeneralSecurityException
     */
    public static byte[] encryptEcb(String key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }

    /**
     * 解密:
     * @param key
     * @param input
     * @return
     * @throws GeneralSecurityException
     */
    public static String decryptEcb(String key, String input) throws GeneralSecurityException {
        byte[] bytes = AesAlg.decryptEcb(key, Base64.getDecoder().decode(input));
        return new String( bytes, StandardCharsets.UTF_8);
    }

    /**
     * 解密:
     * @param key
     * @param input
     * @return
     * @throws GeneralSecurityException
     */
    public static byte[] decryptEcb(String key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }


    /**
     * 加密:
     * @param key
     * @param input
     * @return
     * @throws GeneralSecurityException
     */
    public static byte[] encryptCbc(String key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        // CBC模式需要生成一个16 bytes的initialization vector:
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] iv = sr.generateSeed(16);
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivps);
        byte[] data = cipher.doFinal(input);
        // IV不需要保密，把IV和密文一起返回:
        return join(iv, data);
    }

    /**
     * 解密:
     * @param key
     * @param input
     * @return
     * @throws GeneralSecurityException
     */
    public static byte[] decryptCbc(String key, byte[] input) throws GeneralSecurityException {
        // 把input分割成IV和密文:
        byte[] iv = new byte[16];
        byte[] data = new byte[input.length - 16];
        System.arraycopy(input, 0, iv, 0, 16);
        System.arraycopy(input, 16, data, 0, data.length);
        // 解密:
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivps);
        return cipher.doFinal(data);
    }
 
    public static byte[] join(byte[] bs1, byte[] bs2) {
        byte[] r = new byte[bs1.length + bs2.length];
        System.arraycopy(bs1, 0, r, 0, bs1.length);
        System.arraycopy(bs2, 0, r, bs1.length, bs2.length);
        return r;
    }
 
}