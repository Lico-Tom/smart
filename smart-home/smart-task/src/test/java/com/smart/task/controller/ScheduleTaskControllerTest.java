package com.smart.task.controller;

import com.smart.task.controller.ScheduleTaskController;
import com.smart.task.service.ScheduleTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;


/**
 * @author Lico-Tom
 * 2023/11/8 22:21
 * @version V1.0
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ScheduleTaskController.class)
public class ScheduleTaskControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ScheduleTaskService scheduleTaskService;

    @Value("${base-task-url:/v1/task}")
    private String bashTask;


    @Test
    public void testFetchAllScheduleTask() throws Exception {
        BDDMockito.given(this.scheduleTaskService.list()).willReturn(new ArrayList<>());
        mvc.perform(MockMvcRequestBuilders
                .get(bashTask)
                .header("Content-Type", "application/json"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }
}
