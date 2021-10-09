package Exs.medium;

/**
 * @author wy
 * @date 2021/8/20 17:05
 */
// 443. 压缩字符串
public class StringCompression {
    public static int compress(char[] chars) {
        int i = 0;
        int c = 1;
        int n = chars.length;
        char last = chars[0];
        for (int k = 1; k < n; k++) {
            if (chars[k] == last) {
                c++;
            }else{
                chars[i++] = last;
                last = chars[k];
                if (c == 1) continue;
                String count = String.valueOf(c);
                for (int j = 0; j < count.length(); j++) {
                    chars[i++] = count.charAt(j);
                }
                c = 1;
            }

        }
        chars[i++] = last;
        if (c != 1){
            String count = String.valueOf(c);
            for (int j = 0; j < count.length(); j++) {
                chars[i++] = count.charAt(j);
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        compress(new char[]{'a','a','b','b','c','c','c'});
    }
}
