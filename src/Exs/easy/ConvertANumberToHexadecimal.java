package Exs.easy;

/**
 * @author wy
 * @date 2021/10/1 17:01
 */
// 405. 数字转换为十六进制数
public class ConvertANumberToHexadecimal {
    public static String toHex(int num) {
        String hex =  "0123456789abcdef";
        // 0xf = 1111
        // 15 = 1111
        StringBuilder sb = new StringBuilder();
        while(num != 0 && sb.length() < 8){
            sb.append(hex.charAt(num & 0xf));
            num >>=  4;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println((int)'9');
        System.out.println(Integer.toBinaryString(0xf));
    }
}
