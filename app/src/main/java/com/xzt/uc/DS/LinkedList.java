package com.xzt.uc.DS;

/**
 * Created by dell on 2017/12/20.
 */

public class LinkedList<T>
{
   public Node<T> head;
    private int size;

    public LinkedList()
    {
        this.size = 0;
        head = new Node<T>();
        head.setNext(null);
        head.setPre(null);
    }
    //在position后面插入点
    public boolean insert(T data,int position)
    {
        Node<T> node = new Node<T>();
        node.setData(data);
        Node<T> p = head;
        for(int i = 0 ; i < position ; i++)
        {
            p = p.getNext();
        }
        if(size == position)
        {
            node.setNext(null);
            node.setPre(p);
            p.setNext(node);
            size++;
        }else{
            node.setPre(p);
            p.getNext().setPre(node);
            node.setNext(p.getNext());
            p.setNext(node);
            size++;
        }

        return true;
    }

    //得到position上面的Node
    public Node getNode(int position)
    {
        Node<T> p = head;
        for(int i = 0 ; i < position ; i++)
        {
            p = p.getNext();
        }
        return p;
    }

    public int getSize() {
        return size;
    }

}
