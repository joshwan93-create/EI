import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class Room {
    private static int nextId = 1; // Static counter for unique room IDs

    private int roomId;
    private int occupancyCount = 0;
    private boolean booked = false;
    private List<Observer> observers = new ArrayList<>();
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture<?> autoReleaseTask;

    public Room() { 
        this.roomId = nextId++; // Assign unique ID automatically
    }

    public int getRoomId() { return roomId; }
    public boolean isBooked() { return booked; }
    public boolean isOccupied() { return occupancyCount >= 2; }

    public void addObserver(Observer obs) { observers.add(obs); }
    public void removeObserver(Observer obs) { observers.remove(obs); }

    private void notifyObservers() { observers.forEach(o -> o.update(this)); }

    public void enterRoom(int people) {
        occupancyCount += people;
        notifyObservers();
        cancelAutoRelease();
    }

    public void leaveRoom(int people) {
        occupancyCount = Math.max(0, occupancyCount - people);
        notifyObservers();
        if (occupancyCount < 2) scheduleAutoRelease();
    }

    public void bookRoom() {
        booked = true;
        scheduleAutoRelease();
    }

    public void cancelBooking() {
        booked = false;
        cancelAutoRelease();
    }

    private void scheduleAutoRelease() {
        cancelAutoRelease();
        autoReleaseTask = scheduler.schedule(() -> {
            if (!isOccupied()) {
                booked = false;
                Logger.getLogger(Room.class.getName()).log(Level.INFO,
                        "Room {0} auto-released due to no occupancy.", roomId);
            }
        }, 5, TimeUnit.MINUTES);
    }

    private void cancelAutoRelease() {
        if (autoReleaseTask != null && !autoReleaseTask.isDone()) autoReleaseTask.cancel(true);
    }
}
