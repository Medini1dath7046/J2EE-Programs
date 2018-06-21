/**
 * 
 */
package com.bridgelabz.jdbc;

/**
 * Created By:Medini P.D
 * Date:- 12/06/2018
 * Purpose:
 */
public class StringPoolTest {
    public static void main(String[] args) { // Integer.valueOf(), String.equals()
        String eol = System.getProperty("line.separator"); //java7 System.lineSeparator();

        String s1 = "Yash".intern();
        System.out.format("Val:%s Hash:%s SYS:%s "+eol, s1, s1.hashCode(), System.identityHashCode(s1));
        String s2 = "Yas"+"h".intern();
        System.out.format("Val:%s Hash:%s SYS:%s "+eol, s2, s2.hashCode(), System.identityHashCode(s2));
        String s3 = "Yas".intern()+"h".intern();
        System.out.format("Val:%s Hash:%s SYS:%s "+eol, s3, s3.hashCode(), System.identityHashCode(s3));
        String s4 = "Yas"+"h";
        System.out.format("Val:%s Hash:%s SYS:%s "+eol, s4, s4.hashCode(), System.identityHashCode(s4));
    }
}