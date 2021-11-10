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
            return 0; // Input Blank
        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(0, numbers.indexOf("\n"));
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
            delimiter = "" + delimiter.charAt(delimiter.length() - 1);
        }
        if (numbers.contains(",") || numbers.contains("\n") || ((delimiter != null) && numbers.contains(delimiter))) {
            String regex = "[,\n" + delimiter + "]";
            String nums[] = numbers.split(regex);
            int sum = 0;
            for (String n : nums) {
                sum += Integer.parseInt(n);
            }
            return sum;
        }
        return Integer.parseInt(numbers);// Input only one Number
    }
}
