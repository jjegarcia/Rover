package Rover_Exercise;

public enum Commands {
    F ('f'),
    B('b'),
    U('u');//for undetermined
    public char des;
    Commands(char des ) {
        this.des=des;
    }
}
