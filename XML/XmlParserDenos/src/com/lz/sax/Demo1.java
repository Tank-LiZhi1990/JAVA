package com.lz.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Demo1 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		// 创建解析工厂
		SAXParserFactory sax = SAXParserFactory.newInstance();
		// 得到解析器
		SAXParser saxparser = sax.newSAXParser();
		// 得到读取器
		XMLReader reader = saxparser.getXMLReader();
		// 设置内容处理器
		reader.setContentHandler(new TagValueHanlder());
		// 读取xml文档内容
		reader.parse("src/book.xml");
	}

}

class TagValueHanlder extends DefaultHandler {

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.print("<" + qName + ">");
		if (attributes.getLength() > 0) {
			for (int i = 0; attributes != null && i < attributes.getLength(); i++) {
				System.out.print(attributes.getValue(i));
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("<" + qName + ">");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		System.out.print(new String(ch, start, length));
	}

}