package com.pblgllgs.client.models;
/*
 *
 * @author pblgl
 * Created on 29-01-2024
 *
 */

public class Message {

    private String text;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
