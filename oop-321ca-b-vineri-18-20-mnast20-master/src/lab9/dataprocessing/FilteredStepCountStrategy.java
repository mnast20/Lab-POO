package lab9.dataprocessing;

import lab9.main.Utils;
import lab9.storage.SensorData;

import java.util.ArrayList;

public class FilteredStepCountStrategy implements StepCountStrategy {
    int totalSteps;

    public void addSteps(ArrayList<SensorData> data) {
        int size = data.size();
        int nrSteps = data.get(size - 1).getStepsCount();
        long interval = data.get(size - 1).getTimestamp();
        if (size != 1) {
            interval -= data.get(size - 2).getTimestamp();
        }
        double stepsPerMin = (double) nrSteps / (double) interval;
        if (nrSteps >= 0 && stepsPerMin <= Utils.MAX_DIFF_STEPS_CONSECUTIVE_RECORDS) {
            totalSteps += nrSteps;
        }
    }

    @Override
    public int getTotalSteps() {
        return 0;
    }

    @Override
    public String getStrategyDescription() {
        return "Filtered StepCount Strategy with a total steps of "
                + totalSteps;
    }
}
