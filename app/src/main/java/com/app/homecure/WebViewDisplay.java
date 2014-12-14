package com.app.homecure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class WebViewDisplay extends Activity {

    private WebView webView;
    String htmlcontent="lulu";
    String title;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        Intent intent = getIntent();
        title = intent.getStringExtra("title");


        final String mimeType = "text/html";
        final String encoding = "UTF-8";
      try {
            htmlcontent = XmlParser.getContentFromXML(this, title);

        } catch (XmlPullParserException e) {
            htmlcontent = "XmlPullParserException";
        } catch (IOException e) {
            htmlcontent = "IOException";
        }
      catch (Exception e) {
          htmlcontent = e.getMessage();
      }

        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL("", htmlcontent, mimeType, encoding, "");


    }

}