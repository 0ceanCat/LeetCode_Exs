package Exs.medium;

/**
 * @author wy
 * @date 2021/9/9 17:24
 */
// 1894. 找到需要补充粉笔的学生编号
public class FindTheStudentThatWillReplaceTheChalk {
    public int chalkReplacer(int[] chalk, int k) {
        long[] sums = new long[chalk.length];
        if (chalk[0] > k) {
            return 0;
        }
        sums[0] = chalk[0];

        for (int i = 1; i < chalk.length; ++i) {
            sums[i] = sums[i - 1] + chalk[i];
            if (sums[i] > k) {
                return i;
            }
        }

        return search(k % sums[chalk.length - 1], sums);
    }

    private int search(long target, long[] sums) {
        int l = 0, r = sums.length - 1;

        while (l <= r){
            int mid = (l + r) >> 1;
            if (sums[mid] < target) l = mid + 1;
            else if(sums[mid] > target) r = mid - 1;
            else return (mid+ 1) % sums.length;
        }

        return l;
    }
    public static void main(String[] args) {
        FindTheStudentThatWillReplaceTheChalk f = new FindTheStudentThatWillReplaceTheChalk();
        f.chalkReplacer(new int[]{2,2,3},1);
    }
}
