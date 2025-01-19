package com.transfermarket.model;

/**
 * Represents a transfer market player with various attributes such as player
 * ID, name, position, nationality, age, market value, contract duration, and
 * goal contribution. Provides getter and setter methods for accessing and
 * modifying these attributes.
 *
 * This class serves as a data model for the transfer market application.
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

    /**
     * Default constructor for TransferModel. Initializes a TransferModel object
     * with default values.
     */
    public TransferModel() {
    }

    /**
     * Constructs a TransferModel object with the specified attributes.
     *
     * @param playerId The unique identifier of the player.
     * @param playerName The name of the player.
     * @param position The position the player plays in (e.g., Forward,
     * Midfielder).
     * @param nationality The nationality of the player.
     * @param age The age of the player.
     * @param marketValue The estimated market value of the player in monetary
     * terms.
     * @param contractDuration The remaining duration of the player's contract
     * in years.
     * @param goalContribution The number of goals the player has contributed to
     * (goals + assists).
     */
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
    /**
     * Retrieves the player's unique identifier.
     *
     * @return The player ID.
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Updates the player's unique identifier.
     *
     * @param playerId The new player ID.
     */
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    /**
     * Retrieves the name of the player.
     *
     * @return The player's name.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Updates the name of the player.
     *
     * @param playerName The new player name.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Retrieves the position of the player.
     *
     * @return The player's position.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Updates the position of the player.
     *
     * @param position The new player position.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Retrieves the nationality of the player.
     *
     * @return The player's nationality.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Updates the nationality of the player.
     *
     * @param nationality The new player nationality.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Retrieves the age of the player.
     *
     * @return The player's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Updates the age of the player.
     *
     * @param age The new player age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Retrieves the market value of the player.
     *
     * @return The player's market value.
     */
    public double getMarketValue() {
        return marketValue;
    }

    /**
     * Updates the market value of the player.
     *
     * @param marketValue The new market value.
     */
    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    /**
     * Retrieves the contract duration of the player in years.
     *
     * @return The contract duration.
     */
    public int getContractDuration() {
        return contractDuration;
    }

    /**
     * Updates the contract duration of the player.
     *
     * @param contractDuration The new contract duration in years.
     */
    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    /**
     * Retrieves the goal contribution of the player (goals + assists).
     *
     * @return The player's goal contribution.
     */
    public int getGoalContribution() {
        return goalContribution;
    }

    /**
     * Updates the goal contribution of the player.
     *
     * @param goalContribution The new goal contribution (goals + assists).
     */
    public void setGoalContribution(int goalContribution) {
        this.goalContribution = goalContribution;
    }

}
