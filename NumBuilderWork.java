package com.company;

public class NumBuilderWork {
    private StringBuilder line;
    public void inputLine(String str){
        if (str.charAt(str.length() - 1) != ' ') str+= " ";
        line = new StringBuilder(str);
    }
    public StringBuilder getLine(){return line;}
    public static StringBuilder toSixteen(int num){
        StringBuilder str = new StringBuilder(""), str1 = new StringBuilder("");
        Integer a;
        while (num > 0){
            a = num % 16;
            if (a >= 10){
                switch (a){
                    case 10:
                        str.append('A');
                        break;
                    case 11:
                        str.append('B');
                        break;
                    case 12:
                        str.append('C');
                        break;
                    case 13:
                        str.append('D');
                        break;
                    case 14:
                        str.append('E');
                        break;
                    case 15:
                        str.append('F');
                        break;
                }
            }
            else str.append(a.toString());
            num/= 16;
        }
        return str.reverse();
    }
    public void allToSixteen(){
        StringBuilder str = new StringBuilder(""), buf;
        int start = 0, end;
        end = line.indexOf(" ");
        buf = toSixteen(Integer.parseInt(line.substring(start, end)));
        if (haveChar(buf))
            str.append(buf + " ");
        else
            str.append(line.substring(start, end) + " ");
        for (int i = end; i < line.length(); i++){
            start = line.indexOf(" ", i) + 1;
            end = line.indexOf(" ", start);
            if (end < 0) break;
            i = end - 1;
            buf = toSixteen(Integer.parseInt(line.substring(start, end)));
            if (haveChar(buf))
                str.append(buf + " ");
            else
                str.append(line.substring(start, end) + " ");
            //str.append(toSixteen(Integer.parseInt(line.substring(start, end))) + " ");
        }
        line = str;
    }
    private Boolean haveChar(StringBuilder str){
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                return true;
            }
        }
        return false;
    }
    public void addSum(){
        int sum = 0;
        int start = 0, end;
        end = line.indexOf(" ");
        if (!(haveChar(new StringBuilder(line.substring(start, end)))))
            sum += Integer.parseInt(line.substring(start, end));
        for (int i = end; i < line.length(); i++) {
            start = line.indexOf(" ", i) + 1;
            end = line.indexOf(" ", start);
            i = end - 1;
            if(end < 0) break;
            if (!(haveChar(new StringBuilder(line.substring(start, end)))))
                sum += Integer.parseInt(line.substring(start, end));
        }
        line.append(sum);
        line.append(' ');
    }
    public void changeAllNums(){
        char buf;
        int start = 0, end;
        end = line.indexOf(" ") - 1;
        buf = line.charAt(start);
        line.setCharAt(start, line.charAt(end));
        line.setCharAt(end, buf);
        for (int i = end + 1; i < line.length(); i++){
            start = line.indexOf(" ", i) + 1;
            end = line.indexOf(" ", start) - 1;
            if (end < 0) break;
            i = end;
            buf = line.charAt(start);
            line.setCharAt(start, line.charAt(end));
            line.setCharAt(end, buf);
        }
    }
}
