import java.util.Scanner;
import java.util.Random;

public class GUESSINGNUMBERGAME
 {
    public static void main(String[] args)
    {
        System.out.println("WELCOME TO NUMBER GUESSING GAME");
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String play = "yes";
        while ("yes".equals(play))
        {
            int computerchoice = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxattemps = 10;
            System.out.println("\nGUESS A NUMBER BETWEEN 1 TO 100 :");
            while (attempts < maxattemps) 
            {
                System.out.println("\nTOTAL ATTEMPTS MADE IS " + attempts + " out of " + maxattemps + " ATTEMPTS");
                System.out.println("\nENTER YOUR GUESS :");
                int userGuess = sc.nextInt();
                attempts++;
                if (userGuess < 1 || userGuess > 100) 
                {
                    System.out.println("\nYOU CAN GUESS A NUMBER ONLY BETWEEN 1 TO 100");
                }
                else if (userGuess < computerchoice)
                {
                    System.out.println("\nYOUR GUESS IS LOW");
                } 
                else if (userGuess > computerchoice) 
                {
                    System.out.println("\nYOUR GUESS IS HIGH");
                } 
                else 
                {
                    System.out.println("\nYOU GUESSED CORRECTLY! THE NUMBER WAS " + computerchoice);
                    System.out.println("\nYOU TOOK " + attempts + " ATTEMPTS");
                    break;
                }
            }
            if (attempts >= maxattemps) 
            {
                System.out.println("\nYOU HAVE REACHED MAXIMUM ATTEMPTS");
            }
            System.out.println("\nDO YOU WANT TO PLAY AGAIN? (yes/no):");
            sc.nextLine(); 
            play = sc.nextLine().toLowerCase();
            if (!"yes".equals(play))
            {
                System.out.println("THANK YOU FOR PLAYING!");
            }
        }
        sc.close();
    }
}