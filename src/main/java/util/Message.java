/**
 * Created by Xiaozhong on 2020/8/16.
 * Copyright (c) 2020/8/16 Xiaozhong. All rights reserved.
 */
package util;

public class Message {
    private Object informer;
    private String title = "";
    private String content;
    private MessageLevel level = MessageLevel.INFORMATION;

    public Message() {
    }

    public Message(Object informer, String content) {
        this.informer = informer;
        this.content = content;
    }

    public Message(Object informer, String title, String content) {
        this.title = title;
        this.informer = informer;
        this.content = content;
    }

    public Message(Object informer, String title, String content, MessageLevel level) {
        this.title = title;
        this.content = content;
        this.level = level;
        this.informer = informer;
    }

    public Object getInformer() {
        return informer;
    }

    public void setInformer(Object informer) {
        this.informer = informer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageLevel getLevel() {
        return level;
    }

    public void setLevel(MessageLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return level == MessageLevel.TERMINAL ? informer + content : informer + " " + level.toString() + " : [" + title + ": " + content + "]";
    }
}
