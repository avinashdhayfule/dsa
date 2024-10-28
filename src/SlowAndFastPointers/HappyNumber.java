package src.SlowAndFastPointers;

public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n ;
        int fast = n;

        do{
            slow = findSumofSquaresOfDigit(slow);
            fast = findSumofSquaresOfDigit(findSumofSquaresOfDigit(fast));

        }while(slow != fast);

        return slow == 1;
    }

    private int findSumofSquaresOfDigit(int num){
        int digit;
        int sum = 0;

        while(num > 0){
            digit = num % 10;
            sum = sum + digit * digit;
            num = num / 10;

        }

        return sum;

    }
}
