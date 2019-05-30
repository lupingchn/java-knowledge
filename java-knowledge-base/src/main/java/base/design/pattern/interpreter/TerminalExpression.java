package base.design.pattern.interpreter;

import java.util.StringTokenizer;

/**
 * @author: zhangluping
 * @description:
 * 终结符表达式（Terminal Expression）角色：
 * 是抽象表达式的子类，用来实现文法中与终结符相关的操作，文法中的每一个终结符都有一个具体终结表达式与之相对应。
 * @date:2019/2/19 18:22
 */
public class TerminalExpression extends AbstractExpression {
    private String literal = null;

    public TerminalExpression(String str) {
        literal = str;
    }

    @Override
    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            String test = st.nextToken();
            if (test.equals(literal)) {
                return true;
            }
        }
        return false;
    }
}
