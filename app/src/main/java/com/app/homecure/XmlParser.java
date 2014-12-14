package com.app.homecure;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by gublu on 14/12/14.
 */
public class XmlParser {

    public static ArrayList<String> getTitlesFromXml(Activity activity)
            throws XmlPullParserException, IOException {
        ArrayList<String> titles = new ArrayList<String>();
        Resources res = activity.getResources();
        XmlResourceParser xpp = res.getXml(R.xml.natural);
        xpp.next();
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
                eventType = xpp.next();
                if (eventType == XmlPullParser.TEXT) {
                    titles.add(xpp.getText());
                }
            }
            eventType = xpp.next();
        }
        return titles;

    }


    public static String getContentFromXML(Activity activity, String title)
            throws XmlPullParserException, IOException {

        String content="dug";
        Resources res = activity.getResources();
        XmlResourceParser xpp = res.getXml(R.xml.natural);
        xpp.next();
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if ( eventType == XmlPullParser.TEXT && xpp.getText().equals(title)) {
                eventType = xpp.next();
                eventType = xpp.next();
                eventType = xpp.next();
                eventType = xpp.next();
                eventType = xpp.next();
                eventType = xpp.next();
                eventType = xpp.next();
                eventType = xpp.next();
                eventType = xpp.next();
                content= xpp.getText();
                //eventType = xpp.next();

            }
            eventType = xpp.next();
        }
        return content;

    }
}
