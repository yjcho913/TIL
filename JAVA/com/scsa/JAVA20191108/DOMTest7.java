package com.scsa.JAVA20191108;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/*
<ROOT></ROOT>
----------------------------------
<ROOT>
   <A>
      <C>Hello</C>
   </A>
</ROOT>  
----------------------------------
<ROOT>
   <A>
       <C>Hello</C>
   </A>
   <B>GoodBye</B>
</ROOT>  
----------------------------------
 <ROOT>
      <A><C>Hello</C></A> 
      <D>GoodDay</D>   
      <B>GoodBye</B>
  </ROOT>
----------------------------------
  <ROOT>
      <A><C>Hello</C></A> 
      <D>GoodDay</D> 
  </ROOT>
----------------------------------
  <ROOT>
      <A><C>Hello</C></A> 
      <E></E>
  </ROOT>
----------------------------------
  <ROOT>
      <A><C>Hello</C></A> 
      <E></E>
      <A></A>
  </ROOT>	
*/

public class DOMTest7 {

	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	
	Document doc;
	FileOutputStream out;	//메모리 ---> 파일
	
	public DOMTest7() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			out = new FileOutputStream("src/com/scsa/JAVA20191108/root.xml");
			
			doc = builder.newDocument();
			

			//Node 객체를 통한 문서 조작 (CRUD)

			//노드 생성
			//doc.createElement(String tagName)
			Element root = doc.createElement("ROOT");
			Element a = doc.createElement("A");
			Element c = doc.createElement("C");
			Element b = doc.createElement("B");
			Element d = doc.createElement("D");
			Element e = doc.createElement("E");
			//doc.createTextNode(String data);
			Text hello = doc.createTextNode("Hello");
			Text goodBye = doc.createTextNode("GoodBye");
			Text goodDay = doc.createTextNode("GoodDay");
			
			
			/*
		 	<ROOT></ROOT>
			 */
			//노드 추가
			//부모노드.appendChild(자식노드);
			doc.appendChild(root);
			
			
			/*
				<ROOT>
				   <A>
				      <C>Hello</C>
				   </A>
				</ROOT>
			*/
			root.appendChild(a);
			a.appendChild(c);
			c.appendChild(hello);
			
			
			/*
				<ROOT>
				   <A>
				       <C>Hello</C>
				   </A>
				   <B>GoodBye</B>
				</ROOT>  
			*/
			//appendChild의 순서가 바뀌어도 무관
			b.appendChild(goodBye);
			root.appendChild(b);
			
			
			/*
				 <ROOT>
				      <A><C>Hello</C></A> 
				      <D>GoodDay</D>   
				      <B>GoodBye</B>
				  </ROOT>
			*/
			d.appendChild(goodDay);
			//노드 추가(끼워넣기)
			//root.insertBefore(Node newChild, Node refChild)
			root.insertBefore(d, b);
			
			
			/*
				  <ROOT>
				      <A><C>Hello</C></A> 
				      <D>GoodDay</D> 
				  </ROOT>
			*/
			//노드 삭제
			//부모노드.removeChild(Node 삭제할 자식노드)
			//부모를 모르면 자식을 지우지 못 함
			root.removeChild(b);
			//만약 부모 노드를 모를 때, 특정 노드를 삭제하고 싶은 경우
			//b.getParentNode().removeChild(b);
			
			
			/*
				  <ROOT>
				      <A><C>Hello</C></A> 
				      <E></E>
				  </ROOT>
			*/
			//노드 변경(대체)
			//부모노드.replaceChild(Node newChild, oldChild);
			root.replaceChild(e, d);
			
			
			/*
				  <ROOT>
				      <A><C>Hello</C></A> 
				      <E></E>
				      <A></A>
				  </ROOT>	
			*/
			//노드 복제
			//복제할노드.cloneNode(boolean deep)
			//deep : 자식 노드까지 복사할지 여부
			Node a2 = a.cloneNode(false);
			root.appendChild(a2);	//복제 안하고 붙이면, A 노드가 그냥 이동
			
			
			documentRecur(doc);
			System.out.println("memory ---> 파일 출력 성공!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void documentRecur(Node n) throws IOException {
		String outString;
		
		switch(n.getNodeType()) {
			case Node.ELEMENT_NODE:
				String tagName = n.getNodeName();
				outString = "<" + tagName;
				
				// 속성 구하기
				NamedNodeMap nmap = n.getAttributes();
				for (int i = 0; i < nmap.getLength(); i++) {
					Node attr = nmap.item(i);
					outString = outString.concat(" " + attr.getNodeName() + "='" + attr.getNodeValue() + "'");
				}
				outString = outString.concat(">");
				out.write(outString.getBytes());
				
				NodeList nlst = n.getChildNodes();
				for (int i = 0; i < nlst.getLength(); i++) {
					documentRecur(nlst.item(i));
				}
				outString = "</" + tagName + ">";
				out.write(outString.getBytes());
				break;
			case Node.TEXT_NODE:
				out.write(n.getNodeValue().getBytes());
				break;
			case Node.COMMENT_NODE:
				outString = "<!-- " + n.getNodeValue() + " -->";
				out.write(outString.getBytes());
				break;
			case Node.DOCUMENT_NODE:
				outString = "<?xml version='1.0' encoding='euc-kr'?>\r\n";
				out.write(outString.getBytes());
				NodeList nlst2 = n.getChildNodes();
				for (int i = 0; i < nlst2.getLength(); i++) {
					documentRecur(nlst2.item(i));
				}
				break;
		}
	}//documentRecurr
	
	public static void main(String[] args) {
		new DOMTest7();
	}
}