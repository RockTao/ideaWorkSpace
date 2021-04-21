package com.example.demo.util;

import com.example.demo.entity.parseHtml;
import org.apache.http.*;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JsoupUtil {

    public static List<parseHtml> regexHtml(String url, String splitRegex) {


        //1.生成httpclient，相当于该打开一个浏览器
        List list = new ArrayList();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        HttpGet request = new HttpGet(url);
        try {
            //3.执行get请求，相当于在输入地址栏后敲回车键
            response = httpClient.execute(request);

            //4.判断响应状态为200，进行处理
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.获取响应内容
                HttpEntity httpEntity = response.getEntity();
                String html = EntityUtils.toString(httpEntity, "utf-8");
                Document document = Jsoup.parse(html);
                Elements postItems = document.getElementsByClass(splitRegex);

                for (Element postItem : postItems) {
                    parseHtml parse = new parseHtml();
//                    System.out.println(postItem);
                    String title = postItem.select("a").first().text();
                    String link = postItem.select("a").first().attr("href");
                    parse.setUrl(link.replaceAll("\\s*", ""));
                    parse.setTitle(title.replaceAll("\\s*", ""));

                    parse.setResource(urlUtil.getUrlTopDomain(url));
                    parse.setCategory("java");
                    System.out.println("title = " + title + "  href = " + link);
                    list.add(parse);
                }
                return list;
//                System.out.println(postItems);
            } else {
                //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
//                    System.out.println("返回状态不是200");
//                    System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
                return list;
            }
        } catch (Exception e) {
//                e.printStackTrace();
            return list;
        }

    }
}
