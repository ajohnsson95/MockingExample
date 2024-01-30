package string.calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = "[,\n]";
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf('\n');
            delimiter = Pattern.quote(numbers.substring(2, delimiterEnd));
            numbers = numbers.substring(delimiterEnd + 1);
        }
        String[] parts = numbers.split(delimiter);
        int sum = 0;
        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                sum += Integer.parseInt(part.trim());
            }
        }
        return sum;
    }
}
