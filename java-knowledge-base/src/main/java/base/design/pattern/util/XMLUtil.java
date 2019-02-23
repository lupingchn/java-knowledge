package base.design.pattern.util;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;
import java.net.URL;

public class XMLUtil {
    /**
     * 该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
     */
    public static Object getBean(String beanName) {
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            URL resource = XMLUtil.class.getClassLoader().getResource("");
            File file = new File(resource.getFile());
            doc = builder.parse(new File(file.getPath() + "//config.xml"));

            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("bean");
            for(int index = 0 ; index < nl.getLength() ;index++){
                Node node = nl.item(index);
                if(node.getAttributes().getNamedItem("beanName") != null
                        && node.getAttributes().getNamedItem("beanName").getNodeValue().equals(beanName)
                        && node.getAttributes().getNamedItem("beanClass") != null){
                    //通过类名生成实例对象并将其返回
                    Class c = Class.forName(node.getAttributes().getNamedItem("beanClass").getNodeValue());
                    Object obj = c.newInstance();
                    return obj;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args){
        XMLUtil.getBean("");
    }
}