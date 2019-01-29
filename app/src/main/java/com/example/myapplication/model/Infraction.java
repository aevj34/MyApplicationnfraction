package com.example.myapplication.model;

public class Infraction {

    private String origin;
    private String id;
    private String plate;
    private String registered;
    private String type;
    private String typeDenomination;
    private String preventiveMeasure;
    private String amount;
    private String amountText;


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeDenomination() {
        return typeDenomination;
    }

    public void setTypeDenomination(String typeDenomination) {
        this.typeDenomination = typeDenomination;
    }

    public String getPreventiveMeasure() {
        return preventiveMeasure;
    }

    public void setPreventiveMeasure(String preventiveMeasure) {
        this.preventiveMeasure = preventiveMeasure;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmountText() {
        return amountText;
    }

    public void setAmountText(String amountText) {
        this.amountText = amountText;
    }
}
