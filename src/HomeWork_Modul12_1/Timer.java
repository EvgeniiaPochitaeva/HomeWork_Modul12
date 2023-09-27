package HomeWork_Modul12_1;

public class Timer {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");

        new Thread(() -> {
            int count = 0;
            while (true) {

            System.out.println("Від моменту запуску програми минуло " + count + " секунд(а/и)");

            try {
                Thread.sleep(1000);
                }
            catch (InterruptedException e) {
            e.printStackTrace();
                }
            count++;

            }
        }).start();

        while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }


        }


    }

}
