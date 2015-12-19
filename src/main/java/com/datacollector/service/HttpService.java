package com.datacollector.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

/**
 * Created by sanjay on 19/12/15.
 */
public interface HttpService {

    public Document getHttpPage(URL url) throws IOException;
    public Element getElement(Document doc, String tag, String[] identifier);


}
