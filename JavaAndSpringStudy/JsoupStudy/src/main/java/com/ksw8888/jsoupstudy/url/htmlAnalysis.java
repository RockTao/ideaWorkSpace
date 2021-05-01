package com.ksw8888.jsoupstudy.url;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class htmlAnalysis {
    public static void main(String[] args) {
        getNextUrl ("abc");
    }



    /**
     * 通过htmlunit来获得一些搜狗的网址。
     * 通过模拟鼠标点击事件来实现
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String getNextUrl(String key) {
        String page = new String();
        try {
            WebClient webClient = new WebClient();
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            //去拿网页
            HtmlPage htmlPage = webClient.getPage("http://pic.sogou.com/");
            //得到表单
            HtmlForm form = htmlPage.getFormByName("searchForm");
            //得到提交按钮
            HtmlSubmitInput button = form.getInputByValue("搜狗搜索");
            //得到输入框
            HtmlTextInput textField = form.getInputByName("query");
            //输入内容
            textField.setValueAttribute(key);
            //点一下按钮
            HtmlPage nextPage = button.click();
            String str = nextPage.toString();
//            page = cutString(str);
            webClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;


    }

}
