package View;

public class Time extends Thread{

    //Attribute that contains the time
    private int time;

    //Attribute that contains the GameInterface
    private GameInterface gameInterface;

    //Constructor that creates the time
    public Time(GameInterface gameInterface){
        this.time = Constant_view.TIME;
        this.gameInterface = gameInterface;
    }

    //Default constructor
    public Time(){
        this(null);
    }

    //Method that increments the time
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
                this.time--;
                this.gameInterface.updateTime(this.time);
                if(this.time <=0){
                    if(!this.gameInterface.isEnded())this.gameInterface.lose();
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //Method that returns the time
    public int getTime(){
        return this.time;
    }

    //Main method that tests the class
    public static void main(String[] args){
        Time t = new Time();
        t.start();
        while(true){
            System.out.println(t.getTime());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
