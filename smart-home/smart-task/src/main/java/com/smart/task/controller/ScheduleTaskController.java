package com.smart.task.controller;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.task.domain.ScheduleTask;
import com.smart.task.service.ScheduleTaskService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author Lico-Tom
 * 2023/11/5 9:00
 * @version V1.0
 */
@CrossOrigin
@Validated
@RestController
@Tag(name = "ScheduleTask")
@RequestMapping(value = "/v1/task")
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

    @GetMapping("/list")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "请求成功")
    )
    public ResponseEntity<IPage<ScheduleTask>> fetchAllScheduleTask(ScheduleTask scheduleTask,
                                                                   @RequestParam(value = "pageSize", defaultValue = "5") String pageSize,
                                                                   @RequestParam(value = "currentPage", defaultValue = "1") String currentPage) {
        IPage<ScheduleTask> scheduleTasks = scheduleTaskService.list(scheduleTask, Integer.parseInt(pageSize), Integer.parseInt(currentPage));
        return new ResponseEntity<>(scheduleTasks, HttpStatus.OK);
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
