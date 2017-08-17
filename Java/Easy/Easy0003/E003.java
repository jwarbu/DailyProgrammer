import java.util.*;
public class E003
{
    /**
     * TODO: only works for shift values up to 26, adjust for all shift amounts (use remainder for roll-over?)
     */
    static int SHIFT = 0;
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        while(true)
        {
            System.out.println("\n--------------------------");
            System.out.println("Please select:");
            System.out.println("'1' Encrypt text");
            System.out.println("'2' Decrypt text");
            System.out.println("'0' to exit");
            System.out.print(">  ");
            int menu_op = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println();
            System.out.print("SPECIFY SHIFT AMOUNT: ");
            SHIFT = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println("--------------------------\n");
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
                    System.out.println("\nEncrypted text:\n" + encrypted_text);
                    break;
                }

                case 2: //decrypt
                {
                    System.out.println("Enter text to decrypt: ");
                    String original_text = keyboard.nextLine();
                    String decrypted_text = Decrypt(original_text);
                    System.out.println("\nDecrypted text:\n" + decrypted_text);
                    break;
                }
            }
        }
    }

    public static String Encrypt(String s)
    {
        String encrypted = "";
        int length = s.length();

        for(int i = 0; i<length; i++)
        {
            Character c = s.charAt(i);
            //ignore non alpha char
            if(c.isLetter(c))
            {
                c = (char) (s.charAt(i) + SHIFT);
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
        int length = s.length();

        for(int i = 0; i < length; i++)
        {
            Character c = s.charAt(i);
            // ignore non alpha char
            if(c.isLetter(c))
            {
                c = (char) (s.charAt(i) - SHIFT);
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