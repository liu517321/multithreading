// 饿汉模式的单例
public class SingletonHungry {
    // 不允许外边调用构造方法
    private SingletonHungry() {}

    private static final SingletonHungry instance = new SingletonHungry();
    public static SingletonHungry getInstance() {
        return instance;
    }
}
