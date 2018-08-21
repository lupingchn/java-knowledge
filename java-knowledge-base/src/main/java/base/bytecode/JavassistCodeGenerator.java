package base.bytecode;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

/**
 * @author zhangluping on 2018/8/21.
 */
public class JavassistCodeGenerator {

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        //创建Programmer类
        CtClass cc = pool.makeClass("com.samples.JavassistProgrammer");
        //定义code方法
        CtMethod method = CtNewMethod.make("public void code(){}", cc);
        //插入方法代码
        method.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");
        cc.addMethod(method);
        //保存生成的字节码
        cc.writeFile("d://");
    }

}
