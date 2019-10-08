package com.company;

import java.security.PublicKey;

public class RegularExpressions {
    private String text;
    public void inputText(String line){
        if (line.charAt(line.length() - 1) != ' ') line += ' ';
        text = line;
    }
    public String getText(){return text;}
    public Boolean checkDomen(String domen){
        String str;
        if (domen.indexOf('.') > 0 && domen.indexOf('.') == domen.lastIndexOf('.')){
            str = domen.substring(0, domen.lastIndexOf('.'));
            for (int i = 0; i < str.length(); i++){
                if(str.charAt(i) < 'a' || str.charAt(i) > 'z') return false;
            }
            str = domen.substring(domen.lastIndexOf('.') + 1);
            //if (str == "ru")
            if(str.equals("ru"))
                return true;
            else return false;
        }
        return false;
    }
    private String changDomen(String domen){
        String str = domen.substring(0, domen.lastIndexOf('.'));
        if (domen.substring(domen.lastIndexOf('.')).equals(".ru"))
            return str + ".рус";
        else return domen;
    }
    public void changAllDomens(){
        String str = "";
        int start = 0, end;
        end = text.indexOf(' ');
        if (checkDomen(text.substring(start, end)))
            str += changDomen(text.substring(start, end)) + " ";
        else str+= text.substring(start, end) + " ";
        for (int i = end; i < text.length(); i++){
            start = text.indexOf(' ', i) + 1;
            end = text.indexOf(' ', start);
            if (end < 0) break;
            i = end - 1;
            if (checkDomen(text.substring(start, end)))
                str += changDomen(text.substring(start, end)) + " ";
            else str+= text.substring(start, end) + " ";
        }
        text = str;
    }
}
