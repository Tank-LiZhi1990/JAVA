package com.lz.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Demo1 {
	@Test
	public void read() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("book").get(1);

		String value = book.element("name").getText();
		System.out.println(value);
	}

	@Test
	public void readAttr() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("book").get(1);

		String value = book.element("name").attributeValue("id");
		System.out.println(value);
	}

	@Test
	public void add() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = root.element("book");

		book.addElement("date").setText("2001年01月01日");

		// 方式一， 乱码问题。字节流
		// 不管xml什么格式，document读入到内存是默认utf-8，fileWriter默认是gb2312
		// 字符流，默认gb2312 XMLWriter xmlWriter = new XMLWriter(new
		// FileWriter("src/book.xml");
		// 创建outputStreamWriter作为writer
		// XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(new
		// FileOutputStream("src/book.xml"), "utf-8"));

		// 方式二.格式化输出器
		OutputFormat format = OutputFormat.createPrettyPrint();// .compact 紧凑的
		// 根据文档来
		format.setEncoding("utf-8");

		// 字节流,writer查码表，format跟文件编码一样就不会有问题，用字符流FileWriter，writer不会查码表，
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/book.xml"), format);
		xmlWriter.write(document);// utf-8
		xmlWriter.close();
	}

	@Test
	public void add1() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element book = document.getRootElement().element("book");

		List<Element> list = book.elements();// [,,]

		Element date = DocumentHelper.createElement("Date");
		date.setText("2001年01月01日");

		list.add(2, date);
	}

	@Test
	public void delete() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element price = document.getRootElement().element("book").element("price");
		price.getParent().remove(price);

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");

		XMLWriter xmlwriter = new XMLWriter(new FileOutputStream("src/book.xml"), format);
		xmlwriter.write(document);
		xmlwriter.close();
	}
	
	@Test
	public void update() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element price = document.getRootElement().element("book").element("price");
		price.getParent().remove(price);

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");

		XMLWriter xmlwriter = new XMLWriter(new FileOutputStream("src/book.xml"), format);
		xmlwriter.write(document);
		xmlwriter.close();
	}
}
