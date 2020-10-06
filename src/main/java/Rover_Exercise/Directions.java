package Rover_Exercise;

public enum Directions {
    N ('N'),
    S('S'),
    E('E'),
    W('W'),
    U('u');//for undetermined
    public char des;
    Directions(char des ) {
        this.des=des;
    }
}
