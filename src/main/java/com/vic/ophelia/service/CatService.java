package com.vic.ophelia.service;

import com.vic.ophelia.domain.Cat;
import com.vic.ophelia.exception.GlobalException;
import com.vic.ophelia.mapper.CatMapper;
import com.vic.ophelia.repo.CatRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

import static com.vic.ophelia.enums.EGlobalCode.GLOBAL_LITTLE_TIP;

/**
 * @author vicdor
 * @create 2018-02-05 16:31
 */
@Service
public class CatService {

    /**
     * spring-boot-jpa
     * hibernate方式
     */
    @Resource
    private CatRepository catRepository;
    /**
     * mybatis-spring-boot-starter
     * mybatis方式
     */
    @Resource
    private CatMapper catMapper;

    @Transactional
    public void insertTwo() {
        Cat cat1 = new Cat();
        cat1.setName("猫A");
        cat1.setAge(3);
        catRepository.save(cat1);

        Cat cat2 = new Cat();
        cat2.setName("猫BBB");
        cat2.setAge(5);
        catRepository.save(cat2);
    }

    public Cat save(Cat cat) {
        if (cat.getAge() <= 20) {
            throw new GlobalException(GLOBAL_LITTLE_TIP);
        }
        return catRepository.save(cat);
    }

    public List<Cat> findByName(String name){
        return catRepository.findByName(name);
    }

    public Cat findOne(Integer id) {
        return catRepository.findOne(id);
    }

    public List<Cat> cats() {
        return catMapper.getCats();
    }
}
