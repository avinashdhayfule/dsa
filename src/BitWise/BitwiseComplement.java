package src.BitWise;

public class BitwiseComplement {
    public int bitwiseComplement(int n) {
        if( n == 0) return 1;

        int bitcount = 0;
        int num = n;
        while(num > 0){
            bitcount++;
            num = num >> 1;
        }

        int allBitSet = (int) Math.pow(2, bitcount) - 1;

        return n ^ allBitSet;
    }
}
