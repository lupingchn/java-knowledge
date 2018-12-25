package base.design.pattern.builder;

/**
 * Director -- 指挥者 -- 游戏角色创建
 * @author zhangluping on 2018/12/25.
 */
public class ActorDirector {
    /**
     * 逐步构建复杂产品对象
     */
    public Actor construct(ActorBuilder ab) {
        Actor actor;
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        actor = ab.createActor();
        return actor;
    }
}
