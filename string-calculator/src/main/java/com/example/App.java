package com.example;

/**
 * Hello world!
 */
public final class App {

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int Add(String numbers) {
        String delimiter = null;
        if (numbers.isBlank())
            return 0;
        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(0, numbers.indexOf("\n"));
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
            delimiter = "" + delimiter.charAt(delimiter.length() - 1);
        }
        if (numbers.contains(",") || numbers.contains("\n") || ((delimiter != null) && numbers.contains(delimiter))) {
            String regex = "[,\n" + delimiter + "]";
            String nums[] = numbers.split(regex);
            int sum = 0;
            String negatives = "";
            for (String n : nums) {
                int x = Integer.parseInt(n);
                if (x < 0)
                    negatives = negatives + " " + x;
                if (x <= 1000)
                    sum += x;
            }
            if (!negatives.isBlank())
                throw new RuntimeException("negatives not allowed" + negatives);
            return sum;
        }
        int result = Integer.parseInt(numbers);
        if (result < 0)
            throw new RuntimeException("negatives not allowed " + result);
        if (result > 1000) result = 0;
        return result;
    }
}
