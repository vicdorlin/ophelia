package com.vic.ophelia.repo;

import com.vic.ophelia.domain.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author vicdor
 * @create 2018-02-05 15:42
 * Integer:id的类型
 */
public interface CatRepository extends JpaRepository<Cat, Integer> {

    /**
     * 根据年龄查询（方法名应遵守格式规范）
     *
     * @param age
     * @return
     */
    List<Cat> findByAge(Integer age);

    List<Cat> findByName(String name);
}
