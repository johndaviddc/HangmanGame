import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] words = {"hangman", "computer", "java", "programming", "openai"};
        String selectedWord = words[(int) (Math.random() * words.length)];
        
        int maxAttempts = 6;
        int remainingAttempts = maxAttempts;
        
        StringBuilder guessedWord = new StringBuilder();
        for (int i = 0; i < selectedWord.length(); i++) {
            guessedWord.append('_');
        }
        
        while (remainingAttempts > 0 && guessedWord.toString().contains("_")) {
            System.out.println("Current word: " + guessedWord);
            System.out.println("Attempts left: " + remainingAttempts);
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);
            
            boolean found = false;
            for (int i = 0; i < selectedWord.length(); i++) {
                if (selectedWord.charAt(i) == guess) {
                    guessedWord.setCharAt(i, guess);
                    found = true;
                }
            }
            
            if (!found) {
                remainingAttempts--;
                System.out.println("Incorrect guess!");
            } else {
                System.out.println("Correct guess!");
            }
            
            System.out.println();
        }
        
        if (guessedWord.toString().equals(selectedWord)) {
            System.out.println("Congratulations! You guessed the word: " + selectedWord);
        } else {
            System.out.println("Sorry, you're out of attempts. The word was: " + selectedWord);
        }
        
        scanner.close();
    }
}
