package com.imooc.diveinspringboot.bootstrap;

import com.imooc.diveinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 系统属性条件引导类
 *
 * @author 小马哥
 * @since 2018/5/15
 */
public class ConditionalOnSystemPropertyBootstrap {
	//每个人的电脑user.name对应的value名称都不相同 需要自己去debug出自己的user.name
	@Bean
	@ConditionalOnSystemProperty(name = "user.name", value = "moriu")
	public String helloWorld() {
		return "Hello,World 小马哥";
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);
		// 通过名称和类型获取 helloWorld Bean
		String helloWorld = context.getBean("helloWorld", String.class);

		System.out.println("helloWorld Bean : " + helloWorld);

		// 关闭上下文
		context.close();
	}
}
