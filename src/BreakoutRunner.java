final class BreakoutRunner extends SwingApplication {

  /**
   * Width of the JFrame.
   */
  private static final int WIDTH = 640;

  /**
   * Height of the JFrame.
   */
  private static final int HEIGHT = 640;

  /**
   * The frames-per-second that we want this application to achieve.
   */
  private static final int TARGET_FPS = 60;

  /**
   * Title of the JFrame.
   */
  private static final String TITLE = "Breakout";

  private final BreakoutPanel BREAKOUT_PANEL;

  BreakoutRunner(final int width, final int height, final int fps, final String title) {
    super(width, height, fps, title);
    this.BREAKOUT_PANEL = new BreakoutPanel(this);
    this.addComponent(this.BREAKOUT_PANEL);
    this.packComponents();
    this.setVisible(true);
    this.BREAKOUT_PANEL.requestFocus(true);
    this.start();
  }

  @Override
  public void run() {
    this.BREAKOUT_PANEL.update();
  }

  public static void main(final String[] args) {
    BreakoutRunner runner = new BreakoutRunner(WIDTH, HEIGHT, TARGET_FPS, TITLE);
    runner.run();
  }
}