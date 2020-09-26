import java.util.ArrayList;

public class Rover {
    public final double MAX_X = 3;
    public final double MIN_X = 0;
    public final double MAX_Y = 3;
    public final double MIN_Y = 0;

    public Position position;
    char direction;
    char command;
    CommandBuffer commandBuffer;

    Rover() {
        position = new Position();
        commandBuffer = new CommandBuffer(new ArrayList<>());
        direction = Directions.N.des;
        command = Commands.F.des;
    }

    public void moveForwardX() {
        position.x ++;
        if (position.x >= MAX_X) position.x = MAX_X;
    }

    public void moveForwardY() {
        position.y ++;
        if (position.y >= MAX_Y) position.y = MAX_Y;
    }

    public void moveBackwardX() {
        position.x --;
        if (position.x <= MIN_X) position.x = MIN_X;
    }

    public void moveBackwardY() {
        position.y --;
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
