package com.example.demo.util;


import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.*;

/**
 * 对url进行正则匹配，提取出当前网站
 */
public class urlUtil {
    public static String getIP(String url) {
        //使用正则表达式过滤，
        String re = "((http|ftp|https)://)(([a-zA-Z0-9._-]+)|([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}))(([a-zA-Z]{2,6})|(:[0-9]{1,4})?)";
        String str = "";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(re);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        //若url==http://127.0.0.1:9040或www.baidu.com的，正则表达式表示匹配
        if (matcher.matches()) {
            str = url;
        } else {
            String[] split2 = url.split(re);
            if (split2.length > 1) {
                String substring = url.substring(0, url.length() - split2[1].length());
                str = substring;
            } else {
                str = split2[0];
            }
        }
        return str;
    }

    @Test
    public void testGetIp() {
        System.out.println(getIP("www.baidu.com"));
    }

    public static String getTopDomain(String url) {
        try {
            //获取值转换为小写
            String host = new URL(url).getHost().toLowerCase();//news.hexun.com
            Pattern pattern = Pattern.compile("[^\\.]+(\\.com\\.cn|\\.net\\.cn|\\.org\\.cn|\\.gov\\.cn|\\.com|\\.net|\\.cn|\\.org|\\.cc|\\.me|\\.tel|\\.mobi|\\.asia|\\.biz|\\.info|\\.name|\\.tv|\\.hk|\\.公司|\\.中国|\\.网络)");
            Matcher matcher = pattern.matcher(host);
            while (matcher.find()) {
                return matcher.group();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testGetTopDomain() {
//        System.out.println(getTopDomain("https://blog.csdn.net/fly_hps/article/list/2?t=1&"));
        System.out.println(getTopDomain("https://www.cnblogs.com/junhong1995/p/7801959.html"));
    }

    public static String getUrlTopDomain(String url) {
        URL urls = null;
        try {
            urls = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String host = urls.getHost();// 获取主机名
        return host;// 结果 blog.csdn.net
    }

    @Test
    public void testGetUrl() {
        System.out.println(getUrlTopDomain("https://www.cnblogs.com/junhong1995/p/7801959.html"));
    }
}
