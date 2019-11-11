package com.scsa.JAVA20191108;


class GrandParent{}

class Parent extends GrandParent{}
class Child extends Parent{}


public class InstanceofTest {
/*
<instanceof ������>
 - ���������� �����ϴ� �ν��Ͻ��� Ÿ���� �˻�
 - ���������� Ư�� Ŭ������ ��ü������ �Ǻ��� �ִ� ������
  ����)  �������� instanceof ��ü Ÿ��
       ===> ����� boolean  	
 */
	
   public static void main(String[] args) {
	   
	   Parent p = new Parent();
	   Child  c = new Child();
	   
	   Parent p2 = new Child();
	   
	   GrandParent gp = new GrandParent();
	   
	   System.out.println("## �ڱ�Ŭ���� ���� ##");
	   System.out.println( c instanceof Child );
	   System.out.println( p instanceof Parent );
	   
	   System.out.println("\n## �ڽ��� �θ�(����)���� ##");
	   System.out.println( c instanceof Parent );
	   System.out.println( c instanceof GrandParent );
	   
	   System.out.println("\n## �θ� �ڽ����� ##");
	   System.out.println( p instanceof Child );
	   
	   System.out.println("\n## �ڽ�Ŭ���� �������� �θ� �ڽ����� ##");
	   System.out.println( p2 instanceof Child );
	   
	   
	   
   }
}
