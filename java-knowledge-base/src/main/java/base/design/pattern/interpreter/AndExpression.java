package base.design.pattern.interpreter;

/**
 * @author: zhangluping
 * @description:
 * 非终结符表达式（NonTerminal Expression）角色：
 * 也是抽象表达式的子类，用来实现文法中与非终结符相关的操作，文法中的每条规则都对应于一个非终结符表达式。
 * @date:2019/2/19 19:34
 */
public class AndExpression extends AbstractExpression {
    private AbstractExpression expression1 = null;
    private AbstractExpression expression2 = null;

    public AndExpression(AbstractExpression expression1, AbstractExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String str) {
        return expression1.interpret(str) && expression2.interpret(str);
    }
}
