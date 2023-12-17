package fortuneTeller;

import java.util.Scanner;

public class FunnyFortuneTeller extends BaseFortuneTeller{
	
	public static void main(String[] args) {
		FunnyFortuneTeller fortuneTeller = new FunnyFortuneTeller();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Funny Fortune Teller!");
        System.out.print("Enter a number between 1 and 10: ");

        try {
            int input = scanner.nextInt();
            if (input < 1 || input > 10) {
            	scanner.close();
                throw new IllegalArgumentException("Number must be between 1 and 10.");
            }
            System.out.println("Your fortune: " + fortuneTeller.getFortune());
        } catch (Exception e) {
            System.out.println("Oops! There was an error: " + e.getMessage());
        }
        
        scanner.close();
    }

	@Override
	public String getFortune() {
		return randomFortune();
	}
}
