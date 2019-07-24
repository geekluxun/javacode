package typeinfo;
//: typeinfo/SimpleDynamicProxy.java

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    // 该方法负责集中处理动态代理类上的所有方法调用。第一个参数既是代理类实例，第二个参数是被调用的方法对象
    // 第三个方法是调用参数。调用处理器根据这三个参数进行预处理或分派到委托类实例上发射执行
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);

        if (args != null)
            for (Object arg : args)
                System.out.println("  " + arg);
        //把请求转发给呗代理对象proxied
        return method.invoke(proxied, args);
    }
}

class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        // Insert a proxy and call again:
        // 这里把实际对象real 传给处理器
        Interface proxy = (Interface) Proxy.newProxyInstance(
            Interface.class.getClassLoader(),
            new Class[]{Interface.class},
            new DynamicProxyHandler(real));
        consumer(proxy);
    }
}

/* Output: (95% match)
doSomething
somethingElse bonobo
**** proxy: class $Proxy0, method: public abstract void Interface.doSomething(), args: null
doSomething
**** proxy: class $Proxy0, method: public abstract void Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@42e816
  bonobo
somethingElse bonobo
*///:~
