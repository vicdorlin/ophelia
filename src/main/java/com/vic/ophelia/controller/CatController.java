package com.vic.ophelia.controller;

import com.vic.ophelia.domain.Cat;
import com.vic.ophelia.domain.ResultVo;
import com.vic.ophelia.repo.CatRepository;
import com.vic.ophelia.service.CatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author vicdor
 * @create 2018-02-05 15:39
 */
@RestController
@RequestMapping("cat")
@Slf4j
public class CatController {

    @Resource
    private CatRepository catRepository;
    @Resource
    private CatService catService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("cats")
    public List<Cat> cats() {
        return catRepository.findAll();
    }

    /*@PostMapping("cats")
    public Cat addCat(@RequestParam("age") Integer age,
                      @RequestParam("name") String catName) {
        Cat cat = new Cat();
        cat.setAge(age);
        cat.setName(catName);
        return catRepository.save(cat);
    }*/

    /**
     * 新增
     *
     * @param cat
     * @return
     */
    @PostMapping("cats")
    public ResultVo addCat(@Valid Cat cat, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultVo.fail(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultVo.ok(catService.save(cat));
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Cat getById(@PathVariable("id") Integer id) {
        return catService.findOne(id);
    }

    /**
     * 更新
     *
     * @param id
     * @return
     */
    @PutMapping("cat/{id}")
    public Cat updateById(@PathVariable("id") Integer id,
                          Cat cat
                          /*@RequestParam("age") Integer age,
                          @RequestParam("name") String catName*/) {
        cat.setId(id);
        return catRepository.save(cat);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("cat/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        catRepository.delete(id);
    }

    /**
     * 根据年龄查询
     *
     * @param age
     */
    @GetMapping("age/{age}")
    public List<Cat> getByAge(@PathVariable("age") Integer age) {
        return catRepository.findByAge(age);
    }

    @PostMapping("cats/two")
    public void catsTwo() {
        catService.insertTwo();
    }

    /**
     * TODO 修改局部字段，避免查詢
     * @param id
     * @param age
     * @return
     */
    /*@PatchMapping("mod/{id}")
    public Cat modAge(@PathVariable("id") Integer id,
                      @RequestParam("age") Integer age){
        Cat cat = new Cat();
        cat.setAge(age);
        cat.setId(id);
        return catRepository.sa
    }*/
}
