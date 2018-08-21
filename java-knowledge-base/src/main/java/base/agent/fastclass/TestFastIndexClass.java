package base.agent.fastclass;

import org.junit.Test;

/**
 * @author zhangluping on 2018/8/21.
 */
public class TestFastIndexClass {

    /**
     * 测试fastclass的方法执行
     */
    @Test
    public void testFastIndex() {
        FastOrigin tt = new FastOrigin();
        FastIndex fc = new FastIndex();
        int index = fc.getIndex("first()");
        fc.invoke(index, tt, null);
    }
}
