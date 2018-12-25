package base.design.pattern.builder;

/**
 * ConcreteBuilder -- 具体建造者 -- 亡灵角色建造器
 *
 * @author zhangluping on 2018/12/25.
 */
public class UnDeadBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("亡灵");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("丑");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("破衣烂衫");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("寥寥几根");
    }
}
