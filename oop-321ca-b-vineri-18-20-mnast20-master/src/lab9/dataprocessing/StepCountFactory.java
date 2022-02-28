package lab9.dataprocessing;

import lab9.main.Utils;

public class StepCountFactory {
    public static StepCountStrategy createStepCount(String type) {
        switch(type) {
            case Utils.BASIC_STRATEGY: return new BasicStepCountStrategy();
            case Utils.FILTERED_STRATEGY: return new FilteredStepCountStrategy();
        }
        throw new IllegalArgumentException("The strategy type " + type + " is not recognized.");
    }
}
