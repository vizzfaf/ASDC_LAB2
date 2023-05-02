package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {


        File fileInput = new File("src/main/java/org/example/MOCK_DATA.csv");
        String stringInput = "Chickie;Hoggan;Madagascar;1989;47;IM/nChickie;Hoggan;Madagascar;1989;47;IM";
        ArrayList<Competitor> list = Competitor.inputFromFile(fileInput);

        Collections.shuffle(list);
        System.out.println("\nbubble sort");
        SortingAlgorithms.bubble(list);


        Collections.shuffle(list);
        System.out.println("\nInsertion sort");
        SortingAlgorithms.insertion(list);

        Collections.shuffle(list);
        long before = System.nanoTime();
        int[] info = SortingAlgorithms.quick(list, 0, list.size() - 1, 0,0);
        long after = System.nanoTime();
        System.out.println("\nQuick sort");
        System.out.println("Number of compares - " + info[0]);
        System.out.println("Number of swaps - " + info[1]);
        System.out.println("Time for sorting in nanos - " + (after - before));
    }
}