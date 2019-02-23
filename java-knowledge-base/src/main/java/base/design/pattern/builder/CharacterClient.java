package base.design.pattern.builder;

import lombok.extern.slf4j.Slf4j;

/**
 * 客户端构建游戏角色
 *
 * @author zhangluping on 2018/12/25.
 */
@Slf4j
public class CharacterClient {

    public static Character builderWithDirector() {
        // 针对抽象建造者编程
        AbstractCharacterBuilder characterBuilder = new WarriorBuilder();
        // 指挥者
        CharacterDirector characterDirector = new CharacterDirector();
        //通过指挥者创建完整的建造者对象
        return characterDirector.construct(characterBuilder);
    }

    public static Character builderWithNoEnhance() {
        // 针对抽象建造者编程
        AbstractCharacterBuilder characterBuilder = new WarriorBuilder();
        // 指挥者
        CharacterNoEnhanceDirector characterDirector = new CharacterNoEnhanceDirector();
        //通过指挥者创建完整的建造者对象
        return characterDirector.construct(characterBuilder);
    }

    private static Character builderWithInnerBuilder() {
        return Character.builder().clazz("战士").race("兽人").sex("男").face("野兽").skinColor("黑").skill("冲锋").build();
    }


    public static void main(String[] args) {
        Character character = builderWithDirector();
        log.info("CharacterDirector ={}", character);
        character = builderWithNoEnhance();
        log.info("CharacterNoEnhanceDirector ={}", character);
        character = builderWithInnerBuilder();
        log.info("InnerBuilder ={}", character);
    }
}
