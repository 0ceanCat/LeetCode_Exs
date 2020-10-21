package Exs.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wei
 * @date 2020/10/21 19:55
 * 763. 划分字母区间
 */
public class PartitionLabels {

  /*public List<Integer> partitionLabels(String S) {
      List<Integer> list = new ArrayList<>();
      Map<Character,Integer> map = new HashMap<>();

      for (int i = 0; i < S.length(); i++) {
          map.put(S.charAt(i), i);
      }

      int start = 0;
      int end = 0;

      for (int i = 0; i < S.length(); i++) {
          end = Math.max(end, map.get(S.charAt(i)));
          if (i == end){
              list.add(i - start + 1);
              start = end + 1;
          }
      }
      return list;
  }*/

    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int[] lasts = new int[26];

        for (int i = 0; i < S.length(); i++) {
            lasts[S.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lasts[S.charAt(i) - 'a']);
            if (i == end){
                list.add(i - start + 1);
                start = end + 1;
            }
        }
        return list;
    }

}
