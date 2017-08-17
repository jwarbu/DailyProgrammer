import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * TODO: RENAME FILE
 * TODO: add load option for previous users
 * TODO: check if previous username exists
 */
public class Easy_0001_Solution implements Serializable
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String savepath = "Easy Challenges/Challenge 0001 Easy/TestDirectory/SavedUserData/";
        File dir = new File(savepath);
        try
        {
            boolean dir_flag = dir.mkdir();
            System.out.print("(Attempting to create SavedUserData... ");
            if (dir_flag)
            {
                System.out.println("directory created!");
            }
            else
            {
                System.out.println("attempt failed...");
            }

            String[] userdata = {"n/a", "n/a", "n/a"};
            System.out.println("What's your name?");
            System.out.print("> ");
            userdata[0] = keyboard.nextLine();
            System.out.println("\nHow old are you?");
            System.out.print("> ");
            userdata[1] = keyboard.nextLine();
            System.out.println("\nWhat's your username?");
            System.out.print("> ");
            userdata[2] = keyboard.nextLine();

            System.out.println("\nYour name is " + userdata[0] + ", you are " + userdata[1] + " years old, and your username is " + userdata[2]);

            System.out.print("(saving userdata...)");
            String savename = savepath + userdata[2];

            FileOutputStream savefile = new FileOutputStream(savename);
            ObjectOutput savedata = new ObjectOutputStream(savefile);
            savedata.writeObject(userdata);

        }

        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
