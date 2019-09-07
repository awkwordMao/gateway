package shiyue.jery.gateway.reflect;

/**
 * @author Jery
 * @date 2019/9/3
 */
public class Person {
    private String name;
    private String sex;

    public void say() {
        System.out.println("我是个人");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
