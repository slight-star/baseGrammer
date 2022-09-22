package com.web.xmlparse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Dom4jTest {
    public static void main(String[] args) throws Exception {
//        selectName();
        selectNameFirst();
    }

    //获取到第一个name元素里的值
    public static void selectNameFirst() throws Exception{
        /**
         * 1.创建解析器
         * 2.得到document
         *
         * 3.得到根节点
         * 4.得到第一个p1元素
         * 5.得到第一个name元素
         * 6.得到第一个name元素里的值
         */
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("web1/src/com/test/xmlparse/person.xml");

        Element rootElement = document.getRootElement();
        Element p1 = rootElement.element("p1");
        Element name = p1.element("name");
        System.out.println(name.getText());
    }

    //查询所有name元素的值
    public static void selectName() throws Exception{
        /**
         * 1.创建sax解析器
         * 2.解析xml,得到document
         * 3.得到根节点
         *
         * 4.得到p1
         * 5.得到p1下面的name
         * 6.得到name里面的值
         */
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("web1/src/com/test/xmlparse/person.xml");
        Element rootElement = document.getRootElement();

        List<Element> p1_list = rootElement.elements("p1");
        for (Element element : p1_list) {
            Element name1 = element.element("name");
            String text = name1.getText();
            System.out.println(text);
        }
    }
}
