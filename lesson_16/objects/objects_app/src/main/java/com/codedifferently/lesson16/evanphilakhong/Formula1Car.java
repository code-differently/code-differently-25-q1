package com.codedifferently.lesson16.evanphilakhong;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")

public class Formula1Car {
    private Team team;
    private String[] sponsors;
    private String driverName;
    private int driverNum;
    private TyreCompound currTyre;
    private boolean isDrs;

    //Constructors
    public Formula1Car() {
        this.team = null;
        this.sponsors = new String[0];
        this.driverName = "";
        this.driverNum = 0;
        this.currTyre = null;
        this.isDrs = false;
    }

    public Formula1Car(Team team, String[] sponsors, String driverName, int driverNum, TyreCompound currTyre) {
        this.team = team;
        this.sponsors = sponsors;
        this.driverName = driverName;
        this.driverNum = driverNum;
        this.currTyre = currTyre;
        this.isDrs = false;
    }

    // setters
    public void setTeam(Team team) {
        this.team = team;
    }

    public void setSponsors(String[] sponsors) {
        this.sponsors = sponsors;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setDriverNum(int driverNum) {
        this.driverNum = driverNum;
    }

    public void setCurrTyre(TyreCompound newTyre) {
        this.currTyre = newTyre;
    }

    public void setIsDrsOn(boolean isDrs) {
        this.isDrs = isDrs;
    }

    // getters
    public String getTeam() {
        return this.team.toString();
    }

    public String[] getSponsors() {
        return this.sponsors;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public int getDriverNum() {
        return this.driverNum;
    }

    public TyreCompound getTyreCompound() {
        return this.currTyre;
    }

    public boolean getIsDrsOn() {
        return this.isDrs;
    }

    // methods
    public void printSponsors() {
        for (String sponsor : sponsors) {
            System.out.println(sponsor);
        }
    }
    public static void main(String[] args) {

    }
}