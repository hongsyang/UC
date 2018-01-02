package com.xzt.uc.DS;

/**
 * Created by dell on 2017/12/20.
 */


public class Node<T>
{
    private T data;
    private Node next;
    private Node pre;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
