package com.smart.generator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

/**
 * @author Lico-Tom
 * 2023/12/17 9:04
 * @version V1.0
 */
@Slf4j
public class StrInstead {


    public void replace(String url, String method, String body, String funcName, String clsName) throws IOException {
        String fileName = String.format("vue-axios-%s.txt", method);
        URL fileUrl = StrInstead.class.getClassLoader().getResource(fileName);
        String restTemplate = readRestTemplate(fileUrl, method);
        String router = restTemplate.replace("${url}", url)
                .replace("${body}", body)
                .replace("${funcName}", funcName);
        String fileJs = fileUrl.getPath().replace(fileName, clsName + ".js");
        writer(fileJs, router);
    }

    private String readRestTemplate(@NonNull URL url, String method) throws FileNotFoundException {
        StringBuilder buffer = new StringBuilder();
        File file = new File(url.getFile());
        try (FileReader fr = new FileReader(file)) {
            //通过项目码表一次读取一个字符
            int b;
            char[] chars = new char[(int) file.length()];
            while ((b = fr.read(chars)) != -1) {
                buffer.append(new String(chars));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return buffer.toString();
    }

    private void writer(String fileName, String content) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            if (!newFile) {
                log.error("create file fail. %s", file.getName());
                return;
            }
        } else {
            content = "\n" + content;
        }
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(content);
        } catch (IOException e) {
            throw e;
        }

    }

    public static void main(String[] args) throws IOException {
        StrInstead strInstead = new StrInstead();
        strInstead.replace("/v1/smart", "get", "body", "fetchList", "demo");
    }
}
