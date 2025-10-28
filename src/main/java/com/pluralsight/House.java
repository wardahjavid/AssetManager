package com.pluralsight;

public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
    public String getConditionText() {
        switch (condition) {
            case 1: return "Excellent";
            case 2: return "Good";
            case 3: return "Fair";
            case 4: return "Poor";
            default: return "Unknown";
        }
    }

    @Override
    public double getValue() {
        double ratePerSqFt = 0.0;

        switch (condition) {
            case 1:
                ratePerSqFt = 180.0;
                break;
            case 2:
                ratePerSqFt = 130.0;
                break;
            case 3:
                ratePerSqFt = 90.0;
                break;
            case 4:
                ratePerSqFt = 80.0;
                break;
            default:
                ratePerSqFt = 0.0;
                break;
        }

        double value = (ratePerSqFt * squareFoot) + (0.25 * lotSize);
        return value;
    }
}
