package base.design.pattern.builder.nodirector;

import lombok.extern.slf4j.Slf4j;

/**
 * 客户端构建游戏角色
 *
 * @author zhangluping on 2018/12/25.
 */
@Slf4j
public class CharacterClient {

    private static Character builderWithInnerBuilder() {
        return Character.builder().clazz("战士").race("兽人").sex("男").face("野兽").skinColor("黑").skill("冲锋").build();
    }

    public static void main(String[] args) {
        Character character = builderWithInnerBuilder();
        log.info("InnerBuilder ={}", character);
    }
}
