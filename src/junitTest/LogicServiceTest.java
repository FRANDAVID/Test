package junitTest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogicServiceTest {
    LogicService logserv ;

    @Before
    public void setUp() throws Exception {
        logserv = new LogicService();
    }

    @Test
    public void testAdd() {
        String a = "aa";
        String t = "a";
        String b = "a"+t;
        assertEquals("assertEquals", a, b) ; //A与B的关系是值相等，地址不相等，这个用例会成功
    }

    @Test
    public void testSub() {
        String a = "aa";
        String t = "a";
        String b = "a"+t;
        assertSame("assertSame", a, b) ; //A与B的关系是值相等，地址不相等,这个用例会失败
    }

    @Test
    public void testDiv() {
        assertTrue("assertTrue",true);//用例成功
        assertTrue("第二个为false失败",false);//用例失败
    }

    @Test
    public void testDiv2() {
        assertNull("assertNull",null);//用例成功
        assertNull("第二个为notNull失败","a");//用例失败
    }

    @Ignore
    public void testLoop() {
    }

    @Ignore
    public void testUnCompleted() {
    }

}