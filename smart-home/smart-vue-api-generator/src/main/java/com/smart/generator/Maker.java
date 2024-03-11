package com.smart.generator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lico-Tom
 * 2023/12/21 23:18
 * @version V1.0
 */
@Slf4j
@Component
public class Maker implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println(applicationContext);
        Class<? extends RestController> rcClazz = applicationContext.getBean(RestController.class).getClass();
        Class<? extends Controller> cClazz = applicationContext.getBean(Controller.class).getClass();
        List<Method> methods = new ArrayList<>(Arrays.asList(rcClazz.getMethods()));
        methods.addAll(Arrays.asList(cClazz.getMethods()));
        RequestDto requestDto1 = methods.stream().map(method -> {
            RequestDto requestDto = new RequestDto();
            parseGetMapping(requestDto, method.getAnnotation(GetMapping.class));
            parsePostMapping(requestDto, method.getAnnotation(PostMapping.class));
            parseDeleteMapping(requestDto, method.getAnnotation(DeleteMapping.class));
            parsePutMapping(requestDto, method.getAnnotation(PutMapping.class));
            parseRequestMapping(requestDto, method.getAnnotation(RequestMapping.class));
            return requestDto;
        }).findFirst().orElse(new RequestDto());
    }

    private <T> void parseGetMapping(RequestDto requestDto, T getMapping) {
        if (getMapping == null) {
            return;
        }
        RequestMapping requestMapping = (RequestMapping) getMapping;
        String[] path = requestMapping.path();
        String name = requestMapping.name();
    }

    private void parsePostMapping(RequestDto requestDto, PostMapping postMapping) {

    }

    private void parseDeleteMapping(RequestDto requestDto, DeleteMapping deleteMapping) {

    }

    private void parsePutMapping(RequestDto requestDto, PutMapping putMapping) {

    }

    private void parseRequestMapping(RequestDto requestDto, RequestMapping requestMapping) {

    }

}
