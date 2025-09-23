package javaTopics.lambda;

public class Hotel {
    private int costPerNight;
    private String name;
    private HotelType type;

    public int getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(int costPerNight) {
        this.costPerNight = costPerNight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HotelType getType() {
        return type;
    }

    public void setType(HotelType type) {
        this.type = type;
    }

    public Hotel(int costPerNight, String name, HotelType type) {
        this.costPerNight = costPerNight;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "costPerNight=" + costPerNight +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
