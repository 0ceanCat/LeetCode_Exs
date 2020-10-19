package Exs.easy;

/**
 * @author Wei
 * @date 08/03/2020 08/03/2020
 * 9 回文数
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(2332));
    }

    public static boolean isPalindrome(int x) {
        if (x<0 || (x % 10 == 0 && x != 0))
            return false;

        if (x<10)
            return true;

        int result=0;
        while (x>result){
            int temp=x%10;
            result=result*10+temp;
            x=x/10;
        }
        //12321   x=12 result=123
        return x==result || x==result/10;
    }
}
