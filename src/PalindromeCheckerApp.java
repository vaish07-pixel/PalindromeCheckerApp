/**
 * ============================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 *
 * Demonstrates benchmarking concepts using System.nanoTime().
 *
 * @author Developer
 * @version 13.0
 */
public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {
        String testInput = "racecar"; // can be scaled up for stress tests

        PalindromeStrategy[] strategies = {
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        };

        for (PalindromeStrategy strategy : strategies) {
            long start = System.nanoTime();
            boolean result = strategy.checkPalindrome(testInput);
            long end = System.nanoTime();

            long duration = end - start;

            System.out.println(strategy.getClass().getSimpleName() +
                    " → Result: " + result +
                    " | Time: " + duration + " ns");
        }
    }
}

/**
 * Simple two-pointer strategy for comparison.
 */
class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;

        int left = 0, right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
