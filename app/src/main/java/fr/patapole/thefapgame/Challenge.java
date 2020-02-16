package fr.patapole.thefapgame;

import java.util.ArrayList;
import java.util.List;

public class Challenge {

    public static List<Challenge> challenges = new ArrayList<>();

    private String name;
    private String desc;
    private int icon;
    private boolean done;

    public Challenge(String name, String desc, int id){
        this.name = name;
        this.desc = desc;
        this.icon = id;
        this.challenges.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString(){
        return name;
    }
}
