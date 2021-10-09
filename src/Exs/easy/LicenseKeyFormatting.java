package Exs.easy;

import javax.xml.stream.events.Characters;

/**
 * @author wy
 * @date 2021/10/3 18:30
 */
// 482. 密钥格式化
public class LicenseKeyFormatting {
    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (c == k){
                c = 0;
                sb.append('-');
            }
            if (s.charAt(i) == '-') continue;
            sb.append(Character.toUpperCase(s.charAt(i)));
            c++;
        }

        if (sb.charAt(sb.length() - 1) == '-') sb.deleteCharAt(sb.length() - 1);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        licenseKeyFormatting("--a-a-a-a--", 2);

    }
}
