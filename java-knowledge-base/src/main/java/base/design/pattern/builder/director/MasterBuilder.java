package base.design.pattern.builder.director;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteBuilder -- 具体建造者 -- 兽人角色建造器
 *
 * @author zhangluping on 2018/12/25.
 */
public class MasterBuilder extends AbstractCharacterBuilder {

    private final static String SPECIAL_RACE = "亡灵";

    @Override
    public void buildClazz() {
        character.setClazz("法师");
    }

    @Override
    public void buildRace() {
        character.setRace("亡灵");
    }

    @Override
    public void buildSex() {
        character.setSex("男");
    }

    @Override
    public void buildFace() {
        character.setFace("丑陋");
    }

    @Override
    public void buildSkinColor() {
        character.setSkinColor("灰白");
    }

    @Override
    public void buildSkills() {
        List<String> skills = new ArrayList<>();
        skills.add("火球术");
        character.setSkills(skills);
    }

    @Override
    public void enhanceByRace() {
        List<String> skills = new ArrayList<>();
        if (SPECIAL_RACE.equals(character.getRace())) {
            skills.add("免疫");
        }
        character.getSkills().addAll(skills);
    }

}
