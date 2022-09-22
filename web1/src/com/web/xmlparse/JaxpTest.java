package com.web.xmlparse;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class JaxpTest {
    public static void main(String[] args) throws Exception, ParserConfigurationException, IOException, SAXException, TransformerException {
//        selectAll();
//        selectSingle();
//        addSex();
//        modifySex();
//        delSex();
        listElement();
    }

    public static void listElement() throws Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("web1/src/com/test/xmlparse/person.xml");

        list1(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult("web1/src/com/test/xmlparse/person.xml"));
    }

    private static void list1(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE){
            System.out.println(node.getNodeName());
        }
        //得到一层节点
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            //得到每一个节点
            Node node1 = childNodes.item(i);
            //得到每一个节点的子节点
            list1(node1);
        }
    }

    public static void delSex() throws Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("web1/src/com/test/xmlparse/person.xml");

        NodeList sex = document.getElementsByTagName("sex");
        Node sex1 = sex.item(0);
        Node p1 = sex1.getParentNode();
        p1.removeChild(sex1);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult("web1/src/com/test/xmlparse/person.xml"));

    }

    public static void modifySex() throws Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("web1/src/com/test/xmlparse/person.xml");

        NodeList sex = document.getElementsByTagName("sex");
        sex.item(0).setTextContent("男");

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult("web1/src/com/test/xmlparse/person.xml"));
    }

    public static void addSex() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        /**
         * 1.创建解析器工厂实例
         * 2.根据解析器工厂实例创建解析器实例
         * 3.解析器实例解析xml
         *
         * 4.得到所有的p1标签
         * 5.使用item方法下标获取第一个p1标签
         * 6.创建sex标签
         * 7.创建文本标签
         * 8.将文本添加到sex下
         * 9.将sex添加到第一个p1下
         *
         * 10.回写xml
         *      -创建TransformerFactory实例
         *      -根据TransformerFactory实例创建Transform实例
         *      -Transform实例调用transform方法，参数（new DOMSource(document),new StreamResault("xml文件路径")
         */
        //1.创建解析器工厂实例
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //2.根据解析器工厂，创建解析器实例
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //3.解析xml
        Document document = documentBuilder.parse("web1/src/com/test/xmlparse/person.xml");
        //4.得到所有p1标签
        NodeList p1List = document.getElementsByTagName("p1");
        //5.得到第一个p1标签
        Node p1 = p1List.item(0);
        //6.创建sex标签
        Element sex1 = document.createElement("sex");
        //7.创建文本标签
        Text text1 = document.createTextNode("女");
        //8.将文本标签添加到sex下
        sex1.appendChild(text1);
        //9.将sex添加到第一个p1下
        p1.appendChild(sex1);
        //10.回写xml
        //  -创建transformerFactory实例
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        //  -使用transformerFactory实例创建transformer实例
        Transformer transformer = transformerFactory.newTransformer();
        //  -Transform实例调用transform方法 回写xml
        transformer.transform(new DOMSource(document), new StreamResult("web1/src/com/test/xmlparse/person.xml"));
    }

    public static void selectSingle() throws ParserConfigurationException, IOException, SAXException {
        /**
         * 1.创建解析器工厂
         * 2.根据解析器工厂，创建解析器
         * 3.解析xml,返回document
         * 4.得到所有的name元素
         * 5.返回集合，使用item方法，根据下标获取元素
         */
        //1.
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //2.
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //3.
        Document document = builder.parse("web1/src/com/test/xmlparse/person.xml");
        //4.
        NodeList nameList = document.getElementsByTagName("name");
        //5.
        String textContent = nameList.item(1).getTextContent();
        System.out.println(textContent);

    }

    public static void selectAll() throws ParserConfigurationException, SAXException, IOException {
        /**
         * 1.创建解析器工厂
         * 2.根据解析器工厂创建解析器
         * 3.解析xml返回document
         * 4.得到所有的name元素
         * 5.返回集合，遍历集合，得到每一个name元素
         */
        //1.创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //2.创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //3.解析xml返回document
        Document document = builder.parse("web1/src/com/test/xmlparse/person.xml");
//        Document document = builder.parse("person.xml");
        //4.得到所有的name元素
        NodeList nameList = document.getElementsByTagName("name");
        //5.遍历集合，得到每一个name元素
        for (int i = 0; i < nameList.getLength(); i++) {
            Node name = nameList.item(i);
            String s = name.getTextContent();
            System.out.println(s);
        }
    }
}
