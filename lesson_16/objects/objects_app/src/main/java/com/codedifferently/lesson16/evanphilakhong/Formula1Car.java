package com.codedifferently.lesson16.evanphilakhong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    // methods
    public void printSponsors() {
        for (String sponsor : sponsors) {
            System.out.println(sponsor);
        }
    }
    public static void main(String[] args) {
        Formula1Car formula1Car = new Formula1Car();
        Team team = Team.MCLAREN;
        formula1Car.setTeam(team);
    }
}