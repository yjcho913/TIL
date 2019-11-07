package com.scsa.JAVA20191107;


import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// ***** �̼� ***** //
// books.xml --- DOM�Ľ� ---> books2.xml ���Ϸ� ���
// ������ ������ ���������� ���(����)

public class DOMTest3 {
	// ����
	DocumentBuilderFactory factory;
	// �ϲ�
	DocumentBuilder builder;
	Document doc;
	FileOutputStream out;

	public DOMTest3() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//=================== DOM ���α׷��� ���� ===================//
			doc = builder.parse("src/com/scsa/JAVA20191107/books.xml");
			
			out= new FileOutputStream("src/com/scsa/JAVA20191107/books2.xml");
			
			// Document - ��ġ, ��
			documentRecur(doc);
			
			System.out.println("good");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(out!=null) out.close();
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
				
				// �Ӽ� ���ϱ�
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
		new DOMTest3();
	}
}