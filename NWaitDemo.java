public class NWaitDemo {
    private static Object o = new Object();
    private static int n = 0;

    private static class Sub extends Thread {
        Sub() {
            super("n--");
        }

        @Override
        public void run() {
            while (true) {
                synchronized (o) {
                    if (n == 0) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    n--;
                    System.out.println(getName() + ":" + n);
                    o.notify();
                }
            }
        }
    }

    private static class Add extends Thread {
        Add() {
            //调用父类构造方法，用于起名
            super("n++");
        }

        @Override
        public void run() {
            while (true) {
                synchronized (o) {
                    if (n == 10) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //因为锁还没释放，所以可以放在上面
                    o.notify();
                    n++;
                    System.out.println(getName() + ":" + n);

                }
            }
        }
    }

    public static void main(String[] args) {
        Thread a = new Add();
        Thread b = new Sub();
        a.start();
        b.start();
    }
}

