package com.smart.task.event;

import com.smart.task.entity.DaemonTaskEntity;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Lico-Tom
 * 2023/10/31 6:52
 * @version V1.0
 */
@Component
public class DaemonTaskEvent {

    @EventListener(classes = {DaemonTaskEntity.class})
    public void DaemonTaskEventListener(DaemonTaskEntity entity) {

    }
}
