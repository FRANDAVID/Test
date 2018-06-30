/*
package 生产环境问题排查;


import java.nio.file.WatchEvent;


*/
/**
 * NumberUtilBTrace
 *
 * @author fengzheng
 * @date 2017/6/20
 *//*

@BTrace
public class NumberUtilBTrace {
 
    @OnMethod(
            clazz="NumberUtil",
            method="sum",
            location=@Location(WatchEvent.Kind.RETURN)
    )
    public static void func(@Return int result) {
        println("trace: =======================");
        println(strcat("result:", str(result)));
        jstack();
    }
}*/
