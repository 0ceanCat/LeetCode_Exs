package Exs.medium;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/**
 * @author wy
 * @date 2021/8/25 17:49
 */
public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                ++light;
            }
            --heavy;
            ++ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        numRescueBoats(new int[]{3,2,2,2,3}, 6);
        LocalDate from = LocalDate.of(2019, 8, 28);
        LocalDate now = LocalDate.now();
        long until = from.until(now, ChronoUnit.DAYS);
        System.out.println(until);
    }
}
