package com.polixis.tests;

import com.polixis.util.ILogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;

public class BaseTest {
    public static final String URL = "http://localhost:9876/";

    protected String getElementsFromHTML() throws IOException {
        ILogger.info("Getting elements from html");
        Document document = Jsoup.connect(URL).get();
        String html = document.toString();
        int index = html.indexOf("elements:");
        int index2 = html.indexOf(",\n" + "levelWidth", index);
        StringBuilder subStringed = new StringBuilder(html.substring(index + "elements:".length(), index2));
        return subStringed.toString();
    }

    protected int getCountOfEdgesWithoutRelationTitle(String elements) {
        ILogger.info("Getting count of edges without relation title");
        int count = 0;
        try {
            JSONArray jsonArray = new JSONArray(elements);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.toString().contains("target") && !jsonObject.toString().contains("title")) {
                    count++;
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        ILogger.info("There are " + count + " edges without relation title");
        return count;
    }

    protected int getCountOfNodesWithoutAvatar(String elements) {
        ILogger.info("Getting count of nodes without avatar");
        int count = 0;
        try {
            JSONArray jsonArray = new JSONArray(elements);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.toString().contains("nodeAvatar") && !jsonObject.toString().contains("avatar")) {
                    count++;
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        ILogger.info("There are " + count + " nodes without avatar");
        return count;
    }
}
