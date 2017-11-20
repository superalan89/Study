package com.practice.googleplaystoreexample.sampleModel;

/**
 * Created by JisangYou on 2017-11-18.
 */

public class SingleItemModel {


    private String serviceName;
    private String see;
    private String contentName;
    private String contentAuthor;




    public SingleItemModel() {
    }


    public SingleItemModel(String serviceName, String see, String contentName, String contentAuthor) {
        this.serviceName = serviceName;
        this.see = see;
        this.contentName = contentName;
        this.contentAuthor = contentAuthor;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSee() {
        return see;
    }

    public void setSee(String see) {
        this.see = see;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentAuthor() {
        return contentAuthor;
    }

    public void setContentAuthor(String contentAuthor) {
        this.contentAuthor = contentAuthor;
    }
}
