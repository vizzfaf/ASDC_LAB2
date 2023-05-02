package org.example;

import java.util.ArrayList;

public class SortingAlgorithms {

    public static void bubble(ArrayList<Competitor> array) {
        int counterOfSwaps = 0;
        int counterOfCompares = 0;
        long before = System.nanoTime();
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                counterOfCompares++;
                if (array.get(j + 1).getNumberInTable() < array.get(j).getNumberInTable()) {
                    counterOfSwaps++;
                    Competitor swap = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, swap);

                }
            }
        }
        System.out.println("Кол - во сравнений - " + counterOfCompares);
        System.out.println("Кол-во перемещений - " + counterOfSwaps);
        long after = System.nanoTime();
        System.out.println("Время выполнения - " + (after - before));
    }

    public static void insertion(ArrayList<Competitor> array) {
        long before = System.nanoTime();
        int counterOfSwaps = 0;
        int counterOfCompares = 0;
        int j;
        for (int i = 1; i < array.size(); i++) {

            Competitor swap = array.get(i);
            counterOfCompares++;
            for (j = i; j > 0 && swap.getNumberInTable() < array.get(j-1).getNumberInTable(); j--) {
                //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                counterOfSwaps++;
                array.set(j,array.get(j-1));
            }
            counterOfSwaps++;
            array.set(j,swap);
        }
        System.out.println("Кол - во сравнений - " + counterOfCompares);
        System.out.println("Кол-во перемещений - " + counterOfSwaps);
        long after = System.nanoTime();
        System.out.println("Время выполнения - " + (after - before));
    }


    public static int[] quick(ArrayList<Competitor> array, int low, int high, int counterOfCompares, int counterOfSwaps) {
        counterOfCompares++;
        int[] result = new int[2];
        result[0] = counterOfCompares;
        result[1] = counterOfSwaps;
        //завершить,если массив пуст или уже нечего делить
        if (array.size() == 0 || low >= high) return result;
        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = array.get(middle).getNumberInTable();
        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            counterOfCompares++;
            while (array.get(i).getNumberInTable() < border) i++;
            while (array.get(j).getNumberInTable() > border) j--;
            counterOfCompares++;
            if (i <= j) {
                counterOfSwaps++;
                Competitor swap = array.get(i);
                array.set(i, array.get(j));
                array.set(j, swap);
                i++;
                j--;
            }
        }
        //рекурсия для сортировки левой и правой части
        counterOfCompares++;
        if (low < j) quick(array, low, j, counterOfCompares,counterOfSwaps);
        counterOfCompares++;
        if (high > i) quick(array, i, high, counterOfCompares,counterOfSwaps);
        result[0] = counterOfCompares;
        result[1] = counterOfSwaps;
        return result;
    }
}
