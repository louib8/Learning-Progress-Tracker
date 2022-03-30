package tracker;

public class TrackerController {
    private TrackerMenu trackerMenu;

    TrackerController() {
        this.trackerMenu = new TrackerMenu();
    }

    public TrackerMenu getTrackerMenu() {
        return trackerMenu;
    }

    public void setTrackerMenu(TrackerMenu trackerMenu) {
        this.trackerMenu = trackerMenu;
    }
}
