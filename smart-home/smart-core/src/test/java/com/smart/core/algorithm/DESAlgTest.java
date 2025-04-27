package com.smart.core.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author Lico-Tom
 * 2024/4/23 0:19
 * @version V1.0
 */
public class DESAlgTest {

    @Test
    public void testEncrypt() {
        String encryptStr = DesAlg.getEncryptString("root");
        Assertions.assertEquals("WnplV/ietfQ=", encryptStr);
    }

    @Test
    public void testDecrypt() {
        String decryptStr = DesAlg.getDecryptString("WnplV/ietfQ=");
        Assertions.assertEquals("root", decryptStr);
    }

    @Test
    public void testEncryptAndDecrypt() {
        String encryptStr = DesAlg.getEncryptString("123456");
        String decryptStr = DesAlg.getDecryptString(encryptStr);
        Assertions.assertEquals("123456", decryptStr);
    }
}
