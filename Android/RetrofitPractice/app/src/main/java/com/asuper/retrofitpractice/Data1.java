package com.asuper.retrofitpractice;

/**
 * Created by super on 2017-12-01.
 */

public class Data1
{
    private String _id;
    private String content;
    private String author;
    private String videoURl;
    private String videoDuration;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVideoURl() {
        return videoURl;
    }

    public void setVideoURl(String videoURl) {
        this.videoURl = videoURl;
    }

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration;
    }

    @Override
    public String toString() {
        return "Data1{" +
                "_id='" + _id + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", videoURl='" + videoURl + '\'' +
                ", videoDuration='" + videoDuration + '\'' +
                '}';
    }
}
