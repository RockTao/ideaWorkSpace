package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.parseHtml;
import com.example.demo.service.SpiderService;
import com.example.demo.util.JsoupUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping(value = "/spilder")
public class SpiderController {

    @Autowired
    private SpiderService spiderService;

    @RequestMapping("/csdn")
    public  String getUrl(){
        return "csdnSP";
    }
    @ResponseBody
    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public parseHtml findById(@RequestParam(value = "id", required = true)Integer id){
        return spiderService.findById(id);
    }
    //接受为接送格式的数据
//    通过@RequestBody 接收json
//    直接通过@RequestBody 的方式，直接将json的数据注入到了JSONObject里面了。
    @ResponseBody
    @RequestMapping(value = "/JsonFindById1",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String JsonFindById(@RequestBody JSONObject jsonParam){
        System.out.println(jsonParam.toJSONString());
        return jsonParam.toString();
    }

    /**
     * 功能描述:通过HttpServletRequest 的方式来获取到json的数据<br/>
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/JsonFindById2", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getByRequest(HttpServletRequest request) {

        //获取到JSONObject
        JSONObject jsonParam = this.getJSONParam(request);

        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "request");
        result.put("data", jsonParam);

        return result.toJSONString();
    }

    /**
     * 功能描述:通过request来获取到json数据<br/>
     * @param request
     * @return
     */
    public JSONObject getJSONParam(HttpServletRequest request){
        JSONObject jsonParam = null;
        try {
            // 获取输入流
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            // 写入数据到Stringbuilder
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = streamReader.readLine()) != null) {
                sb.append(line);
            }
            jsonParam = JSONObject.parseObject(sb.toString());
            // 直接将json信息打印出来
            System.out.println(jsonParam.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonParam;
    }

    @ResponseBody
    @RequestMapping(value = "/readFromUrl", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public  String  readFromUrl(@RequestBody JSONObject jsonParam){
        String url = jsonParam.getString("url");
        String splitRegex = jsonParam.getString("regex");
       List<parseHtml> list = JsoupUtil.regexHtml(url,  splitRegex);
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "json");
        result.put("data", list);

        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/getChildUrl",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public  String  getChildUrl(@RequestBody JSONObject jsonParam){
        JSONObject result = new JSONObject();
        List<parseHtml> list = spiderService.getAllUrl(jsonParam.getString("url") ,jsonParam.getString("regex"));
        result.put("msg", "ok");
        result.put("method", "json");
        result.put("data", list);
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/getChildUrlOne",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public  String  getChildUrlOne(@RequestBody JSONObject jsonParam){
        JSONObject result = new JSONObject();
        Integer list = spiderService.insertOne(jsonParam.getString("url") ,jsonParam.getString("regex"));
        result.put("msg", "ok");
        result.put("method", "json");
        result.put("data", list);
        return result.toJSONString();
    }


    @ResponseBody
    @RequestMapping(value = "/updateById",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Integer updateById(@RequestBody parseHtml parse){

        return spiderService.updateById(parse);
    }
    @ResponseBody
    @RequestMapping(value = "/deleteById",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Integer deleteById(@RequestBody parseHtml parse){
    return  spiderService.deleteById(parse);
    }
}
