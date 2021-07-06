package algorithm;

import sun.reflect.generics.tree.Tree;

import java.util.TreeSet;

public class TreesetTest {
    public TreesetTest () {
        System.out.println(super.getClass());
    }
    public static void main(String[] args) {
//        TreeSet<User> objects = new TreeSet<User>();
//        User user = new User("1");
//        objects.add(user);
        new User();
    }
}


class User extends TreesetTest {
    public User() {
        Class<? extends TreesetTest> aClass = super.getClass();
        System.out.println(super.toString());
        System.out.println(this.getClass().getSuperclass());
    }
    private String id;

    public User(String id) {
        this.id = id;
    }
}
