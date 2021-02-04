package cn.hyperchain.demo.test;

/**
 * File: Child.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-02-03
 */
public class Child extends Father {
    int age;

    Child() {
        System.out.println("child");
    }

    public static void main(String[] args) {
        new Child();
    }
}
