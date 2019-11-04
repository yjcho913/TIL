package com.scsa.JAVA20191101;

public class StringTest2 {
  public static void main(String[] args) {
	  String s1="java";
	  String s2="JaVA";
	  
	//���ڿ� s1,s2�� ��(���ڿ� �����)�Ͻÿ�
	  if(s1.equals(s2)) {
		  System.out.println("s1�� s2�� ���� ���ڿ�");
	  }else {
		  System.out.println("s1�� s2�� �ٸ� ���ڿ�");
	  }
	  
	//��ҹ��� ���о��� s1�� s2ö�ڸ� ���Ͻÿ�!!
	  System.out.println("s1�� ��ü �빮�ڷ� ��ȯ >>> "+ s1.toUpperCase());
	  System.out.println("s2�� ��ü �ҹ��ڷ� ��ȯ >>> "+ s2.toLowerCase());
	  System.out.println("��ҹ��� ���� ���� ��: " + s1.toUpperCase().equals(s2.toUpperCase()));
	  System.out.println("��ҹ��� ���� ���� ��: " + s1.equalsIgnoreCase(s2));
	  
	  
	  System.out.println("======= ���� =======");	
	//����) str���ڿ� �ȿ� �ִ� ������ ������ ȭ�鿡 ����Ͻÿ�. 
    //     ----> ��Ʈ) ���ڿ����� �� ���ڵ��� �ε����� ���´�!!
	  String str="Java3Pro7gra9mm0ing";
	  int cnt = 0;
	  
	  for (int i = 0; i < str.length(); i++) {
		char ch = str.charAt(i);
		if(ch >= '0' && ch <= '9') cnt++;
	  }
	  System.out.println("���� ���� = " + cnt);
	  
	  
	  String str1="JavaProgramming";
	  System.out.println("=======byte�迭 ��ȯ=======");	
	  byte []b = str1.getBytes();
//	  for (int i = 0; i < b.length; i++) {
//		System.out.println(b[i] + " " );
//	  }
	  // JDK5 ���� ---> ������ for�� ����
	  // ���� ) for(�ڷ��� ������ : �迭��)
	  for(byte v : b) {
		  System.out.print(v + " ");
	  }
	  System.out.println();
	  
	  
	  System.out.println("=======byte�迭�� ���ڿ��� ��ȯ=======");
	  String str2 = new String(b);
	  System.out.println("STR2 >>> "+ str2);
	  
	  
	  System.out.println("=======char�迭 ��ȯ=======");
	  char []ch = str1.toCharArray();
	  for(char c : ch) {
		  System.out.print(c + " ");
	  }
	  System.out.println();
	  
	  
	  System.out.println("=======char�迭�� ���ڿ��� ��ȯ=======");
	  String str3 = new String(ch);
	  System.out.println("STR3 >>> "+ str3);
 }
}
