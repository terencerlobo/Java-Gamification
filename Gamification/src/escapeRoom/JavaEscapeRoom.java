package escapeRoom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class JavaEscapeRoom {
	
	static class Question {
        private String questionText;
        private String correctAnswer;

        public Question(String questionText, String correctAnswer) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestionText() {
            return questionText;
        }

        public boolean checkAnswer(String answer) {
            return answer.equalsIgnoreCase(correctAnswer);
        }
    }
	
	private static boolean playLevel(int level) {
        List<Question> questions = questionsByLevel.get(level);
        Question question = questions.get(random.nextInt(questions.size()));
        System.out.println(question.getQuestionText());
        String answer = scanner.nextLine();
        return question.checkAnswer(answer);
    }
	
	private static void initializeQuestions() {
        
        questionsByLevel.put(1, Arrays.asList(
            new Question("What is the size of an int in Java?", "4"),
            new Question("What is the default value of a boolean variable in Java?", "false"),
            new Question("In Java, which keyword is used to inherit a class?", "extends"),
            new Question("What do we call the process of defining two or more methods "
            		+ "within the same class that have the same name but different parameters?", "Overloading"),
            new Question("What is the term for a variable defined within a method in Java?", "Local")
        ));
        questionsByLevel.put(2, Arrays.asList(
                new Question("Which interface forms the root of the Java Collections Framework?", "Collection"),
                new Question("What implementation of List should be used when frequent"
                		+ " additions and removals occur at both ends?", "LinkedList"),
                new Question("Which Map implementation maintains the insertion order?", "LinkedHashMap"),
                new Question("What interface represents a collection that does "
                		+ "not allow duplicate elements?", "Set"),
                new Question("In a HashMap, what happens when two different keys have the same hashcode?", "Collision")
        ));
        questionsByLevel.put(3, Arrays.asList(
                new Question("Which interface forms the root of the Java Collections Framework?", "Collection"),
                new Question("What implementation of List should be used when frequent"
                		+ " additions and removals occur at both ends?", "LinkedList"),
                new Question("Which Map implementation maintains the insertion order?", "LinkedHashMap"),
                new Question("What interface represents a collection that does "
                		+ "not allow duplicate elements?", "Set"),
                new Question("In a HashMap, what happens when two different keys have the same hashcode?", "Collision")
        ));
        questionsByLevel.put(4, Arrays.asList(
                new Question("What is the area in Java Memory where local variables and method calls are stored?", "Stack"),
                new Question("Which process in Java is responsible for "
                		+ "automatically freeing memory occupied by objects that are no longer in use?", "GarbageCollection"),
                new Question("What term is used for the memory area that holds class level information, including static variables?", "MethodArea"),
                new Question("In Java, what is the name of the pointer inside the JVM that points to the last memory address where an object was stored?", "StackPointer"),
                new Question("What is the term for the memory space where all Java threads share class and static variables?", "Heap")
        ));
        questionsByLevel.put(5, Arrays.asList(
                new Question("Which class is used for file handling to read a file in Java?", "FileReader"),
                new Question("What class represents a buffer for characters for "
                		+ "efficient reading of characters, arrays, and lines?", "BufferedReader"),
                new Question("Which stream class is used for writing bytes to an output stream?", "OutputStream"),
                new Question("What class in Java is used to write character-based information to a file?", "FileWriter"),
                new Question("Which I/O stream class is used for reading byte-oriented data from a file?", "FileInputStream")
        ));
        
    }
	
	private static final int MAX_LEVEL = 5;
    private static int currentLevel = 1;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static Map<Integer, List<Question>> questionsByLevel = new HashMap<>();
    
    public static void main(String[] args) {
        initializeQuestions();
        while (currentLevel <= MAX_LEVEL) {
            System.out.println("Welcome to Level " + currentLevel);
            if (playLevel(currentLevel)) {
                System.out.println("Congratulations! Moving to the next level.");
                currentLevel++;
            } else {
                System.out.println("Incorrect answer. Moving down a level.");
                currentLevel = Math.max(1, currentLevel - 1);
            }
        }
        System.out.println("You have successfully completed all levels!");
    }

}
