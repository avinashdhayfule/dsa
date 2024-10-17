package BinarySearch;

public class CelingBinarySearch {
    public static void main(String[] args) {
        int[] arr = {4, 6, 10};
        System.out.println(findBinarySearch(6, arr));
        System.out.println(findBinarySearch(17, arr));
        System.out.println(findBinarySearch(-1, arr));

        int[] arr1 = {1, 3, 8, 10, 15};
        System.out.println(findBinarySearch(12, arr1));

    }
    public static int findBinarySearch(int key, int[] arr){
        if(arr[arr.length - 1] < key) return -1;

        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int middle = start + (end - start)/2;
            if(arr[middle] == key) return middle;

            if(key < arr[middle]){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }

        return start;
    }
}
