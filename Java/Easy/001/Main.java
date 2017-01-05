package challenge.one;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Name: ");
        String name = keyboard.next();

        System.out.print("Age: ");
        int age = keyboard.nextInt();

        System.out.print("Username: ");
        String username = keyboard.next();

        System.out.println();
        System.out.println("your name is " + name + ", you are " + age + " years old, and your username is " + username);

    }
}
