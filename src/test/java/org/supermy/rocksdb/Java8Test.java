package org.supermy.rocksdb;

import com.google.common.collect.Lists;

import javax.swing.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by moyong on 17/6/2.
 */
public class Java8Test {
    public static void main(String[] args) {
        //使用() -> {} 替代匿名类：
        new Thread( () -> System.out.println("In Java8!") ).start();

        //更好的事件侦听器的代码
        JButton show =  new JButton("Show");
        show.addActionListener((e) -> {
            System.out.println("Action !! Lambda expressions Rocks");
        });

        //Lambda表达式遍历List集合
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API",
                "Date and Time API");
        features.forEach(n -> System.out.println(n));

        features.forEach(System.out::println);


        //使用Lambda表达式和函数接口
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("***Languages which starts with J :");
        filter(languages, (str)->str.startsWith("J"));

        System.out.println("***Languages which ends with a ");
        filter(languages, (str)->str.endsWith("a"));

        System.out.println("***Print all languages :");
        filter(languages, (str)->true);

        System.out.println("***Print no language : ");
        filter(languages, (str)->false);

        System.out.println("***Print language whose length greater than 4:");
        filter(languages, (str)->str.length() > 4);


        //    Predicate<String> startsWithJ = (n) -> n.startsWith("J");
//    Predicate<String> fourLetterLong = (n) -> n.length() == 4;
//
//    names.stream()
//            .filter(startsWithJ.and(fourLetterLong))
//            .forEach((n) -> System.out.print("\nName, which starts with
//            'J' and four letter long is : " + n));
//            其中startsWithJ.and(fourLetterLong)是使用了AND逻辑操作。



// With Lambda expression:
    List<Integer> costBeforeTax111 = Arrays.asList(100, 200, 300, 400, 500);
    costBeforeTax111.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);

//    // Create a List with String more than 2 characters
    List<String> filtered = languages.stream().filter(x -> x.length()> 2)
            .collect(Collectors.toList());
    System.out.printf("Original List : %s, filtered list : %s %n",languages, filtered);


        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost)  //foreach
                .reduce((sum, cost) -> sum + cost)  //foreach 结合汇总  reduce() 是将集合中所有值结合进一个，Reduce类似SQL语句中的sum(), avg() 或count(),
                .get();
        System.out.println("Total : " + bill);


        //通过filtering 创建一个字符串String的集合
        // Create a List with String more than 2 characters
        List<String> filtered111 = languages.stream().filter(x -> x.length()> 2)
                .collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n",
                languages, filtered111);


        //对集合中每个元素应用函数
        // Convert String to Uppercase and join them using coma
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",
                "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(G7Countries);




        //使用Stream的distinct()方法过滤集合中重复元素。

// Create List of square of all distinct numbers
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct()
                .collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates :%s %n", numbers, distinct);

       // 10.计算List中的元素的最大值，最小值，总和及平均值
//Get count, min, max, sum, and average for numbers
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());


    }

    //过滤方法
    public static void filter(List<String> names, Predicate<String> condition) {
        for(String name: names)  {
            if(condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }




}

