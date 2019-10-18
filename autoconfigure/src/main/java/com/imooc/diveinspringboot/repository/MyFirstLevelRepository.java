package com.imooc.diveinspringboot.repository;

import com.imooc.diveinspringboot.annotation.FirstLevelRepository;
import com.imooc.diveinspringboot.annotation.SecondLevelRepository;
import org.springframework.stereotype.Component;

/**
 * 我的 {@link FirstLevelRepository}
 *
 * @author 小马哥
 * @since 2018/5/14
 */
//@SecondLevelRepository里面包含 @Component注解 当有扫描该类的时候 会把该类注册为bean
@SecondLevelRepository(value = "myFirstLevelRepository") // Bean 名称
public class MyFirstLevelRepository {

}
