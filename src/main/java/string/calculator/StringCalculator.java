package string.calculator;

public class StringCalculator {
    public static int add(String numbers){
        if (numbers.isEmpty()){
            return 0;
        }
        String[] parts = numbers.split(",");
        int sum = 0;
            for (String part : parts) {
                sum += Integer.parseInt(part.trim());
        }
        return sum;
    }
}
