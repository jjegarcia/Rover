public class Rover {
    public final double MAX_X = 100;
    public final double MIN_X = 0;
    public final double MAX_Y = 100;
    public final double MIN_Y = 0;

    public Position previousPosition;
    public Position position;
    char direction;
    char command;

    Rover() {
        previousPosition = new Position();
        position = new Position();
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

    public void turnLeft(int inc) {
        int to = inc % 4;
        switch (direction) {
            case 'N':
                switch (to){
                    case 1:direction = Directions.W.des;
                    break;
                    case 2:direction = Directions.S.des;
                    break;
                    case 3:direction = Directions.E.des;
                        break;
                    case 4:direction = Directions.N.des;
                        break;
                }
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
}
