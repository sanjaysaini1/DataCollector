package com.datacollector.service;

import org.apache.http.client.HttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

/**
 * Created by sanjay on 19/12/15.
 */
public class CountryHttpService implements HttpService {

    public Document getHttpPage(URL url) throws IOException {
        return  Jsoup.connect(url.toString()).get();
    }

    public Element getElement(Document doc, String tag, String[] identifiers) {
        //get all table by tag

        Elements tables=doc.getElementsByTag(tag);

        // check if the element has country,code , year ,cctld and iso 3166-2 in the table header as identifiers
        for(Element table:tables){
                String tableText=table.text();
            boolean check=true;
            for(String identifier:identifiers){
               if(!tableText.contains(identifier))   {
                   check=false;
                   break;
               }

            }
            if(check) {
                return table;
            }

        }
        return null;
    }

}
