package by.matrosov.lesson03;

import java.io.*;
import java.util.*;

public class BullsAndCows {

    private static final int maxAttemptNumber = 10;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        startToPlay(reader);
    }

    private static boolean checkForUnsupportedCharacters(String s) {
        return s.matches("[a-z]+");
        //return s.chars().allMatch(Character::isLetter);
    }

    private static void startToPlay(BufferedReader reader){
        while (true){
            System.out.println("Welcome to Bulls and Cows game!");
            List<String> words = new ArrayList<>();
            getAllWordsFromFile(words);
            guess(words, reader);
            playAgain(reader);
        }
    }

    private static void playAgain(BufferedReader reader){
        System.out.println("Wanna play again? Y/N");
        while (true) {
            String answer;
            try {
                answer = reader.readLine();
                if (answer.equals("Y")) {
                    break;
                } else if (answer.equals("N")) {
                    System.exit(1);
                } else {
                    System.out.println("incorrect symbol");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void guess(List<String> words, BufferedReader reader){
        String randomWord = getRandomWord(words);
        try {
            int count = 0;
            while (true){
                String possibleWord = reader.readLine();
                if (possibleWord.length() != randomWord.length() || !checkForUnsupportedCharacters(possibleWord)){
                    System.out.println("incorrect length or unsupported chars");
                }else {
                    if (possibleWord.equals(randomWord)){
                        System.out.println("You Won!");
                        break;
                    }
                    count++;
                    if (count == maxAttemptNumber){
                        System.out.println("You Loose!");
                        break;
                    }
                    //here bulls and cows count
                    bullsAndCowsCount(randomWord, possibleWord);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bullsAndCowsCount(String randomWord, String possibleWord){
        int bulls = 0;
        int cows = 0;
        Set<Character> bullsNotCows = new HashSet<>();
        for (int i = 0; i < possibleWord.length(); i++) {
            if (randomWord.contains(String.valueOf(possibleWord.charAt(i))) && !bullsNotCows.contains(possibleWord.charAt(i))){
                if (randomWord.charAt(i) == possibleWord.charAt(i)){
                    bullsNotCows.add(randomWord.charAt(i));
                    bulls++;
                }else {
                    cows++;
                }
            }
        }
        System.out.println("Bulls: " + bulls);
        System.out.println("Cows: " + cows);
    }

    private static String getRandomWord(List<String> words){
        String randomWord = words.get(new Random().nextInt(words.size()));
        System.out.println(randomWord); //remove
        System.out.println("I offered a " + randomWord.length() + "-letter word, your guess?");
        return randomWord;
    }

    private static List<String> getAllWordsFromFile(List<String> words){
        String fileName = BullsAndCows.class.getResource("/dictionary.txt").getPath();
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line=reader.readLine())!=null){
                words.add(line);
            }
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }

        return words;
    }
}
