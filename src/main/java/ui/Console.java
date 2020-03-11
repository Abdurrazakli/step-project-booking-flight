package ui;

import java.util.Scanner;

public class Console {

    public void print(String line){
        System.out.println(line);
    }

    public String read(){
        Scanner sc = new Scanner(System.in);
        String input = sc.next().trim();
        return input;
    }
    public String readLine(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input.trim();
    }
}
