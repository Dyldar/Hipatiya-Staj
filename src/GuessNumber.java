import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;

public class GuessNumber {
    public static void main(String args[]){
        byte moves = 8;
        AtomicBoolean isCorrectGuess = new AtomicBoolean(false);
        int randomNumber = (int)(Math.random() * 101); // between 0 and 100
        System.out.println("Computer picked a number between 0 and 100 :) ");
        Scanner scanner = new Scanner(System.in);

        //Lambda comparison function defined
        BiFunction<Integer, Integer, String> comparison = (userGuess, target) -> { // will call randomNumber as target
            if (userGuess < target) {
                return "Guess higher";
            } else if (userGuess > target) {
                return "Guess lower";
            } else {
                isCorrectGuess.set(true);
                return "Correct!";
            }
        };

        //Loops the game until u run out of moves or guess right
        while (moves > 0 && !isCorrectGuess.get()) {
            System.out.println("Can yıu guess the number?");
            Optional<Integer> userGuess = Optional.empty();
            try{
                userGuess = Optional.of(scanner.nextInt());
                scanner.nextLine(); //clean up buffer
            }catch (InputMismatchException e){
                System.out.println("Invalid input.");
                scanner.nextLine(); // discard invalid input
            }

            if(userGuess.isPresent()){
                String result = comparison.apply(userGuess.get(), randomNumber);
                System.out.println(result);

                if (!isCorrectGuess.get()){
                    moves--;
                    System.out.println("You have "+ moves + " moves left.");
                }
            }
        }

        if (!isCorrectGuess.get()){
            System.out.println("Game over! The number was: " + randomNumber);
        }else{
            System.out.println("You guessed correctly, hurrayyy!!");
        }
        scanner.close();
    }
}
