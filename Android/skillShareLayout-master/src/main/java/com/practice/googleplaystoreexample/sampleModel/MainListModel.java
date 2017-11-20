package com.practice.googleplaystoreexample.sampleModel;

import java.util.ArrayList;

/**
 * Created by JisangYou on 2017-11-18.
 */

public class MainListModel {


    private String headerTitle;
    private ArrayList<SingleItemModel> allItemsInList;


    public MainListModel() {

    }

    public MainListModel(String headerTitle, ArrayList<SingleItemModel> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInList = allItemsInSection;
    }


    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModel> getAllItemsInList() {
        return allItemsInList;
    }

    public void setAllItemsInList(ArrayList<SingleItemModel> allItemsInList) {
        this.allItemsInList = allItemsInList;
    }
}
