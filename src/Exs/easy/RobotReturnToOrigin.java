package Exs.easy;

/**
 * @author Wei
 * @date 2020/8/29 12:00
 * 657. 机器人能否返回原点
 */
public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)){
                case 'R': x++; break;
                case 'L': x--; break;
                case 'U': y++; break;
                case 'D': y--; break;
            }
        }

        return y == 0 && x == 0;
    }
}
