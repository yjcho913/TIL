package com.scsa.JAVA20191101;

public class StringTest {//���ڿ�StringŬ������ ��� ���캸��
   public static void main(String[] args) {
	
		//String ���ڿ� : ���ڵ��� ����!!
		String str = "JavaProgramming";
		//�ε��� 	  012345678901234
		
		//���ڿ� ����(���� ����)
		System.out.println("str ���ڿ� ���� >>> "+ str.length());
		
		//�κй��ڿ� ----> "Pro"���ڿ� ���
		//str.substring(beginIndex, endIndex);
		//beginIndex(����)	/	endIndex(������)
		System.out.println("str.substring(4, 7) >>> "+ str.substring(4, 7));
		
		//�κй��ڿ� ----> "Programming"���ڿ� ���
		//str.substring(beginIndex); : �����ε��� ~ ���ε��� 
		System.out.println("str.substring(4) >>> "+ str.substring(4));

		//Ư���ε����� ���� ������: char str.charAt(int index)
		System.out.println("str.charAt(4) >>> "+ str.charAt(4));

		//Ư�������� �ε��� ������: int str.indexOf(int ch)
		System.out.println("str.indexOf('P') >>> "+ str.indexOf('P'));

		//str���� �κ� ���ڿ� "Programming"�� ���Ͻÿ�.(indexOf()���)
		System.out.println("str.substring(str.indexOf('P')) >>> "+ str.substring(str.indexOf('P')));

		//ù��° 'a'������ �ε����� ���Ͻÿ�
		System.out.println("str.indexOf('a') >>> "+ str.indexOf('a'));

		//����° 'a'������ �ε����� ���Ͻÿ�
		System.out.println("str.indexOf(\"am\") >>> "+ str.indexOf("am"));

		//������ 'a'������ �ε����� ���Ͻÿ� (lastIndexOf()�޼ҵ�: �ڿ��� ���� ���� �˻�)
		System.out.println("str.lastIndexOf('a') >>> "+ str.lastIndexOf('a'));

		//���ڿ� ġȯ(��ü) 'a' ---> 'o'
		//replace�� str�� ������������ ����! ����� ���빰�� ��ȯ�ϴ� �� ��
		System.out.println("str.replace('a', 'o') >>> "+ str.replace('a', 'o'));
		System.out.println("str >>> "+ str);

		//"JavaProgramming " ---> "�ڹ�Programming"���� �����Ͻÿ�.(replace()�޼ҵ���)
		System.out.println(str.replace("JAVA", "�ڹ�"));
		System.out.println("str >>> "+ str);
		
		//���ڿ��� ���� �߰�!! str�տ� ����2�� , �ڿ� ����2�� �߰�
		str = "  " + str + "  ";
		System.out.println("str >>> "+ str);
		System.out.println("str ���ڿ� ���� >>> " + str.length());
		
		//���� ����!!(���ڿ� �յ� ���ӵ� ��������)
		//trim�� str�� ������������ ����! ����� ���빰�� ��ȯ�ϴ� �� ��
		str = str.trim();
		System.out.println("str >>> " + str);
		System.out.println("str ���ڿ� ���� >>> " + str.length());
	}
}
