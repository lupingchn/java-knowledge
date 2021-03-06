package base.design.pattern.builder.nodirector;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Product -- 复杂产品  -- 角色实体类
 * 以下代码为简化，考虑到代码的可读性，只列出部分成员属性，且成员属性的类型均为String
 * 真实情况下，有些成员属性的类型需自定义
 *
 * @author zhangluping on 2018/12/25.
 */
public class Character implements Cloneable , Serializable {

    /**
     * 职业
     */
    private String clazz;

    /**
     * 种族
     */
    private String race;
    /**
     * 性别
     */
    private String sex;
    /**
     * 脸型
     */
    private String face;
    /**
     * 肤色
     */
    private String skinColor;

    /**
     * 技能
     */
    private List<String> skills;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    Character() {
    }

    public Character(String clazz, String race, String sex, String face, String skinColor, List<String> skills) {
        this.clazz = clazz;
        this.race = race;
        this.sex = sex;
        this.face = face;
        this.skinColor = skinColor;
        this.skills = skills;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"角色\":\"").append(clazz).append('\"');
        sb.append(",\"种族\":\"").append(race).append('\"');
        sb.append(",\"性别\":\"").append(sex).append('\"');
        sb.append(",\"脸型\":\"").append(face).append('\"');
        sb.append(",\"肤色\":\"").append(skinColor).append('\"');
        sb.append(",\"技能\":").append(skills);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 建造者模式-建造者
     * @return
     */
    public static CharacterBuilder builder() {
        return new CharacterBuilder();
    }

    public static class CharacterBuilder {
        private String clazz;
        private String race;
        private String sex;
        private String face;
        private String skinColor;
        private List<String> skills;

        CharacterBuilder() {
        }

        public CharacterBuilder clazz(String clazz) {
            this.clazz = clazz;
            return this;
        }

        public CharacterBuilder race(String race) {
            this.race = race;
            return this;
        }

        public CharacterBuilder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public CharacterBuilder face(String face) {
            this.face = face;
            return this;
        }

        public CharacterBuilder skinColor(String skinColor) {
            this.skinColor = skinColor;
            return this;
        }

        public CharacterBuilder skill(String skill) {
            if(this.skills == null){
                this.skills = new ArrayList<>();
            }
            this.skills.add(skill);
            return this;
        }

        public Character build() {
            return new Character(clazz, race, sex, face, skinColor, skills);
        }
    }


    /**
     * 原型模型使用的克隆方法clone
     */
    @Override
    public Character clone() {
        Object obj = null;
        try {
            obj = super.clone();
            return (Character) obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制！");
            return null;
        }
    }

    /**
     * 通过序列化进行深克隆
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Character deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Character) ois.readObject();
    }

}
