package com.datacollector.db;

import com.datacollector.model.Model;

import java.util.List;

/**
 * Created by sanjay on 19/12/15.
 */
public interface ModelPersistor {
    boolean insert(Model model);
    boolean update(Model model);
    boolean delete(Model model);
    Model select(String code);
    List<Model> selectAll();
}
