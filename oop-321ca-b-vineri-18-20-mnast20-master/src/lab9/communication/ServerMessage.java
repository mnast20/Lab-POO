package lab9.communication;

import lab9.storage.SensorData;

/**
 * Represents the content of the message sent to the server.
 */
public class ServerMessage {
    private final int steps;
    private final int clientid;
    private final long timestamp;

    ServerMessage(int steps, int clientid, long timestamp) {
        this.steps = steps;
        this.clientid = clientid;
        this.timestamp = timestamp;
    }

    public ServerMessage(SensorData sensorData, int clientid) {
        this(sensorData.getStepsCount(), clientid, sensorData.getTimestamp());
    }

    @Override
    public String toString() {
        return "{" +
                "steps=" + steps +
                ", clientid=" + clientid +
                ", timestamp=" + timestamp +
                '}';
    }
}
