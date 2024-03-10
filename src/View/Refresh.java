package View;

public class Refresh extends Thread{
    Main_panel main_panel;
    public Refresh(Main_panel main_panel) {
        this.main_panel = main_panel;
    }

    /**
     * Refresh the main panel
     */
    @Override
    public void run() {
        while (true) {
            main_panel.repaint();
            try {
                Thread.sleep(Constant_view.REFRESH_RATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
