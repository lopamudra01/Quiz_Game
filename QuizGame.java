import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizGame {

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();

        
        questions.add(new Question("What is the capital of France?",
                new String[]{"London", "Paris", "Berlin"}, 1, 10));
        questions.add(new Question("In which year was Java first released?",
                new String[]{"1991", "1995", "2000"}, 0, 15));
        questions.add(new Question("What is the capital of India?",
                new String[]{"London", "Delhi", "Berlin"}, 1, 10));
        questions.add(new Question("In which year was Java first released?",
                new String[]{"1991", "1995", "2000"}, 0, 15));
        questions.add(new Question("How many continents are there in the world?",
                new String[]{"7", "17", "5"}, 0, 10));
        questions.add(new Question("Who was the first football player that scored more than 1000 goals?",
                new String[]{"Zidane", "pele", "Cristiano Ronaldo0"}, 1, 15));
        questions.add(new Question("Name the house made of ice?",
                new String[]{"Boat house", "Building", "Igloo"}, 2, 10));
        questions.add(new Question("Name the largest mammal?",
                new String[]{"Blue Whale", "Giraffe", "Elephant"}, 0, 15));
        questions.add(new Question("What is the third planet from the sun?",
                new String[]{"Mars", "Earth", "Venus"}, 1, 10));
        questions.add(new Question("What country are the Pyramids in?",
                new String[]{"china", "South America5", "Egypt "}, 2, 15));
        questions.add(new Question("Which is the largest continent?",
                new String[]{"America", "Asia", "Africa"}, 1, 10));
        questions.add(new Question("In 2016, who announced his retirement days after becoming F1 world champion?",
                new String[]{"Lewis Hamilton", "Nico Rosberg", "Fernando Alonso"}, 1, 15));
        questions.add(new Question("What is full of holes but still holds water?",
                new String[]{"Jar", "Glass", "Sponge"}, 2, 10));
        questions.add(new Question("The more of this there is ,the less you see. What is it?",
                new String[]{"Darkness", "Light", "Sunshine"}, 0, 15));
        questions.add(new Question("What type of gas is absorbed by plants?",
                new String[]{"O3(ozone)", "O2(oxygen)", "CO2(carbon dioxide)"}, 2, 10));
        questions.add(new Question("How often do the Summer Olympic Games take place?",
                new String[]{"Every 2 years", "Every 4 years", "Every 5 years"}, 1, 15));
        questions.add(new Question("Name the largest 'Democracy' of the world?",
                new String[]{"China", "India", "America"}, 1, 10));
        questions.add(new Question("Name the hardest substance available on Earth?",
                new String[]{"Diamond", "Rock", "Glass"}, 0, 15));
        questions.add(new Question("Who is the most paid player in the world?",
                new String[]{"Neymar", "Cristiano Ronaldo", "Lionel Messi"}, 2, 10));
        questions.add(new Question("Java was developed by",
                new String[]{"James frank", "John gosling", "James gosling"}, 2, 15));
        questions.add(new Question("Int data types represents _______ bits.",
                new String[]{"8", "64", "32"}, 2, 10));
        questions.add(new Question("How many types of array?",
                new String[]{"2", "1", "4"}, 0, 15));
        Quiz quiz = new Quiz(questions);  
        quiz.startQuiz();
    }
}

class Question {

    private String question;
    private String[] options;
    private int correctAnswerIndex;
    private int timeLimit;

    public Question(String question, String[] options, int correctAnswerIndex, int timeLimit) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.timeLimit = timeLimit;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public int getTimeLimit() {
        return timeLimit;
    }
}

class Quiz {

    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in); 
        for (Question question : questions) {
            displayQuestion(question);
            int userAnswerIndex = getUserAnswer(question, scanner); 
            evaluateAnswer(question, userAnswerIndex);
        }
        showResult();
    }

    private void displayQuestion(Question question) {
        System.out.println(question.getQuestion());
        for (int i = 0; i < question.getOptions().length; i++) {
            System.out.println((i + 1) + ". " + question.getOptions()[i]);
        }
    }

    private int getUserAnswer(Question question, Scanner scanner) { 
        long startTime = System.currentTimeMillis();
        int answerIndex;
        do {
            System.out.print("Enter your answer (1-" + question.getOptions().length + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and " + question.getOptions().length + ".");
                scanner.next();
            }
            answerIndex = scanner.nextInt() - 1;

            long currentTime = System.currentTimeMillis();
            long remainingTime = question.getTimeLimit() * 1000 - (currentTime - startTime);
            if (remainingTime <= 0) {
                System.out.println("Time's up! No answer submitted.");
                break;
            }
        } while (answerIndex < 0 || answerIndex >= question.getOptions().length);
        return answerIndex;
    }

    private void evaluateAnswer(Question question, int userAnswerIndex) {
        if (userAnswerIndex == question.getCorrectAnswerIndex()) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is " + question.getOptions()[question.getCorrectAnswerIndex()]);
        }}
    

        private void showResult() {
            System.out.println("--------------------");
            System.out.println("Final Score: " + score + " out of " + questions.size());
            System.out.println("--------------------");
        }
    }