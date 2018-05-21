package com.spbstu.lombok;

import lombok.val;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by dmitry on 21.03.2018.
 */
public class LombokMain {
    public static void main(String[] args) {
        Student student = new Student(Arrays.asList("math", "oop"), "smyk", 12);
        System.out.println(student);

        ArrayList<Student> students = new ArrayList<Student>() {{
            add(new Student(Arrays.asList("math", "oop", "TG"), "smyk", 12));
            add(new Student(Arrays.asList("TA", "physics"), "myrtola", 13));
            add(new Student(Arrays.asList("TG"), "pavlov", 14));
        }};


        List<String> names = new ArrayList<>();
        for (Student s : students) {
            names.add(s.getName());
        }

        List<String> collect = students.stream().map(Student::getName).collect(Collectors.toList());

        HashSet<String> collect1 = students.stream()
                .map(Student::getTails)
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(HashSet::new));

        LinkedList<String> collect2 = students.stream()
                .map(Student::getTails)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toCollection(LinkedList::new));

        List<Student> collect3 = students.stream().filter(LombokMain::moreThanOneTail).collect(Collectors.toList());

        Integer reduce = students.stream().reduce(0, (acc, s) -> acc + s.getTails().size(), (a, b) -> a);
    }

    private static boolean moreThanOneTail(Student s) {
        return s.getTails().size() > 1;
    }
}