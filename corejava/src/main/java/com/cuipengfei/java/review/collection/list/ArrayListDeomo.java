package com.cuipengfei.java.review.collection.list;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by cuipengfei on 17-7-19.
 */
public class ArrayListDeomo<T> {

    public void listIterator(List<T> list,T t) {
        if (list != null) {
            throw new NullPointerException("list为空");
        }
        ListIterator<T> iter = list.listIterator();
        iter.add(t);
    }
}
