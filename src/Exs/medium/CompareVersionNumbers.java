package Exs.medium;

/**
 * @author wy
 * @date 2021/8/31 17:47
 */
public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        int idx1 = 0, idx2 = 0, size1 = version1.length(), size2 = version2.length();
        while (idx1 < size1 || idx2 < size2) {
            int a = 0, b = 0;
            while (idx1 < size1 && version1.charAt(idx1) != '.') {
                a = a * 10 + version1.charAt(idx1) - '0';
                idx1++;
            }
            while (idx2 < size2 && version2.charAt(idx2) != '.') {
                b = b * 10 + version2.charAt(idx2) - '0';
                idx2++;
            }

            if (a != b) {
                return a > b ? 1 : -1;
            }
            idx1++;
            idx2++;
        }
        return 0;
    }
    public static void main(String[] args) {
        compareVersion("1.0", "1.0");
    }
}
