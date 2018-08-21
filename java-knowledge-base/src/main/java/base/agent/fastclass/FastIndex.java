package base.agent.fastclass;

/**
 * @author zhangluping on 2018/8/21.
 */
public class FastIndex {
    public Object invoke(int index, Object o, Object[] ol) {
        FastOrigin t = (FastOrigin) o;
        switch (index) {
            case 1:
                t.first();
                return null;
            case 2:
                t.second();
                return null;
        }
        return null;
    }

    public int getIndex(String signature) {
        switch (signature.hashCode()) {
            case -849024079:
                return 1;
            case 943455349:
                return 2;
        }
        return -1;
    }
}
