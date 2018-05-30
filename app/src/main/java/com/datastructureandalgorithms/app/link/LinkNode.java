package com.datastructureandalgorithms.app.link;

/**
 * Created by lixiang on 2018/5/30.
 */
public class LinkNode {
    public String data;
    public LinkNode next;

    public LinkNode(String data, LinkNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
