package Exs.medium;

import java.util.List;

/**
 * @author Wei
 * @date 2020/8/31 10:11
 * 841. 钥匙和房间
 */
public class KeysAndRooms {
    int result = 0;
    boolean[] roomsArray;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        roomsArray = new boolean[size];
        dfs(rooms,0);

        return result == size;
    }

    private void dfs(List<List<Integer>> rooms, int i) {
        roomsArray[i] = true;
        result++;

        for (Integer key : rooms.get(i)){
            if (!roomsArray[key])
                dfs(rooms, key);
        }

    }

}
