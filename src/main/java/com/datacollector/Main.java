package com.datacollector;

import com.datacollector.controller.Controller;
import com.datacollector.controller.CountryController;
import com.datacollector.db.CountryPersistor;
import com.datacollector.db.ModelPersistor;
import com.datacollector.model.Model;
import com.datacollector.service.CountryHttpService;
import com.datacollector.service.HttpService;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by sanjay on 19/12/15.
 */
public class Main {
    public static void main(String args[]) throws IOException {
        Controller controller = new CountryController();
        HttpService httpService = new CountryHttpService();
        List<Model> models=controller.getModels(httpService,new URL("https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2"));
        controller.prettyDisplay(models);
        ModelPersistor modelPersistor=new CountryPersistor();
        controller.save(models,modelPersistor);
        System.out.println("Saved....");
        System.out.println("Retrieving...");
        controller.prettyDisplay(controller.readAll(modelPersistor));
        System.out.println("Exiting...");

    }
}
