package Exs.easy;

/**
 * @author wy
 * @date 2021/5/5 17:00
 */
// 1720. 解码异或后的数组
public class DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;

        for (int i = 0; i < encoded.length; i++) {
            res[i + 1] = res[i] ^ encoded[i];
        }

        return res;
    }


}
