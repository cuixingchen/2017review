package com.cuipengfei.java.review.collection.list;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by cuipengfei on 17-7-19.
 */
public class ArrayListTest {

    private static final Logger logger = LoggerFactory.getLogger(ArrayListTest.class);

    @Test
    public void listIteratorTest() {
        List<Integer> list = new ArrayList<>();
//        list = Arrays.asList(1, 2, 3, 4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        ListIterator<Integer> iter = list.listIterator();
        int i=0;
        while (iter.hasNext()){
            iter.add(5);
            logger.info(list.toString());
            i++;
            if(i>10) break;
        }

    }
}
