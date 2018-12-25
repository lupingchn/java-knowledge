package base.design.pattern.builder;

/**
 * Builder -- 抽象建造者 -- 角色建造器
 *
 * @author zhangluping on 2018/12/25.
 */
public abstract class ActorBuilder {
    protected Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairstyle();

    /**
     * 返回一个完整的游戏角色对象
     */
    public Actor createActor() {
        return actor;
    }
}
