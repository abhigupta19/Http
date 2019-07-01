package com.sar.user.http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Data {
    public static String downurl(String address) throws Exception {
        InputStream inputStream=null;
        URL url=new URL(address);
        HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        int response=httpURLConnection.getResponseCode();
        if (response!=200)
        {
                throw new Exception("Error in input"+response);

        }
        inputStream=httpURLConnection.getInputStream();
        return read(inputStream);

    }

    private static String read(InputStream inputStream) throws IOException {
        byte[] buffer=new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        BufferedOutputStream outputStream=null;
        int length=0;
        outputStream=new BufferedOutputStream(byteArrayOutputStream);
        while ((length=inputStream.read(buffer))>0)
        {
            outputStream.write(buffer,0,length);
        }
        outputStream.flush();
        if (outputStream!=null)
        {
              outputStream.close();
        }
        return byteArrayOutputStream.toString();

    }

}
