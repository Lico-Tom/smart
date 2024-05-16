package com.smart.mail.service;

import com.smart.mail.entity.Sender;
import jakarta.mail.MessagingException;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author Lico-Tom
 * 2023/11/9 23:18
 * @version V1.0
 */
public interface MailSendService {

    /**
     * 发送多个图片
     * @param to
     * @param subject
     * @param content
     * @param map
     * @return
     */
    void sendInlineResource(String to, String subject, String content, Map<String, String> map);

    /**
     *  发送单个图片
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     * @return
     */
    void sendInlineResource(String to, String subject, String content, String rscPath, String rscId);

    /**
     * 发送多个带文件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePathList
     * @return
     */
    void sendAttachmentMail(String to, String subject, String content, List<String> filePathList);

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @return
     */
    void sendAttachmentMail(String to, String subject, String content, String filePath);


    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param file
     * @return
     */
    void sendAttachmentMail(String to, String subject, String content, File file);

    /**
     * 发送HTML
     * @param to
     * @param subject
     * @param content
     * @return
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送文本
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleMail(String to, String subject, String content);
}
