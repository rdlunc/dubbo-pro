package com.product.utils.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class Test {

    public static void main(String[] args){
        // TODO Auto-generated method stub
        StringBuffer html = new StringBuffer();
        HttpClient httpclient = new HttpClient();
        //创建GET方法实例
        GetMethod getMethod = new GetMethod("http://kegui.jptonghang.com/dm/Prescribe/guiding.html");
//        GetMethod getMethod = new GetMethod("http://www.chuanboyi.com/category-6-b0-min0-max0-attr0-1-sell_number-DESC.html");
        //使用系统提供的默认恢复策略
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        try{
            //执行GET方法
            int statusCode = httpclient.executeMethod(getMethod);
            if(statusCode != HttpStatus.SC_OK){
                System.out.println("Method is wrong " + getMethod.getStatusLine());
            }
            InputStream responseBody = getMethod.getResponseBodyAsStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseBody,"gb2312"));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(responseBody,"utf-8"));
            String line = reader.readLine();
            while(line != null){
                html.append(line).append("\n");
                line = reader.readLine();
            }
            reader.close();
            System.out.println(html);
            //正则表达式
            String regex = "<form name=\"compareForm\"[\\s\\S]+>[\\s\\S]+</form>.*<script.*>";
            String regexa ="(?<=<li>)[\\s\\S]+?(?=</li>)";
            String regexb = "(?:(?:\\<(?:Style)(?:\\s+(?:[\\w-]+)(?:=(?:[^\\s\\>\\<]*|\\\"[\\s\\S]*?\\\"|\\'[\\s\\S]*?\\'))?)*\\s" +
                    "*(?:/)?\\>)(?:[\\s\\S]*?)(?:\\</(?:Style)\\>))|(?:(?:\\<(?:script)(?:\\s+(?:[\\w-]+)(?:=(?:[^\\s\\>\\<]*|\\\"" +
                    "[\\s\\S]*?\\\"|\\'[\\s\\S]*?\\'))?)*\\s*(?:/)?\\>)(?:[\\s\\S]*?)(?:\\</(?:script)\\>))|(?:\\<!(?:[\\w-]+)" +
                    "(?:\\s+(?:[\\w-]+|\\\"[\\s\\S]*?\\\"|\\'[\\s\\S]*?\\'))*\\s*\\>)|(?:\\<!--[\\s\\S]*?--\\>)|(?:\\<(?:[\\w-]+)" +
                    "(?:\\s+(?:[\\w-]+)(?:=(?:[^\\s\\>\\<]*|\\\"[\\s\\S]*?\\\"|\\'[\\s\\S]*?\\'))?)*\\s*(?:/)?\\>)|(?:\\</(?:[\\w-]+)\\>)" +
                    "|(?:\\<!\\[CDATA\\[(?:[\\s\\S]*?)\\]\\]\\>)|(?:(?:(?<blank>[ ]+)|[^ \\<\\>])+)";
            Pattern pattern = Pattern.compile(regexb);
            Matcher m = pattern.matcher(html);
            StringBuffer str = new StringBuffer();
            int i = 0;
            while(m.find()){
                str.append(m.group());
            }
            pattern = Pattern.compile(regexa);
            m = pattern.matcher(str);
            while(m.find()){
                attrs(m.group());
                i++;
            }
            System.out.println("共有"+i+"条数据！");
            System.out.println(str);
        }catch (HttpException e) {
            // TODO: handle exception
            System.out.println("Please check your provided http address!");
            e.printStackTrace();
        }catch (IOException e) {
            // TODO: handle exception
            System.out.println("the line is wrong!");
            e.printStackTrace();
        }finally{
            getMethod.releaseConnection();//释放链接
        }
    }
    public static void attrs(String str){

        //获取url的正则表达式
        String regexURL = "[a-z]+-[0-9]+\\.html";
        //获取Name的正则表达式
        String regexName = "(?<=title=\")[[\\w-\\s][^x00-xff]]+(?=\")";
        //获取图片的正则表达式
        String regexPicture = "images.*\\.jpg";

        Pattern patternURL = Pattern.compile(regexURL);
        Pattern patternName = Pattern.compile(regexName);
        Pattern patternPicture = Pattern.compile(regexPicture);
        Matcher mURL = patternURL.matcher(str);
        Matcher mName = patternName.matcher(str);
        Matcher mPicture = patternPicture.matcher(str);
        if(mName.find()){
            System.out.println("名字:"+mName.group());
        }
        if(mURL.find()){
            System.out.println("链接:"+mURL.group());
        }
        if(mPicture.find()){
            System.out.println("图片:"+mPicture.group());
        }
    }

}