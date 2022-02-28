package lab9.storage.observers;

import lab9.dataprocessing.StepCountStrategy;
import lab9.storage.DataRepository;
import lab9.storage.SensorData;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class DataAggregator implements Observer {
    StepCountStrategy strategy;

    public DataAggregator(StepCountStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update(Observable o, Object dataRepository) {
        System.out.println("Data Aggregator observer result:");
        DataRepository repository = (DataRepository) dataRepository;
        ArrayList<SensorData> data = repository.getData();
        strategy.addSteps(data);
        System.out.println(strategy.getStrategyDescription());
        System.out.println();
    }
}
