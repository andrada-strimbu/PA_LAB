package org.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var projects = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);
        var students=IntStream.rangeClosed(0,3).mapToObj(i->new Student("S"+i)).toArray(Student[]::new);

        var linckedList = Arrays.stream(students).collect(Collectors.toCollection(LinkedList :: new));
        var treeSet =Arrays.stream(projects).collect(Collectors.toCollection(TreeSet :: new)) ;
        Collections.sort(linckedList);
        System.out.println(linckedList);
        System.out.println(treeSet);


    }

}