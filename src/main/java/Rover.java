import java.util.ArrayList;

public class Rover {
    public final double MAX_X = 100;
    public final double MIN_X = 0;
    public final double MAX_Y = 100;
    public final double MIN_Y = 0;

    public Position previousPosition;
    public Position position;
    char direction;
    char command;
    CommandBuffer commandBuffer;

    Rover() {
        previousPosition = new Position();
        position = new Position();
        commandBuffer = new CommandBuffer(new ArrayList<>());
        direction = Directions.N.des;
        command = Commands.F.des;
    }

    public void moveForwardX(double inc) {
        previousPosition.x = position.x;
        position.x += inc;
        if (position.x >= MAX_X) position.x = MAX_X;
    }

    public void moveForwardY(double inc) {
        previousPosition.y = position.y;
        position.y += inc;
        if (position.y >= MAX_Y) position.y = MAX_Y;
    }

    public void moveBackwardX(double inc) {
        previousPosition.x = position.x;
        position.x -= inc;
        if (position.x <= MIN_X) position.x = MIN_X;
    }

    public void moveBackwardY(double inc) {
        previousPosition.y = position.y;
        position.y -= inc;
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
