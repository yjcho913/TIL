package com.scsa.JAVA20191030;

import java.io.IOException;

/*
����2)�Ʒ��� ���� �����ϵ��� ���α׷��� �ۼ��Ͻÿ�.
  
  ������)
  
<<������>>
  ���ϴ� ��? 3
   
 3*1=3
 ...
 3*9=27
  
  ���(y/n)? y
    
  ���ϴ� ��? 5
    
 5*1=15
 ...
 5*9=45
  
  ���(y/n)? n
    
 -- END --
 */

/*
2. GugudanTest.java
    ==> main()����
    ==> �ݺ����� ���� (while �Ǵ� do~while��)
    ==> �ݺ��� ������ GugudanŬ�������� �޼ҵ���� ������ ȣ��.
 */

public class GugudanTest {
	public static void main(String[] args) throws IOException {
		int dan;
		Gugudan gugudan = new Gugudan();

		while(true) {
			dan = gugudan.inputDan();
			gugudan.outputDan(dan);
			if(gugudan.continueDan().contentEquals("n")) break;
		}
		System.out.println(" -- END --");
	}
}