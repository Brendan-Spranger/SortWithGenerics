import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import person.Student;
import sorting.Sort;

public class App {

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> ArrayList<Student<T>> createRandomArray(int arrayLength, String typeName) {
        ArrayList<Student<T>> arrayList = new ArrayList<>(arrayLength);
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            String id = String.valueOf(i);
            switch (typeName) {
                case "Integer":
                    arrayList.add((Student<T>) new Student<Integer>(id, random.nextInt(100)));
                    break;
                case "Float":
                    arrayList.add((Student<T>) new Student<Float>(id, random.nextFloat(100)));
                    break;
                case "Double":
                    arrayList.add((Student<T>) new Student<Double>(id, random.nextDouble(100)));
                    break;
                default:
                    System.out.println("Use integer as the grade data type.");
                    arrayList.add((Student<T>) new Student<Integer>(id, random.nextInt(100)));
            }
        }
        return arrayList;
    }

    public static <T extends Comparable<T>> void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + "Please input the array size: ");
            System.out.print("\n" + ">");
            int arrayLength = scanner.nextInt();
            System.out.println("\n" + "Please enter the grade data type (choose Integer, Float, or Double): ");
            System.out.print("\n" + ">");
            String typeName = scanner.next();
            ArrayList<Student<T>> arrayList = createRandomArray(arrayLength, typeName);
            System.out.println("\n" + arrayList.toString());
            System.out.print("The array is sorted: ");
            System.out.println(Sort.isSorted(arrayList));
            Sort.mergeSort(arrayList);
            System.out.println("\n" + arrayList.toString());
            System.out.print("The array is sorted: ");
            System.out.println(Sort.isSorted(arrayList));
            
            System.out.println("\n" + "Continue? Please enter yes or no.");
            System.out.print("\n" + ">");
            String yesNo = scanner.next();
            if (yesNo.equals("no")) break;
        }
        scanner.close();
    }
}