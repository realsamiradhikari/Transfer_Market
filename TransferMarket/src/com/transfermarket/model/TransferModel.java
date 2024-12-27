package com.transfermarket.model;

/**
 *
 * @author Samir Adhikari
 */
public class TransferModel {
    private int playerId;
    private String playerName;
    private String position;
    private String nationality;
    private int age;
    private double marketValue;
    private int contractDuration;
    private int goalContribution;

    public TransferModel() {
    }
    // Constructor
    public TransferModel(int playerId, String playerName, String position, String nationality,
                  int age, double marketValue, int contractDuration, int goalContribution) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.position = position;
        this.nationality = nationality;
        this.age = age;
        this.marketValue = marketValue;
        this.contractDuration = contractDuration;
        this.goalContribution = goalContribution;
    }

    // Getters and Setters

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public int getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    public int getGoalContribution() {
        return goalContribution;
    }

    public void setGoalContribution(int goalContribution) {
        this.goalContribution = goalContribution;
    }
    
    
}