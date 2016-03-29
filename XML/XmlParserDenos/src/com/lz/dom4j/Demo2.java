package com.lz.dom4j;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Demo2 {

	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");

		String value = document.selectSingleNode("//author").getText();
		System.out.println(value);
		
		List list = document.selectNodes("//author");
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(((Node)it.next()).getText());
		}
	}
}
