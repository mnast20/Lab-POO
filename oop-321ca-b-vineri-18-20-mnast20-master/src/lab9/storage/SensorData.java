package lab9.storage;

/**
 * Represents the sensing data sent to the storage component
 */
public class SensorData {
    private final int stepsCount;
    private final long timestamp;

    public int getStepsCount() {
        return stepsCount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("stepsCount=%d, timestamp=%d", stepsCount, timestamp);
    }

    public SensorData(int stepsCount, long timestamp) {
        this.stepsCount = stepsCount;
        this.timestamp = timestamp;
    }
}