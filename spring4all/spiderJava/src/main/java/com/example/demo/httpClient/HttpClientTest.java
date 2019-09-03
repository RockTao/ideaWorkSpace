package com.example.demo.httpClient;

import org.apache.http.HttpEntity;
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

public class HttpClientTest {

    public static void main(String[] args) {
        //1.生成httpclient，相当于该打开一个浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        for(int i= 1 ;i < 30;i++) {

            //2.创建get请求，相当于在浏览器地址栏输入 网址
            String url = "https://blog.csdn.net/fly_hps/article/list/"+ i+"?t=1&";
                 System.out.println("--------------------" +i + "------------" + url);
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
                    Elements postItems = document.getElementsByClass("article-item-box");

                    for (Element postItem : postItems) {
//                    System.out.println(postItem);
                        String title = postItem.select("a").first().text();
                        String link = postItem.select("a").first().attr("href");
                        System.out.println("title = " + title + "  href = " + link);
                    }

//                System.out.println(postItems);
                } else {
                    //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
//                    System.out.println("返回状态不是200");
//                    System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }
//            finally {
//                //6.关闭
//                HttpClientUtils.closeQuietly(response);
//                HttpClientUtils.closeQuietly(httpClient);
//            }
        }
    }
}