package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, int year, int odometer, String makeModel) {
        super(description, dateAcquired, originalCost);
        this.year = year;
        this.odometer = odometer;
        this.makeModel = makeModel;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        double value = getOriginalCost();
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - year;

        if (age <= 3) {
            value -= value * (0.03 * age);
        } else if (age <= 6) {
            value -= value * (0.06 * age);
        } else if (age <= 10) {
            value -= value * (0.08 * age);
        } else {
            value = 1000.0;
        }


        boolean isHondaOrToyota = makeModel.toLowerCase().contains("honda") ||
                makeModel.toLowerCase().contains("toyota");

        if (odometer > 100000 && !isHondaOrToyota) {
            value *= 0.75; // reduce by 25%
        }

        return value;
    }
}
