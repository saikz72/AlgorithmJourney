// Learning recursion
class HelloWorld {
    public static void main(String[] args) {
        // int N = 348;
        // System.out.println(mystery(N));
        String input = "byebye";
        System.out.println(isPallindrome(input));
    }
    
    private static int mystery(int N){
        if( N < 10 )
            return (N * 10) + N;
        int a = mystery( N / 10 );
        int b = mystery( N % 10 );
        return ( 100 * a ) + b;
    }
    
    private static boolean isPallindrome(String str){
        if(str.length() == 0 || str.length() == 1){
            return true;
        }
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        if(first == last && isPallindrome(str.substring(1, str.length() - 1)))
            return true;
        return false;
    }
    
}
