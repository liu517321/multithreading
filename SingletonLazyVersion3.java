public class SingletonLazyVersion3 {
    private SingletonLazyVersion3() {}
    private volatile static SingletonLazyVersion3 instance = null;

    // A
    private static SingletonLazyVersion3 getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyVersion3.class) {
                if (instance == null) {
                    instance = new SingletonLazyVersion3();
                }
            }
        }

        return instance;
    }
}

