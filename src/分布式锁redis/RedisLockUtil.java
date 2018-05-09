//package 分布式锁redis;
//
//import cn.com.tpig.cache.redis.RedisService;
//import cn.com.tpig.utils.SpringUtils;
//
////redis分布式锁
//public final class RedisLockUtil {
//
//    private static final int defaultExpire = 60;
//
//    private RedisLockUtil() {
//        //
//    }
//
//    /**
//     * 加锁
//     * @param key redis key
//     * @param expire 过期时间，单位秒
//     * @return true:加锁成功，false，加锁失败
//     */
//    public static boolean lock(String key, int expire) {
//
//        RedisService redisService = SpringUtils.getBean(RedisService.class);
//        long status = redisService.setnx(key, "1");
//
//        if(status == 1) {
//            redisService.expire(key, expire);
//            return true;
//        }
//
//        return false;
//    }
//
//    public static boolean lock(String key) {
//        return lock2(key, defaultExpire);
//    }
//
//    /**
//     * 加锁
//     * @param key redis key
//     * @param expire 过期时间，单位秒
//     * @return true:加锁成功，false，加锁失败
//     */
//    public static boolean lock2(String key, int expire) {
//
//        RedisService redisService = SpringUtils.getBean(RedisService.class);
//
//        long value = System.currentTimeMillis() + expire;
//        long status = redisService.setnx(key, String.valueOf(value));
//
//        if(status == 1) {
//            return true;
//        }
//        long oldExpireTime = Long.parseLong(redisService.get(key, "0"));
//        if(oldExpireTime < System.currentTimeMillis()) {
//            //超时
//            long newExpireTime = System.currentTimeMillis() + expire;
//            long currentExpireTime = Long.parseLong(redisService.getSet(key, String.valueOf(newExpireTime)));
//            if(currentExpireTime == oldExpireTime) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void unLock1(String key) {
//        RedisService redisService = SpringUtils.getBean(RedisService.class);
//        redisService.del(key);
//    }
//
//    public static void unLock2(String key) {
//        RedisService redisService = SpringUtils.getBean(RedisService.class);
//        long oldExpireTime = Long.parseLong(redisService.get(key, "0"));
//        if(oldExpireTime > System.currentTimeMillis()) {
//            redisService.del(key);
//        }
//   }
//}