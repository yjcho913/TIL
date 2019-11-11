package com.scsa.JAVA20191108;

import java.io.File;
import java.util.Scanner;

public class ScannerTest {
   public static void main(String[] args) throws Exception {
	  //Scanner scan = new Scanner(System.in);
	  Scanner scan = new Scanner(new File("src/com/scsa/j1108/sample.txt"));
	  System.out.println(scan.nextInt());
	  System.out.println(scan.nextInt());
	  System.out.println(scan.nextInt());
	  System.out.println(scan.nextInt());
	  System.out.println(scan.nextInt());
	  
	  System.out.println(scan.next());
	  System.out.println(scan.next());
	  
	  
   }
}
