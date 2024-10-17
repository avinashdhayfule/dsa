package BinarySearch;

public class SearchInfiniteSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
        System.out.println(search(new ArrayReader(arr), 16));
        System.out.println(search(new ArrayReader(arr), 13));
        System.out.println(search(new ArrayReader(arr), 13));
        int[] arr1 = {1, 3, 8, 10, 15};
        System.out.println(search(new ArrayReader(arr1), 15));
    }
    public static int search(ArrayReader reader, int key){
        int start = 0;
        int end = 1;

        while(reader.get(end) < key){
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return binarySearch(reader, key, start, end);

    }

    private static int binarySearch(ArrayReader reader, int key, int start, int end) {

        while(start <= end){
            int mid = start + (end-start)/2;

            if(reader.get(mid) == Integer.MAX_VALUE) return -1;

            if(reader.get(mid) == key) return mid;

            if(key < reader.get(mid)){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }
}

class ArrayReader{
    int[] arr;
    public ArrayReader(int[] arr){
        this.arr = arr;
    }

    public int get(int index){
        if(index >= arr.length) return Integer.MAX_VALUE;

        return arr[index];
    }

}
