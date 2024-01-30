package string.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String numbers) throws IllegalArgumentException{
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = "[,\n]";
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf('\n');
            String delimiterPart = numbers.substring(2, delimiterEnd);
            delimiter = buildDelimiterPattern(delimiterPart);
            numbers = numbers.substring(delimiterEnd + 1);
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                int number = Integer.parseInt(part.trim());
                if (number < 0) {
                    negatives.add(number);
                } else if (number < 1000)
                sum += number;
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives are not allowed: " +negatives);
        }
        return sum;
    }

    private static String buildDelimiterPattern(String delimiterPart) {
        Matcher match = Pattern.compile("\\[(.*?)\\]").matcher(delimiterPart);
        List<String> delimiters = new ArrayList<>();
        while (match.find()) {
            delimiters.add(Pattern.quote(match.group(1)));
        }
        return String.join("|", delimiters);
    }
}
