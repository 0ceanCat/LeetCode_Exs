package Exs.easy;

/**
 * @author wy
 * @date 2021/3/18 17:20
 */
// 1603. 设计停车系统
public class DesignParkingSystem {
    private static class ParkingSystem{
        int[] car = new int[4];
        public ParkingSystem(int big, int medium, int small) {
            car[1] = big;car[2] = medium;car[3] = small;
        }
        public boolean addCar(int carType) {
            return car[carType] != 0 && car[carType]-- > 0;
        }
    }
}
