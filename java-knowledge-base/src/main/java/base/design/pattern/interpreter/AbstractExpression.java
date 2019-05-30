package base.design.pattern.interpreter;

/**
 * @author: zhangluping
 * @description:
 * 抽象表达式（Abstract Expression）角色：
 * 定义解释器的接口，约定解释器的解释操作，主要包含解释方法 interpret()。
 * @date:2019/2/19 18:21
 */
public abstract class AbstractExpression {

    abstract public boolean interpret(String str);

}
