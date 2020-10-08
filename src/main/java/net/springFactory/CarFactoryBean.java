package net.springFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

public class CarFactoryBean implements FactoryBean<Car>, ApplicationContextAware {

    private String carInfo;
    private static ApplicationContext applicationContext;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.valueOf(infos[1]));
        car.setPrice(Double.valueOf(infos[2]));
        return car;
    }

    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getCarInfo() {
        return this.carInfo;
    }

    // 接受逗号分割符设置属性信息
    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    public static void main(String[] args) throws Exception {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext.xml"});// 正常情况
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car.getBrand());
        System.out.println(car.getMaxSpeed());
        System.out.println(car.getPrice());

        // 获取CarFactoryBean的实例
        CarFactoryBean carFactoryBean = (CarFactoryBean) applicationContext.getBean("&car");
        System.out.println(carFactoryBean.getCarInfo());
        System.out.println(carFactoryBean.getObject());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}