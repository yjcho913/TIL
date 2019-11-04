package com.scsa.JAVA20191101;

import java.util.StringTokenizer;

public class StringTest3 {
  public static void main(String[] args) {
      String str="JavaProgramming";
      
      //Ư�����ڿ��� �����ϴ� üũ 
      System.out.println("str�� 'Jav'�� �����ϴ°�? >>> "
    		  + str.startsWith("Jav"));
      System.out.println("str�� 'av'�� �����ϴ°�? >>> "
    		  + str.startsWith("av"));
            
      //Ư�����ڿ��� �������� üũ  
      System.out.println("str�� 'ing'�� �����°�? >>> "
    		  + str.endsWith("ing"));
      
      //Ư�����ڿ��� ���ԵǾ����� üũ
      //��ҹ��� ������!
      System.out.println("str�� 'Pro'�� �����ϴ°�? >>> "
    		  + str.contains("Pro"));
      System.out.println("str�� 'pro'�� �����ϴ°�? >>> "
    		  + str.contains("pro"));
      
      
      System.out.println("================����==================");
      String tel="010-123-5678";
      //����) String tel1, tel2, tel3������ �����ϰ� ���� "010", "1234", "5678"�� ���� �� 
      //     ȭ�鿡 �� ������ ���� ����Ͻÿ�.
      //     ��Ʈ: substring()�޼ҵ�� indexOf()�޼ҵ带 ���.
      //����) tel���� 02-123-4567   �Ǵ�  053-123-5656 ���氡��	
      
      String tel1 = tel.substring(0, tel.indexOf('-'));
      String tel2 = tel.substring(tel.indexOf('-') + 1, tel.lastIndexOf('-'));
      String tel3 = tel.substring(tel.lastIndexOf('-') + 1);
      
      System.out.println("Tel1= " + tel1);
      System.out.println("Tel2= " + tel2);
      System.out.println("Tel3= " + tel3);
      System.out.println("==========================================");
      
      //Ư�� �����ڸ� ���� �������� �κй��ڿ� ���ϱ�(1)
      //StringTokenizer(String str, String delim)
      // str : �����ϰ����ϴ� ��ü ���ڿ�
      // delim : ������
      // token : �����ڸ� ���� ������� �κ� ���ڿ� ������
      //split ���� tokenizer�� ������ �� ����!
      //������ �����ʹ� ����!
      StringTokenizer st = new StringTokenizer(tel, "-");
      int i = 0;
      while(st.hasMoreTokens()) {
    	  i++;
    	  System.out.println("Tel" + i + "= " + st.nextToken());
      }
      System.out.println("==========================================");
      
      
      // Ư�� �����ڸ� ���� �������� �κй��ڿ� ���ϱ�(2)
      // tel.split(String regex)
      // regex : ����ǥ����
      // ������ �����͵� ����
      String []tels = tel.split("-");
      for (int j = 0; j < tels.length; j++) {
    	  System.out.println("tels[" + j + "] = " + tels[j]);
      }
      System.out.println("==========================================");
  }
}