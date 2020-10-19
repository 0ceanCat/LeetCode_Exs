package Exs.easy;

/**
 * @author Wei
 * @date 2020/8/10 10:41
 * 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        char lastChar = chars[0];
        int total = 0;
        int lastCount = 0;
        int lastCount2 = 0;

        for (char c : chars){
            if (c != lastChar){
                lastChar = c;
                total += Math.min(lastCount,lastCount2);

                lastCount2 = lastCount;
                lastCount = 0;
            }

            lastCount++;
        }

        total += Math.min(lastCount,lastCount2);   //"00110" 加入最后一对10的计数
        return total;
    }
}
