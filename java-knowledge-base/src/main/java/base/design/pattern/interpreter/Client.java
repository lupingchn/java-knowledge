package base.design.pattern.interpreter;

/**
 * @author: zhangluping
 * @description:
 * 客户端（Client）：
 * 主要任务是将需要分析的句子或表达式转换成使用解释器对象描述的抽象语法树，
 * 然后调用解释器的解释方法，当然也可以通过环境角色间接访问解释器的解释方法。
 * @date:2019/2/19 19:35
 */
public class Client {
    /**
     * this method builds the interpreter tree
     * It defines the rule "Owen and (John or (Henry or Mary))"
     *
     * @return
     */
    static AbstractExpression buildInterpreterTree() {
        // Literal
        AbstractExpression terminal1 = new TerminalExpression("John");
        AbstractExpression terminal2 = new TerminalExpression("Henry");
        AbstractExpression terminal3 = new TerminalExpression("Mary");
        AbstractExpression terminal4 = new TerminalExpression("Owen");

        // Henry or Mary
        AbstractExpression alternation1 = new OrExpression(terminal2, terminal3);

        // John or (Henry or Mary)
        AbstractExpression alternation2 = new OrExpression(terminal1, alternation1);

        // Owen and (John or (Henry or Mary))
        return new AndExpression(terminal4, alternation2);
    }

    /**
     * main method - build the interpreter
     * and then interpret a specific sequence
     *
     * @param args
     */
    public static void main(String[] args) {

        String context = "Mary Owen";

        AbstractExpression define = buildInterpreterTree();

        System.out.println(context + " is " + define.interpret(context));
    }
}
