package com.tortilla.Service;

/**
 * Created with IntelliJ IDEA.
 * User: uttam
 * Date: 9/1/15
 * Time: 12:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class Track {
    String title;
    String singer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Track [title=" + title + ", singer=" + singer + "]";
    }
}
