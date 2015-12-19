package com.datacollector.controller;

import com.datacollector.com.datacollector.db.ModelPersistor;
import com.datacollector.model.Country;
import com.datacollector.model.Model;
import com.datacollector.service.HttpService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjay on 19/12/15.
 */
public class CountryController  implements Controller{
    public void prettyDisplay(List<Model> models) {
        int maxSize=0;
        for(Model model:models){
            //System.out.println(model.toString());

            if(((Country)model).getName().length()>maxSize){
                maxSize=((Country)model).getName().length();
            }
        }
        String formatString="%1$5s %2$-"+maxSize+"s %3$5s %4$-5s";
        System.out.println(String.format(formatString,"Code","Country Name","Year","ccTLD"));
        for(Model model:models){
            System.out.println(model.toString(formatString));

            if(((Country)model).getName().length()>maxSize){
                maxSize=((Country)model).getName().length();
            }
        }
    }

    public List<Model> getModels(HttpService service,URL url) throws IOException {
       List<Model> countries= new ArrayList<Model>();
        Document page= service.getHttpPage(url);
        //get table
        String[] identifiers={"Code","Country","ccTLD","Year"};
        Element table=service.getElement(page,"table",identifiers);
        //get table rows
        Elements tableRows=table.getElementsByTag("tr");
        for(Element row:tableRows){
            //get columns
            Elements columns=row.getElementsByTag("td");
            Country country=new Country();
            if(columns.size()>=4){
                country.setCode(columns.get(0).text());
                country.setName(columns.get(1).text());
                country.setYear(Short.parseShort(columns.get(2).text()));
                country.setCcTLD(columns.get(3).text());
                countries.add(country);
            }

        }
        return countries;
    }

    public void save(List<Model> models, ModelPersistor modelPersistor) {
        for(Model model:models){
            modelPersistor.insert(model);
        }
        System.out.println("All data saved...");
    }

    public List<Model> readAll(ModelPersistor modelPersistor) {

        return modelPersistor.selectAll();
    }
}
