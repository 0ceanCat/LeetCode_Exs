package Exs.medium;



import java.util.ArrayList;
import java.util.List;

/**
 * @author Wei
 * @date 06/03/2020 06/03/2020
 * 6. Z 字形变换
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        String s="AB";
        System.out.println(convert(s,1));
    }
    public static String convert(String s, int numRows) {
        int middle = numRows-2;
        if (middle<0){
            return s;
        }
        int len=s.length();
        if (len<=1){
            return s;
        }
        String result="";
        int middlecounter=0;
        for (int i=0;i<numRows;i++){

            int pointer=i;
            int middlePointer=numRows+middle-1;
            if (i>1&&middlecounter<middle){
                middlePointer=numRows+middle-i;
                middlecounter++;
            }

            int counter=0;
            while (pointer<len||middlePointer<len){
                if (i==0 || i==numRows-1){
                    if (pointer<len)
                        result=result+s.charAt(pointer);
                    else
                        break;
                    pointer=pointer+numRows+middle;
                }else{
                    if (counter%2==0){
                        if (pointer<len)
                            result=result+s.charAt(pointer);
                        else
                            continue;
                        pointer=pointer+numRows+middle;
                    }else{
                        if (middlecounter<len&&middlePointer>numRows-1)
                            result=result+s.charAt(middlePointer);
                        middlePointer=middlePointer+numRows+middle;
                    }
                }
                counter++;
            }
        }

        return result;
    }

    public String convertSolution(String s,int numRows){
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        StringBuilder ss=new StringBuilder();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

}
