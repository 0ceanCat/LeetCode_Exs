package Exs.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2021/9/30 21:46
 */
// 1436. 旅行终点站
public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Map<String, String> m = new HashMap<>();
        String des = paths.get(0).get(1);

        for (List<String> path : paths) {
            m.put(path.get(0), path.get(1));
        }

        for (List<String> path : paths) {
            String s = m.get(des);
            if (s != null) des = s;
            else return des;
        }

        return des;
    }
}
