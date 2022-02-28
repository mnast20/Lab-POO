package lab9.storage;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Persists sensor data. Observable, its observers are notified when data is added it to.
 */
public class DataRepository extends Observable { // TODO make this an Observable
    ArrayList<SensorData> data = new ArrayList<>();

    @Override
    public void notifyObservers(Object data) {
        setChanged();
        super.notifyObservers(data);
    }

    public void addData(SensorData dataRecord){
        // TODO
        data.add(dataRecord);
        this.notifyObservers(this);
    }

    // TODO implement a method to get the stored data (needed by the strategies)

    public ArrayList<SensorData> getData() {
        return data;
    }
}
