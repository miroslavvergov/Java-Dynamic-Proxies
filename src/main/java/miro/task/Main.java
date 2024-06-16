package miro.task;

import miro.task.interceptor.cglib.UserServiceCglibInterceptor;
import miro.task.interceptor.jdk.UserServiceJdkInterceptor;
import miro.task.model.User;
import miro.task.service.UserService;
import miro.task.service.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        proxyJdkExample();

        proxyCglibExample();
    }

    private static void proxyCglibExample() {
        UserService target = new UserServiceImpl();
        MethodInterceptor interceptor = new UserServiceCglibInterceptor(target);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(interceptor);

        User user = new User();
        user.setName("JanessaTech2022");
        UserService proxy = (UserService) enhancer.create();
        proxy.addUser(user);
    }

    private static void proxyJdkExample() {
        UserService target = new UserServiceImpl(); // The real object
        InvocationHandler interceptor = new UserServiceJdkInterceptor(target);
        UserService proxy = (UserService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), interceptor);

        User user = new User();
        user.setName("JanessaTech2022");
        proxy.addUser(user);
    }
}

