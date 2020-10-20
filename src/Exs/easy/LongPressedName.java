package Exs.easy;

/**
 * @author Wei
 * @date 2020/10/20 18:31
 * 925. 长按键入
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) return true;

        int index = 0;

        for (int i = 0; i < typed.length(); i++) {
            if (index < name.length() && name.charAt(index) == typed.charAt(i)) {
                index++;
            } else if (i > 0 && typed.charAt(i) == typed.charAt(i - 1)) {
                continue;
            }else {
                return false;
            }
        }
        return index == name.length();
    }

}
