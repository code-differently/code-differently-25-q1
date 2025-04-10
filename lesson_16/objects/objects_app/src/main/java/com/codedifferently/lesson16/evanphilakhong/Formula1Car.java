package com.codedifferently.lesson16.evanphilakhong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Formula1Car {
    private Track track;
    private Team team;
    private String[] sponsors;
    private String driverName;
    private int driverNum;
    private int position;
    private TyreCompound currTyre;
    private boolean drs;

    //Constructors
    public Formula1Car() {
        this.team = null;
        this.sponsors = new String[0];
        this.driverName = "";
        this.driverNum = 0;
        this.currTyre = null;
        this.drs = false;
    }

    public Formula1Car(Team team, String[] sponsors, String driverName, int driverNum, int position, TyreCompound currTyre) {
        this.team = team;
        this.sponsors = sponsors;
        this.driverName = driverName;
        this.driverNum = driverNum;
        this.position = position;
        this.currTyre = currTyre;
        this.drs = false;
    }

    // methods
    public void printSponsors() {
        if (sponsors.length == 0) {
            System.out.println("There are no Sponsors");
        } else {
            System.out.println("Here's a list of our Sponsors:");
            for (String sponsor : sponsors) {
                System.out.println(sponsor);
            }
        }
    }

    public boolean isDrsAvailible() {
        if (track.isDrsZone()) {
            this.drs = true;
            return true;
        }
        return false;
    }

    public boolean rainStrategy() {
        if (track.isRaining()) {
            currTyre.setCurrTyre(TyreCompound.WET);
        }
    }

    public static void main(String[] args) {
        Formula1Car formula1Car = new Formula1Car();
        Team team = Team.MCLAREN;
        formula1Car.setTeam(team);
    }
}