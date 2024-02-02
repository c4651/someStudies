package algosy;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 6, 9, 11, 234};
        int item = 4;
        System.out.println(binarySearch(array, item));
    }

    static int binarySearch(int [] array, int item){
        int low = 0;
        int high = array.length - 1;
        int mid;
        int guess;
        while (low <= high){
            mid = (low + high) / 2;
            guess = array[mid];
            if (guess == item){
                return mid;
            }
            if (guess < item){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
