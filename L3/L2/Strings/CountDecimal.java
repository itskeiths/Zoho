/*Write a Java program to count the number of decimal places in a given number.*/

import java.util.*;
class CountDecimal{
public static void main(String[] args){
Scanner in  = new Scanner(System.in);
System.out.println("Enter a decimal:");
String dec = in.next();
int len = 0;
if(dec.contains(".")){
len=dec.replaceAll(".*\\.","").length();
}
System.out.println("The digits in decimal places: "+len);
}
}