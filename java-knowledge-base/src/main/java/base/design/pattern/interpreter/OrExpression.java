package base.design.pattern.interpreter;

/**
 * @author: zhangluping
 * @description:
 * @date:2019/2/19 19:34
 */
public class OrExpression extends AbstractExpression {
    private AbstractExpression expression1 = null;
    private AbstractExpression expression2 = null;

    public OrExpression(AbstractExpression expression1, AbstractExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String str) {
        return expression1.interpret(str) || expression2.interpret(str);
    }
}
