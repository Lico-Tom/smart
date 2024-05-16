package com.smart.core.config;

import cn.hutool.extra.qrcode.QrConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.Color;

/**
 * @author Lico-Tom
 * 2023/10/24 22:24
 * @version V1.0
 */
@Configuration
public class QrCodeConfig {

    @Bean
    public QrConfig qrConfig() {
        QrConfig qrConfig = new QrConfig();
        qrConfig.setBackColor(Color.white);
        qrConfig.setForeColor(Color.black);
        return qrConfig;
    }
}
