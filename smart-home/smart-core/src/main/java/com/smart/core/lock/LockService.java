package com.smart.core.lock;

import com.smart.core.domain.Lock;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lizhonghao
* @description 针对表【t_lock】的数据库操作Service
* @createDate 2023-11-02 22:52:46
*/
public interface LockService extends IService<Lock> {


    /**
     * 是否锁成功
     * @Param lock 锁信息
     * @return 锁住返回true，没锁住返回false
     */
    boolean isTryLock(Lock lock);

    /**
     *  释放锁
     * @Param lock 锁信息
     */
    void stopLock(Lock lock);

}
