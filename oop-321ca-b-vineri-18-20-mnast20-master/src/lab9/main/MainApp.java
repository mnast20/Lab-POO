package lab9.main;

import lab9.dataprocessing.StepCountFactory;
import lab9.dataprocessing.StepCountStrategy;
import lab9.storage.DataRepository;
import lab9.storage.SensorData;
import lab9.storage.observers.ConsoleLogger;
import lab9.storage.observers.DataAggregator;
import lab9.storage.observers.ServerCommunicationController;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("Choose a strategy: type 'basic or 'filtered'");
        Scanner scanner = new Scanner(System.in);
        String strategyType = scanner.next();
        scanner.close();

        DataRepository dataRepository = new DataRepository();

        StepCountStrategy strategy = StepCountFactory.createStepCount(strategyType);

        // don't forget to provide the strategy to the DataAggregator observer
        dataRepository.addObserver(new ConsoleLogger());
        dataRepository.addObserver(new ServerCommunicationController());
        dataRepository.addObserver(new DataAggregator(strategy));

        long baseTimestamp = System.currentTimeMillis();

        dataRepository.addData(new SensorData(10, baseTimestamp + 1));
        System.out.println();

        dataRepository.addData(new SensorData(20, baseTimestamp + 2));
        System.out.println();

        dataRepository.addData(new SensorData(30, baseTimestamp + 3));
        System.out.println();

        dataRepository.addData(new SensorData(4000, baseTimestamp + 4));
        // dataRepository.addData(new SensorData(4000, baseTimestamp + 40000));
        System.out.println();

        dataRepository.addData(new SensorData(50, baseTimestamp + 5));
        System.out.println();

        dataRepository.addData(new SensorData(-100, baseTimestamp + 6));
        System.out.println();

        dataRepository.addData(new SensorData(500, baseTimestamp + 600));
        System.out.println();
    }
}