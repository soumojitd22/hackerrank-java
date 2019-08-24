package com.hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Grading {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int gradesCount = sc.nextInt();
            sc.nextLine();
            List<Integer> grades = IntStream.range(0, gradesCount)
                    .mapToObj(i -> sc.nextLine())
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = gradingStudents(grades);
            System.out.println(result.stream()
                    .map(Object::toString)
                    .collect(joining("\n")));

        }
    }

    private static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> rounded_grades = new ArrayList<>();
        for (Integer grade : grades) {
            if (grade > 37) {
                int r = grade % 5;
                if (r > 2)
                    grade += (5 - r);

            }
            rounded_grades.add(grade);
        }
        return rounded_grades;
    }
}

