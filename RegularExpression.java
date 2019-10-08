package com.company;

public class RegularExpression {
    String text;
    public void inputText(String str){
        if (str.charAt(str.length() - 1) != ' ')
            str += ' ';
        text = str;
    }
    public String ghetText(){return text;}
    public static Boolean checkNum(String str){
        if (str.length() == 2) {
            if (str.charAt(0) == str.charAt(1) && str.charAt(0) >= '0' && str.charAt(0) <= '9')
                    return true;
                else return false;
            }
        else return false;
    }
    public void changeNum(){
        String str = "";
        int start = 0, end = text.indexOf(' ');
        if (checkNum(text.substring(start, end)))
                str+= "* ";
        else str += text.substring(start,end) + ' ';
        for(int i = end; i < text.length(); i++){
            start = text.indexOf(' ', i) + 1;
            end = text.indexOf(' ', start);
            if (end < 0 ) break;
            i = end - 1;
            if (checkNum(text.substring(start, end)))
                str+= "* ";
            else str += text.substring(start,end) + ' ';
        }
        text = str;
    }
}
