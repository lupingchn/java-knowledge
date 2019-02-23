package base.design.pattern.builder.director;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteBuilder -- 具体建造者 -- 亡灵角色建造器
 *
 * @author zhangluping on 2018/12/25.
 */
public class WarriorBuilder extends AbstractCharacterBuilder {

    private final static String SPECIAL_RACE = "兽人";

    @Override
    public void buildClazz() {
        character.setClazz("战士");
    }

    @Override
    public void buildRace() {
        character.setRace("兽人");
    }

    @Override
    public void buildSex() {
        character.setSex("男");
    }

    @Override
    public void buildFace() {
        character.setFace("野兽");
    }

    @Override
    public void buildSkinColor() {
        character.setSkinColor("黑灰");
    }

    @Override
    public void buildSkills() {
        List<String> skills = new ArrayList<>();
        skills.add("冲锋");
        if (SPECIAL_RACE.equals(character.getRace())) {
            skills.add("力量加成");
        }
        character.setSkills(skills);
    }
}
