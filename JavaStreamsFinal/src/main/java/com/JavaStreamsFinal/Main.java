package com.JavaStreamsFinal;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main
{

    static Random random = new Random();

    // Write a stream that generates 20 randomly generated integers in the range 1-100.
    // Implement a technique that uses a method reference for the println function to print the contents of the stream in (i) above.
    public static void streamRandomGeneration20IntegerInRange1to100() {

        // Write a stream that generates 20 randomly generated integers in the range 1-100.
        IntStream randStream = random.ints(20, 1, 100);

        // Implement a technique that uses a method reference for the println
        // function to print the contents of the stream in (i) above.
        randStream.forEach(System.out::println);
    }


    // Write a stream that generates streamSize random integers in the range 1 to 10;
    public static void streamRandomGenerationIntegerInRange1to10(int streamSize) {
        Random random = new Random();
        IntStream randStream = random.ints(streamSize, 1, 10);

        // use only functional interfaces, lambdas, mapping functions, collectors, and groupings to
        // implement a processing pipe that counts the frequency of occurrence of each number of that stream.

        System.out.printf("Number   count %n");

        randStream.
                mapToObj(Integer::toString).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                forEach( (key, value) -> System.out.printf("%s        %d %n", key, value));
    }


    public static void main(String[] args)
    {
        System.out.println("############################################################################");
        System.out.println("Question i and ii : Stream Random Generation 20 Integer In Range 1 to 100");
        System.out.println("############################################################################");

        streamRandomGeneration20IntegerInRange1to100();

        System.out.println("############################################################################");
        System.out.println("Question iii and iv and v : Stream Random Generation 100 Integer InRange 1 to 10");
        System.out.println("############################################################################");

        streamRandomGenerationIntegerInRange1to10(100);

        System.out.println("############################################################################");
        System.out.println("Question vi : Stream Random Generation 100,000 Integer InRange 1 to 10");
        System.out.println("############################################################################");

        streamRandomGenerationIntegerInRange1to10(100000);

        System.out.println("############################################################################");
        System.out.println("Question vi : Stream Random Generation 1,000,000 Integer InRange 1 to 10");
        System.out.println("############################################################################");

        streamRandomGenerationIntegerInRange1to10(1000000);

    }
}