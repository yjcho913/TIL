package com.scsa.JAVA20191101;

import java.util.StringTokenizer;

public class StringTest3 {
  public static void main(String[] args) {
      String str="JavaProgramming";
      
      //특정문자열로 시작하는 체크 
      System.out.println("str은 'Jav'로 시작하는가? >>> "
    		  + str.startsWith("Jav"));
      System.out.println("str은 'av'로 시작하는가? >>> "
    		  + str.startsWith("av"));
            
      //특정문자열로 끝나는지 체크  
      System.out.println("str은 'ing'로 끝나는가? >>> "
    		  + str.endsWith("ing"));
      
      //특정문자열이 포함되었는지 체크
      //대소문자 구분함!
      System.out.println("str이 'Pro'를 포함하는가? >>> "
    		  + str.contains("Pro"));
      System.out.println("str이 'pro'를 포함하는가? >>> "
    		  + str.contains("pro"));
      
      
      System.out.println("================문제==================");
      String tel="010-123-5678";
      //문제) String tel1, tel2, tel3변수를 선언하고 각각 "010", "1234", "5678"을 저장 후 
      //     화면에 각 변수의 값을 출력하시오.
      //     힌트: substring()메소드와 indexOf()메소드를 사용.
      //주의) tel값은 02-123-4567   또는  053-123-5656 변경가능	
      
      String tel1 = tel.substring(0, tel.indexOf('-'));
      String tel2 = tel.substring(tel.indexOf('-') + 1, tel.lastIndexOf('-'));
      String tel3 = tel.substring(tel.lastIndexOf('-') + 1);
      
      System.out.println("Tel1= " + tel1);
      System.out.println("Tel2= " + tel2);
      System.out.println("Tel3= " + tel3);
      System.out.println("==========================================");
      
      //특정 구분자를 통해 나뉘어진 부분문자열 구하기(1)
      //StringTokenizer(String str, String delim)
      // str : 구분하고자하는 전체 문자열
      // delim : 구분자
      // token : 구분자를 통해 만들어진 부분 문자열 데이터
      //split 보다 tokenizer가 성능이 더 좋음!
      //공백의 데이터는 무시!
      StringTokenizer st = new StringTokenizer(tel, "-");
      int i = 0;
      while(st.hasMoreTokens()) {
    	  i++;
    	  System.out.println("Tel" + i + "= " + st.nextToken());
      }
      System.out.println("==========================================");
      
      
      // 특정 구분자를 통해 나뉘어진 부분문자열 구하기(2)
      // tel.split(String regex)
      // regex : 정규표현식
      // 공백의 데이터도 담음
      String []tels = tel.split("-");
      for (int j = 0; j < tels.length; j++) {
    	  System.out.println("tels[" + j + "] = " + tels[j]);
      }
      System.out.println("==========================================");
  }
}