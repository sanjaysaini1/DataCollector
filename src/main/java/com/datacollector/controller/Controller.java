package com.datacollector.controller;

/**
 * Created by sanjay on 19/12/15.
 */

import com.datacollector.com.datacollector.db.ModelPersistor;
import com.datacollector.service.HttpService;
import com.datacollector.model.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface Controller {
    void prettyDisplay(List<Model> model);

    List<Model> getModels(HttpService client,URL url) throws IOException;

    void save(List<Model> models, ModelPersistor modelPersistor);

    List<Model> readAll(ModelPersistor modelPersistor);
}
