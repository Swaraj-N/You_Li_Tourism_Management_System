package org.tourismManagement.practice;

import java.util.Scanner;

public class Stringfunctionalities {
public static void main(String[] args) {
	String s="Hello %s";
	Scanner sc=new Scanner(System.in);
	String next = sc.next();
String format = String.format(s, next);
System.out.println(format);
}
}
