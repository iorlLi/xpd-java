package level0.proxy.dyncproxy;

import level0.proxy.BizService;

import java.lang.reflect.*;

public class DynProxyHandler implements InvocationHandler {

    private Object target;

    public DynProxyHandler() {
    }

    public DynProxyHandler(Object object) {
        this.target = object;
    }

    /*
        proxy: 当前代理对象
        method: 代理的方法，即代理对象执行的方法。

     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dyn proxy start");
        System.out.println("proxy method is " + method.getName());
        Object invoke = method.invoke(target, args);
        return "dyn proxy return " + invoke;
    }

    public Object getInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        final BizService userService = new UserBizService();
        BizService userProxy = (BizService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), new DynProxyHandler(userService));
        String process = userProxy.process();
        System.out.println(process);


        System.out.println("------------");

        Class<?> proxyClass = Proxy.getProxyClass(BizService.class.getClassLoader(), BizService.class);
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        BizService userProxy2 = (BizService) constructor.newInstance(new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before");
                Object invoke = method.invoke(userService, args);
                System.out.print("after ");
                return invoke;
            }
        });
        System.out.println(userProxy2.process());

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
        BizService userProxy3 = (BizService) new DynProxyHandler().getInstance(userService);
        System.out.println(userProxy3.process());
        BizService product = new ProductBizService();
        BizService productService = (BizService) new DynProxyHandler().getInstance(product);
        System.out.println(productService.process());

    }

}
