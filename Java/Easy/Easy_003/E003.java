import java.util.*;

/**
 * Created by jenniferwartick on 8/16/17.
 */
public class E003
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        while(true)
        {
            System.out.println("Please select '1' or '2'");
            System.out.println("1. Encrypt text");
            System.out.println("2. Decrypt text");
            System.out.println("['0' to exit]");
            System.out.print(">  ");
            int menu_op = keyboard.nextInt();
            keyboard.nextLine();
            switch(menu_op)
            {
                case 0: //exit
                {
                    System.out.println("Ending program... Goodbye!");
                    System.exit(0);
                }
                
                case 1: //encrypt
                {
                    System.out.println("Enter text to encrypt: ");
                    String original_text = keyboard.nextLine();
                    String encrypted_text = Encrypt(original_text);
                    System.out.println(encrypted_text);
                    break;
                }
                
                case 2: //decrypt
                {
                    System.out.println("Enter text to decrypt: ");
                    String original_text = keyboard.nextLine();
                    String decrypted_text = Decrypt(original_text);
                    System.out.println(decrypted_text);
                    break;
                }
            }
        }

    }
    
    public static String Encrypt(String s)
    {
        String encrypted = "";
        int shift = 3, length = s.length();
        
        for(int i = 0; i<length; i++)
        {
            Character c = s.charAt(i);
            //ignore non alpha char
            if(c.isLetter(c))
            {
                c = (char) (s.charAt(i) + shift);
                if (c <= 'z') // will NOT shift past z
                {
                    encrypted += c;
                }

                else // will shift past z
                {
                    encrypted += (char) (c - 26);
                }
            }
            
            else
            {
                encrypted += c;
            }
        }
        return encrypted;
    }

    public static String Decrypt(String s)
    {
        String decrypted = "";
        int shift = 3, length = s.length();
        
        for(int i = 0; i < length; i++)
        {
            Character c = s.charAt(i);
            // ignore non alpha char
            if(c.isLetter(c))
            {
                c = (char) (s.charAt(i) - shift);
                if (c >= 'a') //will not shift past a
                {
                    decrypted += c;
                }

                else //c shifts past a
                {
                    decrypted += (char) (c + 26);
                }
            }
            
            else
            {
                decrypted += c;
            }
        }
        
        return decrypted;
    }



}
