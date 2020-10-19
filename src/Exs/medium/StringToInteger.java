package Exs.medium;

/**
 * @author Wei
 * @date 08/03/2020 08/03/2020
 * 8. 字符串转换整数 (atoi)
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi(" -101002363023234"));
    }

    public static int myAtoi(String str) {
        str=str.trim();
        int n=str.length();
        if (n==0){
            return 0;
        }
        boolean flag=false;
        if (str.charAt(0)=='-'){
            flag=true;
        }
        int i=0;
        if(str.charAt(i)=='-' || str.charAt(i)=='+') {
            ++i;
        }

        int result=0;
        for (;i<n;i++){
            if (flag&&i==0){
            }else {
                if (!Character.isDigit(str.charAt(i)))
                    break;
                int temp = str.charAt(i)-48;

                if(!flag &&(result>214748364 ||(result==214748364 && temp>=7))) {
                    return 2147483647;
                }
                //判断是否小于 最小32位整数
                if(flag &&(-result<-214748364 || (-result==-214748364 && temp>=8))) {
                    return -2147483648;
                }

                result=result*10+temp; //ASCII码
            }

        }
        if (flag)
            return -result;
        else
            return result;
    }
}
