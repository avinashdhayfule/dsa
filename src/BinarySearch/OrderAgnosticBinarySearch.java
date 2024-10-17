package BinarySearch;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = {4, 6, 10};
        System.out.println(findInMountainArray( 10, arr));

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(findInMountainArray( 5, arr1));

        int[] arr3 = {10, 6, 4};
        System.out.println(findInMountainArray( 10, arr3));
        System.out.println(findInMountainArray( 4, arr3));
    }
    public static int findInMountainArray(int target, int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAscending = (arr[start] < arr[end]) ? true : false;
        while(start <= end){
            int middle = start + (end - start)/2;
            if(arr[middle] == target) return middle;
            if(isAscending){
                if(target < arr[middle]){
                    end = middle - 1;
                }else{
                    start = middle + 1;
                }
            }else{
                if(target < arr[middle]){
                    start = middle + 1;
                }else{
                    end = middle - 1;
                }
            }
        }

        return -1;
    }
}
