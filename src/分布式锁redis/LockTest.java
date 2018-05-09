/*
package 分布式锁redis;

*/
/**
 * Company lenovo.com
 * Copyright (C) 1984-2018 All Rights Reserved.
 *
 * @author david
 * @version LockTest.java, v 0.1 2018-05-08 下午2:46 david
 * @project Test
 *//*

public class LockTest {
    public void drawRedPacket(long userId) {
        String key = "draw.redpacket.userid:" + userId;

        boolean lock = RedisLockUtil.lock2(key, 60);
        if(lock) {
            try {
                //领取操作
            } finally {
                //释放锁
                RedisLockUtil.unLock(key);
            }
        } else {
            new RuntimeException("重复领取奖励");
        }
    }
}
*/
