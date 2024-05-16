package com.smart.core.algorithm;

import com.smart.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author Lico-Tom
 * 2024/4/23 0:25
 * @version V1.0
 */
public class MD5AlgTest extends BaseTest {

    @Test
    public void testMD5() {
        String str = "123456";
        String md5 = Md5Alg.deconde(str);
        Assert.assertEquals("s05bse6q2qlb9qblls96s592y55y556s", md5);
    }
}
