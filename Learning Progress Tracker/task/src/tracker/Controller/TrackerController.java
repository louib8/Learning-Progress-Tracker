package tracker.Controller;

public class TrackerController {
    private MainMenuController trackerMenu;

    public TrackerController() {
        this.trackerMenu = new MainMenuController();
    }

    public MainMenuController getTrackerMenu() {
        return trackerMenu;
    }

    public void setTrackerMenu(MainMenuController trackerMenu) {
        this.trackerMenu = trackerMenu;
    }
}
