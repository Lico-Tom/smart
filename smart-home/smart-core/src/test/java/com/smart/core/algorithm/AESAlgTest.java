package com.smart.core.algorithm;

import com.smart.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;

/**
 * @author Lico-Tom
 * 2024/3/15 0:52
 * @version V1.0
 */
public class AESAlgTest extends BaseTest {

    // 128位密钥 = 16 bytes Key:
    private final String key128 = "1234567890abcdef";

    private final byte[] data = "你好123".getBytes(StandardCharsets.UTF_8);

    @Test
    public void testEncryptECBCase() throws GeneralSecurityException {
        // 加密:
        byte[] encrypted = AesAlg.encryptEcb(key128, data);
        String encode = Base64.getEncoder().encodeToString(encrypted);
        Assert.assertEquals("s7kwvyytZiTe4pkSg332zg==", encode);
    }

    @Test
    public void testDecryptECBCase() throws GeneralSecurityException {
        // 解密:
        String decrypted = AesAlg.decryptEcb(key128, "s7kwvyytZiTe4pkSg332zg==");
        System.out.println("Decrypted: " + decrypted);
        Assert.assertEquals(new String(data), decrypted);
    }
}
