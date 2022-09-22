package com.web.xmlparse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class JaxpSax {
    public static void main(String[] args) throws Exception{
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse("web1/src/com/test/xmlparse/person.xml", new MyHandler());
        System.out.println("*************");
        saxParser.parse("web1/src/com/test/xmlparse/person.xml", new MyHandler2());
        System.out.println("*************");
        saxParser.parse("web1/src/com/test/xmlparse/person.xml", new MyHandler3());
    }


}

//实现输出第一个name元素的值
class MyHandler3 extends DefaultHandler{
    boolean flag = false;
    int idx = 1;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        super.startElement(uri, localName, qName, attributes);
        if ("name".equals(qName) && idx == 1){
            flag = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        super.characters(ch, start, length);
        if (flag == true){
            System.out.println(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        super.endElement(uri, localName, qName);
        if ("name".equals(qName)){
            flag = false;
            idx++;
        }
    }
}

//实现输出所有的name元素的值
class MyHandler2 extends DefaultHandler{
    boolean flag = false;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        super.startElement(uri, localName, qName, attributes);
        if ("name".equals(qName)){
            flag = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        super.characters(ch, start, length);
        if (flag == true){
            System.out.println(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        super.endElement(uri, localName, qName);
        if ("name".equals(qName)){
            flag = false;
        }
    }
}


//实现输出所有标签的类
class MyHandler extends DefaultHandler{
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        super.startElement(uri, localName, qName, attributes);
        System.out.print("<"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        super.characters(ch, start, length);
        System.out.print(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        super.endElement(uri, localName, qName);
        System.out.print("</"+qName+">");
    }
}