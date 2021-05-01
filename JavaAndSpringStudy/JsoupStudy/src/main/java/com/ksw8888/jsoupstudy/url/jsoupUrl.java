package com.ksw8888.jsoupstudy.url;

import com.ksw8888.jsoupstudy.util.FileCreateUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;



public class jsoupUrl {
    private static String path = "D:/";

    @Test
    public void testUrl() throws Exception {
//        Document doc = Jsoup.connect("http://www.ksw8888.com/gudaicn/gudaibingshu/").get();
        Document doc = Jsoup.connect("http://www.ksw8888.com/gudaicn/mengxuejingdian/").get();
//        #right >div>ul>li
        Elements links = doc.select("div#right div ul li");
        for (Element src : links) {
            Element link = src.select("a").first();//查找第一个a元素
            String linkHref = link.attr("abs:href");
            System.out.println(linkHref +" " + src.text());
            FileCreateUtil.creatTxtFile( src.text());

            Document secondDdoc = Jsoup.connect(linkHref).get();
            boolean txtFile = FileCreateUtil.creatTxtFile("");
//        System.out.println(txtFile);
            Elements secondLinks = secondDdoc.select(".mululist a");
            for (Element src1 : secondLinks) {
                Element link1 = src1.select("a").first();//查找第一个a元素
                String linkHref2 = link1.attr("abs:href");
//            System.out.println(src.text());
                Document threeDoc = Jsoup.connect(linkHref2).get();
                Elements threeElement = threeDoc.select("div#content p");
                for(Element three : threeElement){
                    Element thrrLink = three.select("p").first();
                    System.out.println(thrrLink.html());
                    FileCreateUtil.writeTxtFile(path+src.text()+".txt",thrrLink.html());

                }
            }



        }
    }
    @Test
    public void testSecondUrl()throws Exception {
        String url ="http://www.ksw8888.com/renwensheke/wangyangmingxinxue/";
        Document secondDdoc = Jsoup.connect(url).get();
        String str ="王阳明心学";
        boolean txtFile = FileCreateUtil.creatTxtFile(str);
//        System.out.println(txtFile);
        Elements secondLinks = secondDdoc.select(".mululist a");
        for (Element src : secondLinks) {
            Element link = src.select("a").first();//查找第一个a元素
            String linkHref = link.attr("abs:href");
//            System.out.println(src.text());
            Document threeDoc = Jsoup.connect(linkHref).get();
            Elements threeElement = threeDoc.select("div#content p");
            for(Element three : threeElement){
                Element thrrLink = three.select("p").first();
                System.out.println(thrrLink.html());
                FileCreateUtil.writeTxtFile(path+str+".txt",thrrLink.html());

            }
        }
    }

    @Test
    public void testThreeUrl() throws  Exception{
        Document threeDoc = Jsoup.connect("http://www.ksw8888.com/gudaicn/gudaibingshu/guiguzibenjingyinfuqi/355948.html").get();
        Elements threeElement = threeDoc.select("div#content p");
        for(Element three : threeElement){
            Element thrrLink = three.select("p").first();
            System.out.println(thrrLink.html());

        }


    }


}
