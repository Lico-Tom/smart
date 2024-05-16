package com.smart.core.algorithm;

import com.smart.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lico-Tom
 * 2024/4/23 0:19
 * @version V1.0
 */
public class DESAlgTest extends BaseTest {

    @Test
    public void testEncrypt() {
        String encryptStr = DesAlg.getEncryptString("root");
        Assert.assertEquals("WnplV/ietfQ=", encryptStr);
    }

    @Test
    public void testDecrypt() {
        String decryptStr = DesAlg.getDecryptString("WnplV/ietfQ=");
        Assert.assertEquals("root", decryptStr);
    }

    @Test
    public void testEncryptAndDecrypt() {
        String encryptStr = DesAlg.getEncryptString("123456");
        String decryptStr = DesAlg.getDecryptString(encryptStr);
        Assert.assertEquals("123456", decryptStr);
    }
}
