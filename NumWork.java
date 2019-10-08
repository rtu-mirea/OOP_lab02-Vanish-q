package com.company;

public class NumWork {
    private String line = "";
    public void inputLine(String line){
        if (line.charAt(line.length() - 1) != ' ') line += ' ';
        this.line = line;
    }
    public String getLine(){return line;}
    public int findMaxDigit(){
        int digit = 0, maxdigit = 0;
        for(int i = 0; i < line.length(); i++){
            if (line.charAt(i) == ' ') {
                if (maxdigit < digit) {
                    maxdigit = digit;
                }
                digit = 0;
            }
            else digit++;
        }
        return maxdigit;
    }
    public static String toSixteen(int num){
        String str = "";//, str1 = "";
        int a;
        while (num > 0){
            a = num % 16;
            if (a >= 10){
                switch (a){
                    case 10:
                        str = "A" + str;
                        break;
                    case 11:
                        str = "B"  + str;
                        break;
                    case 12:
                        str = "C"  + str;
                        break;
                    case 13:
                        str = "D"  + str;
                        break;
                    case 14:
                        str = "E"  + str;
                        break;
                    case 15:
                        str = "F"  + str;
                        break;
                }
            }
            else str= a + str;
            num/= 16;
        }
        /*for(int i = str.length() - 1; i >= 0; i--){
            str1+= str.charAt(i);
        }*/
        return str;
    }
    private String allToSixteen(){
        String str = "";
        int start = 0, end;
        end = line.indexOf(' ');
        str += toSixteen(Integer.parseInt(line.substring(start, end))) + " ";
        for (int i = end; i < line.length(); i++){
            start = line.indexOf(' ', i) + 1;
            end = line.indexOf(' ', start);
            if (end < 0) break;
            i = end - 1;
            str += toSixteen(Integer.parseInt(line.substring(start, end))) + " ";
        }
        return str;
    }
    private Boolean haveChar(String str){
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                return true;
            }
        }
        return false;
    }
    public String makeWords(){
        String str = allToSixteen(), str1 = "";
        int start = 0, end;
        end = line.indexOf(' ');
        if (haveChar(str.substring(start, end))){
            str1 += str.substring(start, end);
        }
        for (int i = end; i < str.length(); i++){
            start = str.indexOf(' ', i) + 1;
            end = str.indexOf(' ', start);
            if (end < 0) break;
            i = end - 1;
            if (haveChar(str.substring(start,end))){
                str1 += str.substring(start, end) + " ";
            }
        }
        return str1;
    }
    private String changeNum(String str){
        if (str.length() == 1) return str;
        String str1 = "";
        char first = str.charAt(0), last = str.charAt(str.length() - 1);
        if (str.length() == 2)
            return str1 + last + first;
        else
            return last + str.substring(1, str.lastIndexOf(last)) + first;
    }
    public void changeAllNums(){
        String str = "";
        int start = 0, end;
        end = line.indexOf(' ');
        str += changeNum(line.substring(start, end)) + " ";
        //str += toSixteen(Integer.parseInt(line.substring(start, end))) + " ";
        for (int i = end; i < line.length(); i++){
            start = line.indexOf(' ', i) + 1;
            end = line.indexOf(' ', start);
            if (end < 0) break;
            i = end - 1;
            str += changeNum(line.substring(start, end)) + " ";
        }
        line = str;
    }
    public int[] indArr(){
        int arr[], len = 0, count = 0, ind = 0;
        if (line.length() == 2) return new int[]{0};
        for (int i = line.lastIndexOf(' ') - 1; i >= 0 ; i--){
            if (line.charAt(i) == ' '){
                len = i + 1;
                break;
            }
        }
        Integer num = Integer.parseInt(line.substring(len, line.lastIndexOf(' ')));
        len = num.toString().length();
        for(int i = 0; i < line.length(); i++){
            i = line.indexOf(num.toString(), i);
            if (i < 0) break;
            else count++;
        }
        arr = new int[len * count];
        for(int i = 0; i < line.length(); i++){
            i = line.indexOf(num.toString(), i);
            if (i < 0) break;
            else{
                for(int j = 0; j < len; j++){
                    arr[ind] = i + j;
                    ind++;
                }
            }
        }
        return arr;
    }
}
