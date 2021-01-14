import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Random;

public class TimeLapse {

    public static int[] selectionSort(int[] list) {
        int minValue = 0;
        int minIndex = 0;
        int temp = 0;
        for (int i = 0; i < list.length; i++) {
            minValue = list[i];
            minIndex = i;
            for (int j = i; j < list.length; j++) {
                if (list[j] < minValue) {
                    minValue = list[j];
                    minIndex = j;
                }
            }
            if (minValue < list[i]) {
                temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Random rd = new Random();
        int[] testArray = new int[100000]; // initialize an array
        System.out.println("Start creating array");
        // measure the time it takes to create the array
        LocalDateTime startArray = LocalDateTime.now();
        System.out.println(dtf.format(startArray));
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = rd.nextInt(1000000);
        }
        System.out.println("Done creating array");
        LocalDateTime endArray = LocalDateTime.now();
        System.out.println(dtf.format(endArray));

        // measure the time it takes to sort the array
        System.out.println("Start sorting");
        LocalDateTime startSort = LocalDateTime.now();
        System.out.println(dtf.format(startSort));
        int[] result = selectionSort(testArray);
        LocalDateTime endSort = LocalDateTime.now();
        System.out.println("Sorting done.");
        System.out.println(dtf.format(endSort));
    }
}