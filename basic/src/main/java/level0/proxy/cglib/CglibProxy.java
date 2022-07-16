package level0.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CglibProxy<T> implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib before");
        //methodProxy.invokeSuper(o, objects);
        System.out.println("invokeSuper: " + o.getClass().getSimpleName());
        System.out.println("Superclass: " + o.getClass().getSuperclass().getSimpleName());
        System.out.println("cglib after");
        return null;
    }

    public static <T> T getProxy(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CglibProxy<T>());

        return (T) enhancer.create();
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SchoolBus.class);
        enhancer.setCallback(new CglibProxy());

        SchoolBus car = (SchoolBus) enhancer.create();
        car.name();
        System.out.println("----------");

        SchoolBus proxy = getProxy(SchoolBus.class);
        proxy.name();

        /*//
        //car = (SchoolBus) enhancer.create();
        Enhancer enhancer2 = new Enhancer();
        enhancer2.setSuperclass(SchoolBus.class);
        enhancer2.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "fixed value ";
            }
        });
        SchoolBus car2 = (SchoolBus) enhancer2.create();
        car2.name();
        //System.out.println(car2.hashCode());
        System.out.println("----------");

        final SchoolBus car3 = new SchoolBus();
        Enhancer enhancer3 = new Enhancer();
        enhancer3.setSuperclass(SchoolBus.class);
        enhancer3.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("cglib callBack InvocationHandler before");
                Object invoke = method.invoke(car3, objects);
                if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class){
                    invoke = ((String)invoke).toUpperCase();
                }
                System.out.println("cglib callBack InvocationHandler after: " + invoke);
                return invoke;

            }
        });
        SchoolBus car33 = (SchoolBus)enhancer3.create();
        car33.getName();

        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("value",String.class);
        Object myBean = beanGenerator.create();
        // 自动生成setter，getter方法。
        Method setter = myBean.getClass().getMethod("setValue",String.class);
        setter.invoke(myBean,"Hello cglib");

        Method getter = myBean.getClass().getMethod("getValue");
        System.out.println(getter.invoke(myBean));
        System.out.println(myBean);

        Car name = new Car("name", "555");
        BeanMap beanMap = BeanMap.create(name);

        System.out.println(beanMap);
        System.out.println(beanMap.get("name"));*/
    }
}
