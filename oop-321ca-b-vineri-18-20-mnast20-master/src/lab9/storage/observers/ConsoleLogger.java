package lab9.storage.observers;

import lab9.storage.DataRepository;
import lab9.storage.SensorData;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ConsoleLogger implements Observer {
    @Override
    public void update(Observable o, Object dataRepository) {
        System.out.println("Console Logger observer result:");
        DataRepository repository = (DataRepository) dataRepository;
        ArrayList<SensorData> data = repository.getData();
        SensorData newData = data.get(data.size() - 1);
        System.out.println("Added " + newData + " to the Data Repository");
        System.out.println();
    }
}
