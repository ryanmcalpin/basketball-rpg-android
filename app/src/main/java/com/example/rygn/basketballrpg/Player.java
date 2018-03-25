package com.example.rygn.basketballrpg;

/**
 * Created by rygn on 3/24/18.
 */

public class Player {
    private String name;
    private int jerseyNumber;
    private int position;
    private int heightInInches;
    private int weightInPounds;

    private int athleticism;
    private int skill;
    private int iq;
    private int defense;

    private int speed = 0;
    private int vertical = 0;
    private int strength = 0;

    private int shooting = 0;
    private int dribbling = 0;
    private int passing = 0;

    private int playmaking = 0;
    private int positioning = 0;
    private int foulDraw = 0;

    private int cleanDefense = 0;
    private int steal = 0;
    private int block = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        this.heightInInches = heightInInches;
    }

    public int getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(int weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    // main attribute categories

    public int getAthleticism() {
        return speed + vertical + strength;
    }

    public int getSkill() {
        return shooting + dribbling + passing;
    }

    public int getIq() {
        return playmaking + positioning + foulDraw;
    }

    public int getDefense() {
        return cleanDefense + steal + block;
    }

    // specific abilities

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getShooting() {
        return shooting;
    }

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public int getDribbling() {
        return dribbling;
    }

    public void setDribbling(int dribbling) {
        this.dribbling = dribbling;
    }

    public int getPassing() {
        return passing;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public int getPlaymaking() {
        return playmaking;
    }

    public void setPlaymaking(int playmaking) {
        this.playmaking = playmaking;
    }

    public int getPositioning() {
        return positioning;
    }

    public void setPositioning(int positioning) {
        this.positioning = positioning;
    }

    public int getFoulDraw() {
        return foulDraw;
    }

    public void setFoulDraw(int foulDraw) {
        this.foulDraw = foulDraw;
    }

    public int getSteal() {
        return steal;
    }

    public void setSteal(int steal) {
        this.steal = steal;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getCleanDefense() {
        return cleanDefense;
    }

    public void setCleanDefense(int cleanDefense) {
        this.cleanDefense = cleanDefense;
    }
}
