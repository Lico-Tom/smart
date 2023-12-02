package com.smart.rest.api.controller;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.rest.api.domain.ScheduleTask;
import com.smart.rest.api.service.ScheduleTaskService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author Lico-Tom
 * 2023/11/5 9:00
 * @version V1.0
 */
@Validated
@RestController
@Tag(name = "ScheduleTask")
@RequestMapping(value = "${base-task-url}")
public class ScheduleTaskController {

    private final ScheduleTaskService scheduleTaskService;

    private final QrConfig qrConfig;

    @Autowired
    public ScheduleTaskController(ScheduleTaskService scheduleTaskService, QrConfig qrConfig) {
        this.scheduleTaskService = scheduleTaskService;
        this.qrConfig = qrConfig;
    }

    @PostMapping
    @ApiResponses(
            @ApiResponse(responseCode = "201", description = "请求成功")
    )
    public ResponseEntity<Boolean> saveOneScheduleTask(@RequestBody @Validated ScheduleTask scheduleTask) {
        return new ResponseEntity<>(scheduleTaskService.saveOrUpdate(scheduleTask), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{task_id}")
    @ApiResponses(
            @ApiResponse(responseCode = "201", description = "请求成功")
    )
    public ResponseEntity<Boolean> deleteScheduleTask(@PathVariable("task_id") @NotNull String taskId) {
        return new ResponseEntity<>(scheduleTaskService.removeById(taskId), HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "请求成功")
    )
    public ResponseEntity<List<ScheduleTask>> fetchAllScheduleTask() {
        return new ResponseEntity<>(scheduleTaskService.list(), HttpStatus.OK);
    }

    @GetMapping("/schedule-task")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "请求成功")
    )
    public ResponseEntity<List<ScheduleTask>> fetchScheduleTasksByScheduleTask(@RequestBody ScheduleTask scheduleTask) {
        return new ResponseEntity<>(scheduleTaskService.fetchScheduleTasksByScheduleTask(scheduleTask), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "请求成功")
    )
    public ResponseEntity<Void> fetchScheduleTaskQrCodeByTaskId(HttpServletResponse response,
                                                                @PathVariable("id") long id) throws IOException {
        String scheduleTaskStr = new ObjectMapper().writeValueAsString(scheduleTaskService.getById(id));
        QrCodeUtil.generate(scheduleTaskStr, qrConfig, "png", response.getOutputStream());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
