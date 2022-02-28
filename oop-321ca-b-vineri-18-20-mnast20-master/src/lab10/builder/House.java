package lab10.builder;

import java.util.ArrayList;

public class House {
    private final String location; // mandatory
    private final int nrFloors; // mandatory
    private final int nrRooms; // mandatory
    private final boolean heating; // mandatory
    private final int furnishing; // optional
    private final ArrayList<String> utilities; // optional
    private final int nrPools; // optional
    private final int nrSolarPanels; // optional
    private final int nrSecurityFacilities; // optional

    private House(HouseBuilder builder) {
        this.location = builder.location;
        this.nrFloors = builder.nrFloors;
        this.nrRooms = builder.nrRooms;
        this.heating = builder.heating;
        this.furnishing = builder.furnishing;
        this.utilities = builder.utilities;
        this.nrPools = builder.nrPools;
        this.nrSolarPanels = builder.nrSolarPanels;
        this.nrSecurityFacilities = builder.nrSecurityFacilities;
    }

    public String getLocation() {
        return location;
    }

    public int getNrFloors() {
        return nrFloors;
    }

    public int getNrRooms() {
        return nrRooms;
    }

    public boolean isHeating() {
        return heating;
    }

    public int getFurnishing() {
        return furnishing;
    }

    public ArrayList<String> getUtilities() {
        return utilities;
    }

    public int getNrPools() {
        return nrPools;
    }

    public int getNrSolarPanels() {
        return nrSolarPanels;
    }

    public int getNrSecurityFacilities() {
        return nrSecurityFacilities;
    }

    @Override
    public String toString() {
        return "House{" +
                "location='" + location + '\'' +
                ", nrFloors=" + nrFloors +
                ", nrRooms=" + nrRooms +
                ", heating=" + heating +
                ", furnishing=" + furnishing +
                ", utilities=" + utilities +
                ", nrPools=" + nrPools +
                ", nrSolarPanels=" + nrSolarPanels +
                ", nrSecurityFacilities=" + nrSecurityFacilities +
                '}';
    }

    public static class HouseBuilder {
        private final String location; // mandatory
        private final int nrFloors; // mandatory
        private final int nrRooms; // mandatory
        private final boolean heating; // mandatory
        private int furnishing = 0; // optional
        private ArrayList<String> utilities = new ArrayList<>(); // optional
        private int nrPools = 0; // optional
        private int nrSolarPanels = 0; // optional
        private int nrSecurityFacilities = 0; // optional

        public HouseBuilder(String location, int nrFloors, int nrRooms, boolean heating) {
            this.location = location;
            this.nrFloors = nrFloors;
            this.nrRooms = nrRooms;
            this.heating = heating;
        }

        public HouseBuilder furnishing(int furnishing) {
            this.furnishing = furnishing;
            return this;
        }

        public HouseBuilder utilities(ArrayList<String> utilities) {
            this.utilities = utilities;
            return this;
        }

        public HouseBuilder pools(int nrPools) {
            this.nrPools = nrPools;
            return this;
        }

        public HouseBuilder solarPanels(int nrSolarPanels) {
            this.nrSolarPanels = nrSolarPanels;
            return this;
        }

        public HouseBuilder securityFacilities(int nrSecurityFacilities) {
            this.nrSecurityFacilities = nrSecurityFacilities;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}