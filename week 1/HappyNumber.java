import java.util.*;

public class HappyNumber {
    public boolean isHappy(int n) {
        // keep track of the occurrences
        HashSet<Integer> set = new HashSet<Integer>();

        int num = n;
        int sumPower = 0;
        while (num != 1) {
            while (num > 0) {
                int numSquare = num % 10;
                sumPower += (numSquare * numSquare);
                num /= 10;
            }
            num = sumPower;
            sumPower = 0; // reset the sum of powers
            if (set.contains(num))
                return false;
            set.add(num);
        }
        return true;

    }
}