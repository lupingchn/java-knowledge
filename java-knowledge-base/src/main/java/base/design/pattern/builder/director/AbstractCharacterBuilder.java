package base.design.pattern.builder.director;

/**
 * Builder -- 抽象建造者 -- 角色建造器
 *
 * @author zhangluping on 2018/12/25.
 */
public abstract class AbstractCharacterBuilder {
    Character character = new Character();

    public abstract void buildClazz();

    public abstract void buildRace();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildSkinColor();

    public abstract void buildSkills();

    /**
     * 返回一个完整的游戏角色对象
     */
    public Character createCharacter() {
        return character;
    }
}
