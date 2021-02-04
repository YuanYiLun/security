package cn.hyperchain.demo.test;

/**
 * File: Father.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-02-03
 */
public class Father {
    String name;

    Father() {
        System.out.println("father");
    }

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        String str4 = str3.intern();

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);

    }
}
