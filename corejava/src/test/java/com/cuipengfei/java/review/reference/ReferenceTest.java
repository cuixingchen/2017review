package com.cuipengfei.java.review.reference;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by cuipengfei1 on 2018/7/13.
 */
public class ReferenceTest {

    private ReferenceService referenceService;

    @Before
    public void before(){
        referenceService = new ReferenceService();
    }

    @Test
    public void serviceTest(){
        referenceService.service();
    }
    @Test
    public void softServiceTest(){
        referenceService.softService();
    }
    @Test
    public void weakServiceTest(){
        referenceService.weakService();
    }
    @Test
    public void phantomServiceTest() throws InterruptedException {
        referenceService.phantomService();
    }

}
