/**
 * ================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * Demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * Focus: Algorithm interchangeability and extensibility.
 *
 * @author Developer
 * @version 12.0
 */
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {
        // Choose strategy dynamically
        PalindromeStrategy strategy = new StackStrategy();
        // You could swap this with new DequeStrategy() or others

        PalindromeContext context = new PalindromeContext(strategy);

        String[] testInputs = {"madam", "racecar", "hello", "level"};

        for (String input : testInputs) {
            boolean result = context.executeStrategy(input);
            System.out.println("Is \"" + input + "\" a palindrome? " + result);
        }
    }
}

/**
 * ================================================
 * INTERFACE - PalindromeStrategy
 * ================================================
 */
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

/**
 * ================================================
 * CONTEXT - PalindromeContext
 * ================================================
 *
 * Holds a reference to the chosen strategy
 * and delegates execution.
 */
class PalindromeContext {
    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.checkPalindrome(input);
    }
}

/**
 * ================================================
 * STRATEGY - StackStrategy
 * ================================================
 *
 * Uses a stack to validate palindrome.
 */
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;

        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return input.equals(reversed.toString());
    }
}

/**
 * ================================================
 * STRATEGY - DequeStrategy
 * ================================================
 *
 * Uses a deque for efficient front/back comparison.
 */
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;

        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }
}
