package com.sangguigu.test;

import com.sangguigu.test.bean.Pet;
import com.sangguigu.test.bean.User;
import com.sangguigu.test.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        // 1、返回我们的IOC 容器
        ConfigurableApplicationContext run = SpringApplication.run(TestApplication.class, args);
        // 2、查看容器中的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        // 从容器中获取组件  组件默认是单实例的
//        run.getBean
        User user01 = run.getBean("user01", User.class);
        User user02 = run.getBean("user01", User.class);
        System.out.println(user01.toString() + user01.equals(user02));
//        获取到的本身就是代理对象,
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);
//        如果@Configuration(proxyBeanMethods = true)代理对象调用方法  Springboot总会检查这个组件是否在容器中有
//        保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>."+ user.equals(user1));

        User user03 = run.getBean("user01", User.class);
        Pet bean1 = run.getBean(Pet.class);
        boolean equals = user03.getPet().equals(bean1);

        System.out.println(equals+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

    }

}
