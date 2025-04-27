package com.smart.mail.service.impl;

import com.smart.mail.service.MailSendService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author Lico-Tom
 * 2023/11/9 23:11
 * @version V1.0
 */
@Service
public class MailSendServiceImpl implements MailSendService {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailSendServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void sendInlineResource(String to, String subject, String content, Map<String, String> map) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            for (Map.Entry<String, String> stringEntry : map.entrySet()) {
                FileSystemResource resource = new FileSystemResource(new File(stringEntry.getValue()));
                helper.addInline(stringEntry.getKey(), resource);
            }
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendInlineResource(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            /**
             * 第二个参数，是否带HTML格式
             */
            helper.setText(content, true);
            FileSystemResource resource = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, resource);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, List<String> filePathList) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            for (String filePath : filePathList) {
                FileSystemResource file = new FileSystemResource(new File(filePath));
                String filename = file.getFilename();
                helper.addAttachment(filename, file);
            }
            helper.setTo(to);
            helper.setFrom(from);
            helper.setText(content, true);
            helper.setSubject(subject);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, String filePath) {
        this.sendAttachmentMail(to, subject, content, new File(filePath));
    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, File file) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setText(content, true);
            helper.setSubject(subject);
            helper.addAttachment(file.getName(), new FileSystemResource(file));
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setText(content, true);
            helper.setSubject(subject);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage sml = new SimpleMailMessage();
        sml.setFrom(from);
        sml.setSubject(subject);
        sml.setText(content);
        sml.setTo(to);
        javaMailSender.send(sml);
    }

}
