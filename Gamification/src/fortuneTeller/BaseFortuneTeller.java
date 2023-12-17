package fortuneTeller;

import java.util.Random;

public abstract class BaseFortuneTeller implements FortuneService {
	protected String[] fortunes;

    public BaseFortuneTeller() {
        this.fortunes = new String[]{
            "You will become a Java wizard, but only after you debug a million lines of code.",
            "Beware of bugs in the upcoming code. They are not as friendly as they seem.",
            "You will soon inherit a large sum... of Java exceptions!",
            "Your future is full of semicolons and curly braces.",
            "You will discover that the answer to all your problems is... more coffee.",
            "A mysterious duck will bring you coding wisdom at midnight.",
            "You will accidentally wear your shirt inside out, but it will bring you good luck."
        };
    }

    protected String randomFortune() {
        Random random = new Random();
        return fortunes[random.nextInt(fortunes.length)];
    }
}
