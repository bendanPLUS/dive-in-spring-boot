package com.imooc.diveinspringboot.bootstrap;

import com.imooc.diveinspringboot.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 仓储的引导类
 *
 * @author 小马哥
 * @since 2018/5/14
 */
//扫描指定的包 把该包里面有@Component注解的 注入到容器里 形成bean
@ComponentScan(basePackages = "com.imooc.diveinspringboot.repository")
public class RepositoryBootstrap {

//    这样就可以使用   myFirRepository 了
//    @Autowired
//    MyFirstLevelRepository myFirRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // myFirstLevelRepository Bean 是否存在
        MyFirstLevelRepository myFirstLevelRepository =
                context.getBean("myFirstLevelRepository",MyFirstLevelRepository.class);

        System.out.println("myFirstLevelRepository Bean : "+myFirstLevelRepository);

        // 关闭上下文
        context.close();
    }
}
