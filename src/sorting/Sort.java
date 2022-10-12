package sorting;

import java.util.ArrayList;

public class Sort {

    public static <E> void swap(ArrayList<E> arrayList, int i, int j) {
        E temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }

    public static <E extends Comparable<E>> boolean isSorted(ArrayList<E> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i).compareTo(arrayList.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> arrayList) {

        for (int i = arrayList.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayList.get(j).compareTo(arrayList.get(j + 1)) > 0) {
                    swap(arrayList, j, j + 1);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void merge(ArrayList<E> arrayList, int start, int middle, int end) {
        int i = start, j = middle;
        ArrayList<E> tempArrayList = new ArrayList<>(end - start);
        while (i < middle && j < end) {
            if (arrayList.get(i).compareTo(arrayList.get(j)) <= 0) {
                tempArrayList.add(arrayList.get(i));
                i++;
            } else {
                tempArrayList.add(arrayList.get(j));
                j++;
            }
        }
        while (i < middle) {
            tempArrayList.add(arrayList.get(i));
                i++;
        }
        while (j < end) {
            tempArrayList.add(arrayList.get(j));
            j ++;
        }
        for (E e : tempArrayList) {
            arrayList.set(start, e);
            start ++;
        }
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> arrayList, int start, int end) {
        if (end - start <= 1) return;
        int middle = (start + end) / 2;
        mergeSort(arrayList, start, middle);
        mergeSort(arrayList, middle, end);
        merge(arrayList, start, middle, end);
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> arrayList) {
        mergeSort(arrayList, 0, arrayList.size());
    }
}