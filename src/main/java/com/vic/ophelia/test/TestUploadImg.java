package com.vic.ophelia.test;

import net.glxn.qrgen.core.AbstractQRCode;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author vicdor
 * @create 2018-05-29 11:50
 */
public class TestUploadImg {
    private static final String DefaultUserAgent = "GuangCPS ApiSdk Client v1.0";

    public static void main(String[] args) {
//        String url = "http://101.37.173.182:20410/external/common/pic/upload";
//        String url = "http://192.168.4.105:20410/external/common/pic/upload";
        String url = "http://www.aiyoumi.com:20410/external/common/pic/upload";
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;

        AbstractQRCode qrCode = QRCode.from("http://www.baidu.com");
        // 设置字符集，支持中文
        qrCode.withCharset("utf-8");
        // 设置生成的二维码图片大小
        qrCode.withSize(720, 720);
        ByteArrayOutputStream out = qrCode.to(ImageType.PNG).stream();
        try {
            httpClient = HttpClients.createDefault();

            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000).setConnectionRequestTimeout(1000)
                    .setSocketTimeout(155000).build();

            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            httpPost.addHeader("User-Agent", DefaultUserAgent);

//            File file = new File("D:\\qrCode1.png");
//            FileBody bin = new FileBody();
//            FileBody bin = new FileBody(new File("C:\\Users\\vicdor\\Desktop\\timg (3).jpg"));
            ByteArrayBody bin = new ByteArrayBody(out.toByteArray(), System.currentTimeMillis() + ".png");
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("Filedata", bin).build();
            httpPost.setEntity(reqEntity);
            response = httpClient.execute(httpPost);
            HttpEntity resEntity = response.getEntity();
            System.out.println(EntityUtils.toString(resEntity, Charset.forName("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
