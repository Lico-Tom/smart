package com.smart.rest.api.controller;

import com.smart.rest.api.service.ScheduleTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Value("${base-task-url}")
    private String bashTask;


    @Test
    public void testFetchAllScheduleTask() throws Exception {
        given(this.scheduleTaskService.list()).willReturn(new ArrayList<>());
        mvc.perform(MockMvcRequestBuilders
                .get(bashTask)
                .header("Content-Type", "application/json"))
                .andExpect(status().is(HttpStatus.OK.value()));
    }
}
