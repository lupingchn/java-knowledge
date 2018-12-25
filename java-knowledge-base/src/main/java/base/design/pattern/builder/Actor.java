package base.design.pattern.builder;

import java.io.*;

/**
 * Product -- 复杂产品  -- 角色实体类
 * 以下代码为简化，考虑到代码的可读性，只列出部分成员属性，且成员属性的类型均为String
 * 真实情况下，有些成员属性的类型需自定义
 *
 * @author zhangluping on 2018/12/25.
 */
public class Actor implements Cloneable , Serializable {

    /**
     * 角色类型
     */
    private String type;
    /**
     * 性别
     */
    private String sex;
    /**
     * 脸型
     */
    private String face;
    /**
     * 服装
     */
    private String costume;
    /**
     * 发型
     */
    private String hairstyle;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getCostume() {
        return costume;
    }

    public void setCostume(String costume) {
        this.costume = costume;
    }

    public String getHairstyle() {
        return hairstyle;
    }

    public void setHairstyle(String hairstyle) {
        this.hairstyle = hairstyle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{").append('\n');
        sb.append(type).append("的外观：").append('\n');
        sb.append("性别：").append(sex).append('\n');
        sb.append("面容：").append(face).append('\n');
        sb.append("服装：").append(costume).append('\n');
        sb.append("发型：").append(hairstyle).append('\n');
        sb.append('}');
        return sb.toString();
    }

    Actor() {
    }

    Actor(String type, String sex, String face, String costume, String hairstyle) {
        this.type = type;
        this.sex = sex;
        this.face = face;
        this.costume = costume;
        this.hairstyle = hairstyle;
    }

    /**
     * 建造者模式-建造者
     * @return
     */
    public static Actor.ActorBuilder builder() {
        return new Actor.ActorBuilder();
    }

    public static class ActorBuilder {
        private String type;
        private String sex;
        private String face;
        private String costume;
        private String hairstyle;

        ActorBuilder() {
        }

        public Actor.ActorBuilder type(String type) {
            this.type = type;
            return this;
        }

        public Actor.ActorBuilder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Actor.ActorBuilder face(String face) {
            this.face = face;
            return this;
        }

        public Actor.ActorBuilder costume(String costume) {
            this.costume = costume;
            return this;
        }

        public Actor.ActorBuilder hairstyle(String hairstyle) {
            this.hairstyle = hairstyle;
            return this;
        }

        public Actor build() {
            return new Actor(this.type, this.sex, this.face, this.costume, this.hairstyle);
        }

        @Override
        public String toString() {
            return "Actor.ActorBuilder(type=" + this.type + ", sex=" + this.sex + ", face=" + this.face + ", costume=" + this.costume + ", hairstyle=" + this.hairstyle + ")";
        }
    }


    /**
     * 原型模型使用的克隆方法clone
     */
    @Override
    public Actor clone() {
        Object obj = null;
        try {
            obj = super.clone();
            return (Actor) obj;
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
    public Actor deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Actor) ois.readObject();
    }
}
