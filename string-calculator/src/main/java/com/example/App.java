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
            int sum = Integer.parseInt(numbers.substring(0, numbers.indexOf(',')));
            sum += Integer.parseInt(numbers.substring(numbers.indexOf(',') + 1));
            return sum;
        }
        return Integer.parseInt(numbers);// Input only one Number
    }
}
