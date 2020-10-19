package Exs.easy;

/**
 * @author Wei
 * @date 06/03/2020 06/03/2020
 * 7. 整数反转
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-1111111119));
        System.currentTimeMillis();
    }

    public static int reverse(int x) {
            String s= x+"";
            StringBuilder sb=new StringBuilder();
            if (s.charAt(0)=='-'){
                sb.append("-");
                for (int i = s.length()-1; i>0; i--)
                    sb.append(s.charAt(i));
            }
            int result;
            try {
                result=Integer.parseInt(sb.toString());
            }catch (Exception e){
                return 0;
            }

            return result;
    }

    public static int solution(int x){
        int y = 0;
        while (x != 0) {
            if (y > 214748364 || y < -214748364) {
                return 0;
            }
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
    }

}
