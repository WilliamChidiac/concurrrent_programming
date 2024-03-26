package View;

public class Refresh extends Thread{
    private GameInterface window;
    public Refresh(GameInterface window) {
        this.window = window;
    }

    /**
     * Refresh the main panel
     */
    @Override
    public void run() {
        while (true) {
            window.revalidate();
            window.repaint();
            try {
                Thread.sleep(Constant_view.REFRESH_RATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
