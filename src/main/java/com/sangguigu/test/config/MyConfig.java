package com.sangguigu.test.config;

import com.sangguigu.test.bean.Pet;
import com.sangguigu.test.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qjh
 * 1、配置类里面使用@Bean 标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods : 代理Bean的方法
 * Full   @Configuration(proxyBeanMethods = true)
 * lite   @Configuration(proxyBeanMethods = false)
 * 组件依赖
 */
@Configuration(proxyBeanMethods = false)// 等同于配置文件
public class MyConfig {
    /**
     * 外部无论调用配置类中的这个组件注册方法多少次获取的都是之前注册容器中的单实例对象
     * 给容器中添加组件，以方法名为组件Id.返回类型就是组件类型， 返回的值就是组件在容器中的实例
     * @return
     */
    @Bean
    public User user01() {
        User zhangsan2 = new User("zhangsan2", 18);
//        proxyBeanMethods = true   User 组件依赖了Pet 组件
        zhangsan2.setPet(tomcatPet());
        return zhangsan2;
    }

    @Bean
    public Pet tomcatPet() {
        return new Pet("xiaoxiao tomcat");
    }

}
