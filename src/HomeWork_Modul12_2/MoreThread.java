package HomeWork_Modul12_2;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MoreThread {
    private int n;
    private int current;
    private Lock lock;
    private Condition condition;

    public MoreThread(int n) {
        this.n = n;
        this.current = 1;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void fizz() throws InterruptedException {
        while (current <= n) {
            lock.lock();
            try {
                if (current % 3 == 0 && current % 5 != 0) {
                    System.out.print("fizz, ");
                    current++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void buzz() throws InterruptedException {
        while (current <= n) {
            lock.lock();
            try {
                if (current % 5 == 0 && current % 3 != 0) {
                    System.out.print("buzz, ");
                    current++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        while (current <= n) {
            lock.lock();
            try {
                if (current % 3 == 0 && current % 5 == 0) {
                    System.out.print("fizzbuzz ");
                    current++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void number() throws InterruptedException {
        while (current <= n) {
            lock.lock();
            try {
                if (current % 3 != 0 && current % 5 != 0) {
                    System.out.print(current + ", ");
                    current++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        int n = 15;
        MoreThread moreThread = new MoreThread(n);

        Thread threadA = new Thread(() -> {
            try {
                moreThread.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                moreThread.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                moreThread.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                moreThread.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
