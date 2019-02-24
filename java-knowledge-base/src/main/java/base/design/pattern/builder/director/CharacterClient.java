package base.design.pattern.builder.director;

import base.design.pattern.util.XMLUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 客户端构建游戏角色
 *
 * @author zhangluping on 2018/12/25.
 */
@Slf4j
public class CharacterClient {

    public static Character builderWithDirector(String roleName) {
        // 针对抽象建造者编程
        AbstractCharacterBuilder characterBuilder = (AbstractCharacterBuilder) XMLUtil.getBean(roleName);
        // 指挥者
        CharacterDirector characterDirector = new CharacterDirector();
        //通过指挥者创建完整的建造者对象
        return characterDirector.construct(characterBuilder);
    }

    public static void main(String[] args) {
        Character character = builderWithDirector("warriorBuilder");
        log.info("CharacterDirector ={}", character);

        character = builderWithDirector("masterBuilder");
        log.info("CharacterDirector ={}", character);
    }
}
