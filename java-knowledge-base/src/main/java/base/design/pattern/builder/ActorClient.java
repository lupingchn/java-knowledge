package base.design.pattern.builder;

/**
 * 客户端构建游戏角色
 *
 * @author zhangluping on 2018/12/25.
 */
public class ActorClient {

    public static Actor builderWithDirector() {
        // 针对抽象建造者编程
        ActorBuilder ab = new UnDeadBuilder();
        // 指挥者
        ActorDirector ac = new ActorDirector();
        //通过指挥者创建完整的建造者对象
        return ac.construct(ab);
    }

    private static Actor builderWithOutDirector() {
        return Actor.builder().type("兽人").sex("男").face("丑").costume("皮甲").hairstyle("光头").build();
    }


    public static void main(String[] args) {
        Actor actor = builderWithDirector();
        System.out.println(actor);

        actor = builderWithOutDirector();
        System.out.println(actor);
    }
}
