package com.vic.ophelia.service;

import com.vic.ophelia.domain.Cat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author vicdor
 * @create 2018-02-07 16:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CatServiceTest {
    @Autowired
    private CatService catService;

    @Test
    public void findOne() {
        Cat cat = catService.findOne(18);
        Assert.assertEquals(Integer.valueOf(19), cat.getAge());
    }

    @Test
    public void cats(){
        List<Cat> cats = catService.cats();
        System.out.println("===  === " + cats);
    }
}