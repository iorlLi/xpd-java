package level0.design.singleton.demo2;

/**
 * 枚举实现单例模式
 *      https://blog.csdn.net/u013151053/article/details/118346012
 * 反射：1.SingletonZ 继承Enum类， 没有无参构造器
 *      2. Constructor 的 newInstance 方法限定了 clazz 的类型不能是 enum
 *
 * 序列化：枚举类没有实现Serializable ，不能被序列化
 *
 * 克隆：Enum 类中 clone 的方法是 final 类型，无法重写
 */
public enum SingletonZ {
    INSTANCE;
}
