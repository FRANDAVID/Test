package 问题排查btrace;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import static com.sun.btrace.BTraceUtils.println;
@BTrace
public class Tracer {
    @OnMethod(clazz = "java.lang.Thread", method = "start")
    public static void onThreadStart() {
        println("tracing method start");
    }
}