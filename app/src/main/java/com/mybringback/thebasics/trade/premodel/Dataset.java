package com.mybringback.thebasics.trade.premodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALLO on 18.07.2016.
 */
public class Dataset {
    private int id;
    private String dataset_code;
    private String database_code;

    private List<List<String>> data = new ArrayList<List<String>>();

    public List<List<String>> getData() {
        return data;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataset_code() {
        return dataset_code;
    }

    public void setDataset_code(String dataset_code) {
        this.dataset_code = dataset_code;
    }

    public String getDatabase_code() {
        return database_code;
    }

    public void setDatabase_code(String database_code) {
        this.database_code = database_code;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "id=" + id +
                ", dataset_code='" + dataset_code + '\'' +
                ", database_code='" + database_code + '\'' +
                ", data=" + data +
                '}';
    }
}
