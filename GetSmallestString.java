 public class GetSmallestString{
    public String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        k = k - n;
        while(k > 0){
            if(chars[n - 1] < 'z'){
                chars[n-1]++;
                k = k -1;
            }else{
                n = n-1;
            }
        }
        return new String(chars);
    }
}
