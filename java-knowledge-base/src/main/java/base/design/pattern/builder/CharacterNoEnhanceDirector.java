package base.design.pattern.builder;

/**
 * Director -- 指挥者 -- 游戏角色创建
 * @author zhangluping on 2018/12/25.
 */
public class CharacterNoEnhanceDirector {
    /**
     * 逐步构建复杂产品对象
     */
    public Character construct(AbstractCharacterBuilder characterBuilder) {
        Character character;
        characterBuilder.buildClazz();
        characterBuilder.buildSex();
        characterBuilder.buildFace();
        characterBuilder.buildSkinColor();
        characterBuilder.buildSkills();
        characterBuilder.buildRace();
        character = characterBuilder.createCharacter();
        return character;
    }
}
