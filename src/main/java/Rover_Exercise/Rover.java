package Rover_Exercise;

import java.util.ArrayList;

public class Rover {
    public final double MAX_X = 3;
    public final double MIN_X = 0;
    public final double MAX_Y = 3;
    public final double MIN_Y = 0;

    public Position position;
    public char direction;
    public char command;
    public CommandBuffer commandBuffer;

    public Rover() {
        position = new Position();
        commandBuffer = new CommandBuffer(new ArrayList<>());
        direction = Directions.N.des;
        command = Commands.F.des;
    }

    public void moveRight() {
        position.x++;
        if (position.x >= MAX_X) position.x = MAX_X;
    }

    public void moveUp() {
        position.y++;
        if (position.y >= MAX_Y) position.y = MAX_Y;
    }

    public void moveLeft() {
        position.x--;
        if (position.x <= MIN_X) position.x = MIN_X;
    }

    public void moveDown() {
        position.y--;
        if (position.y <= MIN_Y) position.y = MIN_Y;
    }

    public void turnLeft() {
        switch (direction) {
            case 'N':
                direction = Directions.W.des;
                break;
            case 'W':
                direction = Directions.S.des;
                break;
            case 'S':
                direction = Directions.E.des;
                break;
            case 'E':
                direction = Directions.N.des;
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case 'N':
                direction = Directions.E.des;
                break;
            case 'E':
                direction = Directions.S.des;
                break;
            case 'S':
                direction = Directions.W.des;
                break;
            case 'W':
                direction = Directions.N.des;
                break;
        }
    }

    public void addCommand(char moveCommand, char directionCommand) {
        switch (directionCommand) {
            case 'N':
            case 'E':
                addAdvance(moveCommand);
                break;
            case 'S':
            case 'W':
                addReverse(moveCommand);
                break;
        }
    }

    private void addAdvance(char moveCommand) {
        if (moveCommand == 'f') commandBuffer.commands.add(Commands.F.des);
        else commandBuffer.commands.add(Commands.B.des);
    }

    private void addReverse(char moveCommand) {
        if (moveCommand == 'f') commandBuffer.commands.add(Commands.B.des);
        else commandBuffer.commands.add(Commands.F.des);
    }
}
