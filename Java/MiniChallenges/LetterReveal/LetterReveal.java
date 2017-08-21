package Java.MiniChallenges.LetterReveal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LetterReveal
{
    public static final String DICT_LONG = "google-10000-english-master/google-10000-english-usa-no-swears-long.txt";
    public static final String DICT_MEDIUM = "google-10000-english-master/google-10000-english-usa-no-swears-medium.txt";
    
    public static ArrayList<String> getDictionary()
    {
        String word;
        String[] titles = {DICT_LONG, DICT_MEDIUM};
        int num_of_titles = titles.length;
        ArrayList<String> dictionary = new ArrayList<>();
        
        for (int i = 0; i<num_of_titles; i++)
        {
            try (BufferedReader br = new BufferedReader(new FileReader(titles[i])))
            {
                while ((word = br.readLine()) != null)
                {
                    dictionary.add(word);
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return dictionary;
    }
    
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
        ArrayList<String> dictionary= getDictionary();
        int dict_index = (new Random().nextInt(dictionary.size()));
        
        String answer = dictionary.get(dict_index);
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
            System.out.println();
        }

        if(lives==0)
        {
            System.out.println("Sorry, the correct answer is '" + answer + "'");
        }
        
        else
        {
            System.out.println("Correct! The answer is '" + answer + "'");
        }
    }
}
