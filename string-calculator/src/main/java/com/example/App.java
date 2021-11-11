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
        String delimiter2 = null;
        if (numbers.isBlank()) {
            return 0;
        }
        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(0, numbers.indexOf("\n"));
            numbers = numbers.substring(numbers.indexOf("\n") + 1);

            if (delimiter.startsWith("//[")) {
                if (delimiter.contains("][")) {
                    delimiter2 = delimiter.substring(delimiter.indexOf("][") + 2, delimiter.length() - 1);
                    delimiter = delimiter.substring(3, delimiter.indexOf("]["));
                } else {
                    delimiter = delimiter.substring(3, delimiter.length() - 1);
                }
            } else {
                delimiter = "" + delimiter.charAt(delimiter.length() - 1);
            }
        }
        if (numbers.contains(",") || numbers.contains("\n") || ((delimiter != null) && numbers.contains(delimiter))) {
            String regex;
            if (delimiter == null) {
                regex = "[,\n]";
            } else if (delimiter2 == null) {
                regex = "[,\n]|";
                for (char c : delimiter.toCharArray()) {
                    regex = regex + "[" + c + "]";
                }
            } else {
                regex = "[,\n]|";
                for (char c : delimiter.toCharArray()) {
                    regex = regex + "[" + c + "]";
                }
                regex = regex + "|";
                for (char c : delimiter2.toCharArray()) {
                    regex = regex + "[" + c + "]";
                }
            }
            String nums[] = numbers.split(regex);
            int sum = 0;
            String negatives = "";
            for (String n : nums) {
                int x = Integer.parseInt(n);
                if (x < 0) {
                    negatives = negatives + " " + x;
                }
                if (x <= 1000) {
                    sum += x;
                }
            }
            if (!negatives.isBlank()) {
                throw new RuntimeException("negatives not allowed" + negatives);
            }
            return sum;
        }
        int result = Integer.parseInt(numbers);
        if (result < 0) {
            throw new RuntimeException("negatives not allowed " + result);
        }
        if (result > 1000) {
            result = 0;
        }
        return result;
    }
}
