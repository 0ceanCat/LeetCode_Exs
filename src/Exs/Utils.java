package Exs;

import jdk.internal.HotSpotIntrinsicCandidate;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author wy
 * @date 2021/7/12 19:44
 */
public class Utils{
    public static void toArray(String a){
        System.out.println(a.replace("[", "{").replace("]", "}"));
    }

    public static void toArray(String a, boolean chaars){
        System.out.println(a.replace("[", "{")
                .replace("]", "}")
                .replace('\"', '\''));
    }
}
