package com.smart.task.controller;

import com.smart.BaseTest;
import com.smart.ControllerTest;
import com.smart.task.service.ScheduleTaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


/**
 * @author Lico-Tom
 * 2023/11/8 22:21
 * @version V1.0
 */
public class ScheduleTaskControllerTest extends BaseTest {


    @MockBean
    private ScheduleTaskService scheduleTaskService;

    @Value("${base-task-url:/v1/task}")
    private String bashTask;


    @Test
    public void testFetchAllScheduleTask() throws Exception {
        /*BDDMockito.given(this.scheduleTaskService.list()).willReturn(new ArrayList<>());
        mvc.perform(MockMvcRequestBuilders
                .get(bashTask)
                .header("Content-Type", "application/json"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));*/
    }
}
