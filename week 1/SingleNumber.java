public class SingleNumber {
    public int singleNumber(int[] nums) {
        int singleNum = 0;
        for (int element : nums)
            singleNum ^= element;
        return singleNum;
    }
}