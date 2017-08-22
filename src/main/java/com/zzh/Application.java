package com.zzh;


import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;


public class Application {
    static public void main(String args[]) throws Exception {
        System.out.println("ggg");
//
        HttpHost target = new HttpHost("httpbin.org", 80, "http");
//        CredentialsProvider credsProvider = new BasicCredentialsProvider();
//        credsProvider.setCredentials(
//                new AuthScope(target.getHostName(), target.getPort()),
//                new UsernamePasswordCredentials("user", "passwd"));
//        CloseableHttpClient httpclient = HttpClients.custom()
//                .setDefaultCredentialsProvider(credsProvider).build();
//        try {
//
//            // Create AuthCache instance
//            AuthCache authCache = new BasicAuthCache();
//            // Generate BASIC scheme object and add it to the local
//            // auth cache
//            BasicScheme basicAuth = new BasicScheme();
//            authCache.put(target, basicAuth);
//
//            // Add AuthCache to the execution context
//            HttpClientContext localContext = HttpClientContext.create();
//            localContext.setAuthCache(authCache);
//
//            HttpGet httpget = new HttpGet("http://httpbin.org/hidden-basic-auth/user/passwd");
//
//            System.out.println("Executing request " + httpget.getRequestLine() + " to target " + target);
//            for (int i = 0; i < 3; i++) {
//                CloseableHttpResponse response = httpclient.execute(target, httpget, localContext);
//                try {
//                    System.out.println("----------------------------------------");
//                    System.out.println(response.getStatusLine());
//                    System.out.println(EntityUtils.toString(response.getEntity()));
//                } finally {
//                    response.close();
//                }
//            }
//        } finally {
//            httpclient.close();
//        }


        CloseableHttpClient httpclient = HttpClients.createDefault();

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("param1", "value1"));
        formparams.add(new BasicNameValuePair("param2", "value2"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://baidu.com");
        httppost.setEntity(entity);

        CloseableHttpResponse response = httpclient.execute(httppost);

        // 获取所有的http头信息
        response.getAllHeaders();

        try {
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } finally {
            response.close();
        }


    }


//    public static String getStringFromInputStream(InputStream is)
//            throws IOException {
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        // 模板代码 必须熟练
//        byte[] buffer = new byte[1024];
//        Integer len;
//        while ((len = is.read(buffer)) != -1) {
//            os.write(buffer, 0, len);
//        }
//        is.close();
//        String state = os.toString();// 把流中的数据转换成字符串,采用的编码是utf-8(模拟器默认编码)
//        os.close();
//        return state;
//    }

}
