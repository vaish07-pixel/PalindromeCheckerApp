import java.util.LinkedList;

/**
 * =========================================================
 * MAIN CLASS – UseCase8PalindromeCheckerApp
 * =========================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * using a LinkedList.
 *
 * Characters are added to the list and then compared
 * by removing elements from both ends:
 *
 * - removeFirst()
 * - removeLast()
 *
 * This demonstrates how LinkedList supports
 * double-ended operations for symmetric validation.
 *
 * @author Developer
 * @version 8.0
 */

public class UseCase8PalindromeCheckerApp {

    /**
     * Application entry point for UC8.
     *
     * @param args Command-line arguments
     */

    public static void main(String[] args) {

        String word = "level";

        LinkedList<Character> list = new LinkedList<>();

        // Add characters to LinkedList
        for (int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare first and last elements
        while (list.size() > 1) {

            char first = list.removeFirst();
            char last = list.removeLast();

            if (first != last) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }
    }
}