package lab9.dataprocessing;

import lab9.storage.SensorData;

import java.util.ArrayList;

public class BasicStepCountStrategy implements StepCountStrategy {
    int totalSteps;

    public void addSteps(ArrayList<SensorData> data) {
        int size = data.size();
        totalSteps += data.get(size - 1).getStepsCount();
    }

    @Override
    public int getTotalSteps() {
        return totalSteps;
    }

    @Override
    public String getStrategyDescription() {
        return "Basic StepCount Strategy with a total of "
                + totalSteps
                + " steps";
    }
}
