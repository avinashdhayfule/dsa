package src.SlowAndFastPointers;

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {

        for(int i = 0; i < nums.length; i++){
            int slow = i;
            int fast = i;
            boolean isForwadDirection = (nums[i] > 0);
            do{
                slow = getNextIndexVal(nums, isForwadDirection, slow);
                fast = getNextIndexVal(nums, isForwadDirection, fast);
                if(fast != -1){
                    fast = getNextIndexVal(nums, isForwadDirection, fast);
                }
            }while(slow != -1 && fast != -1 && slow != fast);

            if(slow != -1 && slow == fast)
                return true;
        }

        return false;

    }

    private int getNextIndexVal(int[] nums, boolean isForwadDirection, int index){
        boolean direction = (nums[index] > 0);

        if(direction != isForwadDirection)
            return -1;

        int val = (index + nums[index]) % nums.length;

        if(val < 0)
            val = val + nums.length;

        if(index == val)
            return -1; //single node in list

        return val;
    }
}
