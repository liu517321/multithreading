/**
 * 懒汉模式的单例：单线程环境下正确
 *                  多线程环境下有线程安全问题
 */
public class SingletonLazyVersion1 {
    private SingletonLazyVersion1() {}

    // 可见性
    private static SingletonLazyVersion1 instance = null;
    // getInstance 被第一次调用时，意味着有人需要 instance
    // 再进行初始化
    public static SingletonLazyVersion1 getInstance() {
        // 原子开始
        if (instance == null) {
            instance = new SingletonLazyVersion1();
        }
        // 原子结束

        return instance;
    }
}