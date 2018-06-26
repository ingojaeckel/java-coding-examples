package algorithms.misc;

public class Reverser {
    /**
     * @return Reversed representation of x as described on https://leetcode.com/problems/reverse-integer/description/. Or 0 if the reversed integer would result in an overflow.
     */
    public static int reverseInteger(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        if (Math.abs(x) < 10) {
            return x;
        }
        try {
            int reversedIntegerWithoutSign = Integer.valueOf(reverseString(String.valueOf(Math.abs(x))));
            if (x < 0) {
                // x was negative, return negative result.
                return -1 * reversedIntegerWithoutSign;
            }
            // x was positive, return positive result.
            return reversedIntegerWithoutSign;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String reverseString(String x) {
        if (x == null) {
            return null;
        }
        StringBuffer buf = new StringBuffer(x.length());
        for (int i=0; i<x.length(); i++) {
            buf.append(x.charAt(x.length() - i - 1));
        }
        return buf.toString();
    }
}
