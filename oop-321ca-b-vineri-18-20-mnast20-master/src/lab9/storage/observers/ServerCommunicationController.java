package lab9.storage.observers;

import lab9.communication.ServerMessage;
import lab9.main.Utils;
import lab9.storage.DataRepository;
import lab9.storage.SensorData;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ServerCommunicationController implements Observer {
    @Override
    public void update(Observable o, Object dataRepository) {
        System.out.println("Server Communication Controller observer result:");
        DataRepository repository = (DataRepository) dataRepository;
        ArrayList<SensorData> data = repository.getData();
        SensorData newData = data.get(data.size() - 1);
        ServerMessage message = new ServerMessage(newData, Utils.getClientId());
        System.out.println("Server Message: " + message);
        System.out.println();
    }
}
