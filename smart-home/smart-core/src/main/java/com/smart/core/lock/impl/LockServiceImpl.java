package com.smart.core.lock.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.core.domain.Lock;
import com.smart.core.lock.LockService;
import com.smart.core.mapper.LockMapper;
import org.springframework.stereotype.Service;

/**
* @author lizhonghao
* @description 针对表【t_lock】的数据库操作Service实现
* @createDate 2023-11-02 22:52:46
*/
@Service
public class LockServiceImpl extends ServiceImpl<LockMapper, Lock>
    implements LockService{

    @Override
    public boolean isTryLock(Lock lock) {
        return save(lock);
    }

    @Override
    public void stopLock(Lock lock) {
        removeById(lock);
    }
}




