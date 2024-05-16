package com.smart.task.ins;

import com.smart.task.Task;
import com.smart.task.domain.ScheduleTask;
import org.springframework.stereotype.Component;

/**
 * @author Lico-Tom
 * 2023/10/31 1:00
 * @version V1.0
 */
@Component
public class SummarySheetTask implements Task {

    @Override
    public void execute(ScheduleTask info) {
        // todo
        System.out.println(info.getTaskName());
    }
}
