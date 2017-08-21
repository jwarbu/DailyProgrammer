import java.io.BufferedReader;
import java.util.Scanner;

public class LetterReveal
{
    public static void printArray(String[] s)
    {
        int loop = s.length;
        for(int i = 0; i<loop; i++)
        {
            System.out.print(s[i] + " ");
        }
    }
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String answer = "Hello";
        String[] answer_bank = answer.toLowerCase().split("");
        String[] guesses = new String[answer_bank.length];
        for(int i = 0; i<answer_bank.length; i++)
        {
            guesses[i] = "_";
        }

        System.out.println("Guess the word!");
        int lives = 10;
        boolean solved = false;
        boolean inAnswer;

        while(lives!=0 && !solved)
        {
            inAnswer = false;
            printArray(guesses);
            System.out.print("\n> ");
            String guess = keyboard.nextLine().toLowerCase();

            int loop = answer_bank.length;
            for(int i = 0; i<loop;i++)
            {
                if (guess.equals(answer_bank[i]))
                {
                    inAnswer = true;

                    guesses[i] = answer_bank[i];
                }
            }
            if(!inAnswer)
            {
                lives--;
                System.out.println("'" + guess + "' is not in the word! " + lives + " guesses left!");
            }
            
            //Check if solved
            boolean check = true;
            for(int i = 0; i<guesses.length; i++)
            {
                if(guesses[i].equals("_"))
                {
                    check = false;
                }
            }
            solved=check;
        }

        if(lives==0)
        {
            System.out.println("Sorry, you didn't guess the word...");
        }
        
        else
        {
            System.out.println("Correct! The answer is '" + answer + "'");
        }
    }
}
