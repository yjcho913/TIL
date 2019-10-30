package com.scsa.JAVA20191030;

import java.io.IOException;

/*
문제2)아래와 같이 실행하도록 프로그램을 작성하시오.
  
  실행결과)
  
<<구구단>>
  원하는 단? 3
   
 3*1=3
 ...
 3*9=27
  
  계속(y/n)? y
    
  원하는 단? 5
    
 5*1=15
 ...
 5*9=45
  
  계속(y/n)? n
    
 -- END --
 */

/*
2. GugudanTest.java
    ==> main()포함
    ==> 반복적인 실행 (while 또는 do~while문)
    ==> 반복문 내에서 Gugudan클래스내의 메소드들을 적당히 호출.
 */

public class GugudanTest {
	public static void main(String[] args) throws IOException {
		int dan;
		Gugudan gugudan = new Gugudan();

		while(true) {
			dan = gugudan.inputDan();
			gugudan.outputDan(dan);
			if(gugudan.continueDan() == 'n') break;
		}
		System.out.println(" -- END --");
	}
}
