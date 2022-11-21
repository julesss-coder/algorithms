import java.util.Arrays;

public class FindMaxNumber2 {   
// ================== Version 1, emulating loop ==========================
    
//    public static void main(String[] args) {
//        int[] array = {4, 2, 5, 33, -8};
//        int i = 0;
//        int maxNumber = array[i];
//
//        maxNumber = getMaxNumber(array, i, maxNumber);
//        System.out.println(maxNumber);
//    }
//
//    static int getMaxNumber(int[] array, int i, int maxNumber) {
//        if (i >= array.length - 1) {
//            return maxNumber;
//        }
//
//        if (array[i] > array[i + 1]) {
//            maxNumber = array[i];
//        }
//
//        return getMaxNumber(array, i + 1, maxNumber);
//    }

    
// ================= Version 2, using divide and conquer algorithm ===========================
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 8};
        int maxNumber = getMaxNumber(array);
        System.out.println("maxNumber: " + maxNumber);
    }

    static int getMaxNumber(int[] array) {
        if (array.length <= 1) {
            return array[0];
        }

        int middleIndex = array.length / 2;
        int[] leftArray = Arrays.copyOfRange(array, 0, middleIndex);
        int[] rightArray = Arrays.copyOfRange(array, middleIndex, array.length);

        int leftNumber = getMaxNumber(leftArray);
        int rightNumber = getMaxNumber(rightArray);
        return Math.max(leftNumber, rightNumber);
    }
}
