package com.aliciareesealex.milesperknowledge.model;

/*
 * Author: Reese, Alex, Alicia
 * Date: 10/13/2017
 * Store and retrieve data
 */

import com.aliciareesealex.milesperknowledge.Contract;

public class Achievement implements Contract.MPKModel.AchievementModel {
    private int achievementID;
    private int ranking;
    private int points;

    public Achievement() {
    }

    public int getAchievementID() {
        return achievementID;
    }

    public void setAchievementID(int achievementID) {
        this.achievementID = achievementID;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
