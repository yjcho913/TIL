package com.scsa.JAVA20191108;


class GrandParent{}

class Parent extends GrandParent{}
class Child extends Parent{}


public class InstanceofTest {
/*
<instanceof 연산자>
 - 참조변수가 참조하는 인스턴스의 타입을 검사
 - 참조변수가 특정 클래스의 객체인지를 판별해 주는 연산자
  형식)  참조변수 instanceof 객체 타입
       ===> 결과값 boolean  	
 */
	
   public static void main(String[] args) {
	   
	   Parent p = new Parent();
	   Child  c = new Child();
	   
	   Parent p2 = new Child();
	   
	   GrandParent gp = new GrandParent();
	   
	   System.out.println("## 자기클래스 참조 ##");
	   System.out.println( c instanceof Child );
	   System.out.println( p instanceof Parent );
	   
	   System.out.println("\n## 자식이 부모(선조)참조 ##");
	   System.out.println( c instanceof Parent );
	   System.out.println( c instanceof GrandParent );
	   
	   System.out.println("\n## 부모가 자식참조 ##");
	   System.out.println( p instanceof Child );
	   
	   System.out.println("\n## 자식클래스 정보갖는 부모가 자식참조 ##");
	   System.out.println( p2 instanceof Child );
	   
	   
	   
   }
}
