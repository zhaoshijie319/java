package io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ObjectIO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person1 = new Person("赵士杰", "男", 23);
        Path path = Paths.get("D:", "test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()));
        objectOutputStream.writeObject(person1);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()));
        System.out.println(objectInputStream.readObject());
        objectOutputStream.close();
        objectInputStream.close();
    }

    private static class Person implements Serializable {
        private String name;
        private String gender;
        private transient Integer age;

        Person(String name, String gender, Integer age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        @Override
        public String toString() {
            return "name = " + name + " gender = " + gender + " age = " + age;
        }
    }
}
