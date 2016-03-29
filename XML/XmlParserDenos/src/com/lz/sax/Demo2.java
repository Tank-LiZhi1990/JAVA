package com.lz.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Demo2 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		// 创建解析工厂
		SAXParserFactory sax = SAXParserFactory.newInstance();

		// 得到解析器
		SAXParser saxparser = sax.newSAXParser();

		// 得到读取器
		XMLReader reader = saxparser.getXMLReader();

		// 设置内容处理器,先于读取文件内容
		BeanListHandler handler = new BeanListHandler();
		reader.setContentHandler(handler);

		// 读取xml文档内容
		reader.parse("src/book.xml");

		List<Book> list = handler.getList();
		System.out.println(list);
	}
	
	@Test
	public void test(){
		
	}
}

// 返回booklist
class BeanListHandler extends DefaultHandler {

	private List<Book> list = new ArrayList<Book>();
	private String currentTag;

	private Book book;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		currentTag = qName;
		if ("book".equals(currentTag)) {
			book = new Book();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		if ("name".equals(currentTag)) {
			book.setName(new String(ch, start, length));
		}
		if ("author".equals(currentTag)) {
			book.setAuthor(new String(ch, start, length));
		}
		if ("price".equals(currentTag)) {
			book.setPrice(new String(ch, start, length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if ("book".equals(qName)) {
			list.add(book);
			book = null;
		}
		currentTag = null;
	}

	public List<Book> getList() {
		return list;
	}
}