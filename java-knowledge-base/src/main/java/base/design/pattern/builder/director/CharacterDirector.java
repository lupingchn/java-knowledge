package base.design.pattern.builder.director;

/**
 * Director -- 指挥者 -- 游戏角色创建
 * @author zhangluping on 2018/12/25.
 */
public class CharacterDirector {
    /**
     * 逐步构建复杂产品对象
     */
    public Character construct(AbstractCharacterBuilder characterBuilder) {
        Character character;
        characterBuilder.buildClazz();
        characterBuilder.buildSex();
        characterBuilder.buildFace();
        characterBuilder.buildSkinColor();
        characterBuilder.buildRace();
        characterBuilder.buildSkills();
        characterBuilder.enhanceByRace();
        character = characterBuilder.createCharacter();
        return character;
    }
}
