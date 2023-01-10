
class s extends Thread {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("bala");
            Thread.sleep(1000);
        }
    }
}

class sample{
    public static void main(String args[]) throws Exception {
        s t = new s();
        t.start();
        for (int i = 0; i <= 3; i++)
            System.out.println("human");
    }
}
