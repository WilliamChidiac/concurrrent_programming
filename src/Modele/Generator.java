package Modele;

public abstract class Generator<T> extends Thread {
    private final int time;
    private final int init_num;
    public Generator(int t, int init){
        time = t;
        init_num = init;
    }
    public abstract T generate();

    @Override
    public void run(){
        System.out.println("chouuuuu");
        for (int i = 0; i < init_num; i++){
            try{
                Thread.sleep(1000);
                generate();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        while (true){
            try {
                Thread.sleep(time);
                generate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}