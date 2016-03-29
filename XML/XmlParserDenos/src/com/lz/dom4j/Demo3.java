package com.lz.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Demo3 {
	public static void main(String[] args) {
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read("src/users.xml");

			String username = "113";
			String password = "12345";

			String xpathSystax = "//user[@username='" + username + "' and @password='" + password + "']";
			Node node = document.selectSingleNode(xpathSystax);
			if (node != null) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
