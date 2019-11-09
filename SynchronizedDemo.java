public class SynchronizedDemo {
    public synchronized void method() {
        // 具体代码
        for (int i = 0; i < 100000; i++) {
            System.out.println("Method1:" + Thread.currentThread().getName() + ": " + i);
        }
    }

    public synchronized void method2() {
        for (long i = 0; i < 100000; i++) {
            System.out.println("Method2:" + Thread.currentThread().getName() + ": " + i);
        }
    }

    public synchronized static void staticMethod() {
        // 具体代码
    }

    public void block() {
        ///
        synchronized (SynchronizedDemo.class) {
            // 具体代码
        }
        ///
        synchronized (SynchronizedDemo.class) {
        }
        ///
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                object.method();
            }
        }
        private SynchronizedDemo object;
        MyThread(SynchronizedDemo object) {
            this.object = new SynchronizedDemo();
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo object = new SynchronizedDemo();
        Thread t = new MyThread(object);
        t.start();
        while (true) {
            object.method2();
        }
    }
}
