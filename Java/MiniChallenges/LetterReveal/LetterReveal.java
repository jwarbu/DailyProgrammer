import java.io.BufferedReader;
import java.util.Scanner;

public class LetterReveal
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String answer = "Hello";
        String[] answer_bank = answer.split("");

        System.out.println("Guess the word!");
        int lives = 10;
        boolean flag = true;

        System.out.println(">_ _ _ _ _");

        while(lives!=0||flag)
        {
            String guess = keyboard.nextLine();
            System.out.println("> ");
            boolean inAnswer= false;
            int[] answerIndex = new int[answer_bank.length];
            for(int i = 0; i<answer_bank.length; i++)
            {
                answerIndex[i]= -1;
            }

            for(int i = 0; i<answer_bank.length;i++)
            {
                if (guess.equals(answer_bank[i]))
                {
                    inAnswer = true;
                    answerIndex[i]=i;
                }
            }

            if(inAnswer)
            {
                for(int i = 0; i<answerIndex.length; i++)
                {
                    if(answerIndex[i]!=-1)
                    {
                        System.out.print(" " + answer_bank[answerIndex[i]]);
                    }
                    else
                    {
                        System.out.print(" _");
                    }
                }
            }
            else
            {
                lives--;
                System.out.println("\"" + guess + "\" is not in the word! " + lives + "lives left!");
                System.out.println(">_ _ _ _ _");

            }
        }

        if(lives==0)
        {
            System.out.println("Sorry, you didn't guess the word...");
        }
    }
}
