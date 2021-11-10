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
        if (numbers.isBlank())
            return 0; // Input Blank
        if (numbers.contains(",")) {
            String nums[] = numbers.split(",");
            int sum = 0;
            for (String n : nums) {
                sum += Integer.parseInt(n);
            }
            return sum;
        }
        return Integer.parseInt(numbers);// Input only one Number
    }
}
