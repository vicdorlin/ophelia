package com.vic.ophelia.test;

import net.glxn.qrgen.core.AbstractQRCode;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import java.io.*;

/**
 * @author vicdor
 * @create 2018-05-29 11:38
 */
public class TestQRCode {
    public static void main(String[] args) {
        AbstractQRCode qrCode = QRCode.from("http://www.baidu.com");
        // 设置字符集，支持中文
        qrCode.withCharset("utf-8");
        // 设置生成的二维码图片大小
        qrCode.withSize(720,720);
        ByteArrayOutputStream out = qrCode.to(ImageType.PNG).stream();
        File file = new File("D:\\qrCode.png");
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(file);
            fout.write(out.toByteArray());
            fout.flush();
            System.out.println("***********二维码生成成功！**********");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fout.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
