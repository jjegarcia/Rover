import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RoverTest {
    Rover rover = new Rover();

    @Test
    public void validInitialX() {
        assertTrue(rover.position.x >= 0);
    }

    @Test
    public void validInitialY() {
        assertTrue(rover.position.y >= 0);
    }

    @Test
    public void validDirection() {
        assertTrue((rover.direction == Directions.N.des)
                || (rover.direction == Directions.S.des)
                || (rover.direction == Directions.E.des)
                || (rover.direction == Directions.W.des)
        );
    }

    @Test
    public void validCommandType_F_B() {
        assertTrue((rover.command == Commands.F.des) || (rover.command == Commands.B.des)
        );
    }

    @Test
    public void emptyCommandBuffer() {
        rover.commandBuffer = new CommandBuffer(new ArrayList<>());
        assertEquals(0, rover.commandBuffer.commands.size());
    }

    @Test
    public void singleCommandBuffer() {
        rover.commandBuffer = new CommandBuffer(new ArrayList<>(Collections.singletonList(Commands.B.des)));
        assertEquals(1, rover.commandBuffer.commands.size());
    }

    @Test
    public void twoCommandBuffer() {
        rover.commandBuffer = new CommandBuffer(new ArrayList<>(Arrays.asList(Commands.B.des, Commands.B.des)));
        assertEquals(2, rover.commandBuffer.commands.size());
    }

    @Test
    public void moveForwardX() {
        double inc = 2;
        rover.moveForwardX(inc);
        double differenceX = rover.position.x - rover.previousPosition.x;
        assertEquals(differenceX, inc, 0.0);
    }

    @Test
    public void capForwardX() {
        double inc = rover.MAX_X + 10;
        rover.moveForwardX(inc);
        assertEquals(rover.position.x, rover.MAX_X, 0.0);
    }

    @Test
    public void capNoForwardX() {
        double inc = rover.MAX_X - 10;
        rover.moveForwardX(inc);
        assertNotEquals(rover.position.x, rover.MAX_X, 0.0);
    }

    @Test
    public void moveForwardY() {
        double inc = 2;
        rover.moveForwardY(inc);
        double differenceY = rover.position.y - rover.previousPosition.y;
        assertEquals(differenceY, inc, 0.0);
    }


    @Test
    public void capForwardY() {
        double inc = rover.MAX_Y + 10;
        rover.moveForwardY(inc);
        assertEquals(rover.position.y, rover.MAX_Y, 0.0);
    }

    @Test
    public void capNoForwardY() {
        double inc = rover.MAX_Y - 10;
        rover.moveForwardY(inc);
        assertNotEquals(rover.position.y, rover.MAX_Y, 0.0);
    }

    @Test
    public void moveBackwardX() {
        rover.position.x = 5;
        double inc = 2;
        rover.moveBackwardX(inc);
        double differenceX = rover.previousPosition.x - rover.position.x;
        assertEquals(differenceX, inc, 0.0);
    }

    @Test
    public void capBackwardX() {
        rover.position.x = 5;
        double inc = 10;
        rover.moveBackwardX(inc);
        assertEquals(rover.position.x, rover.MIN_X, 0.0);
    }

    @Test
    public void capNoBackwardX() {
        rover.position.x = 5;
        double inc = 2;
        rover.moveBackwardX(inc);
        assertNotEquals(rover.position.x, rover.MIN_X, 0.0);
    }

    @Test
    public void moveBackwardY() {
        rover.position.y = 5;
        double inc = 2;
        rover.moveBackwardY(inc);
        double differenceY = rover.previousPosition.y - rover.position.y;
        assertEquals(differenceY, inc, 0.0);
    }

    @Test
    public void capBackwardY() {
        rover.position.y = 5;
        double inc = 10;
        rover.moveBackwardY(inc);
        assertEquals(rover.position.y, rover.MIN_Y, 0.0);
    }

    @Test
    public void capNoBackwardY() {
        rover.position.y = 5;
        double inc = 2;
        rover.moveBackwardY(inc);
        assertNotEquals(rover.position.y, rover.MIN_Y, 0.0);
    }

    @Test
    public void forwardX_when_N_direction() {
        rover.commandBuffer = new CommandBuffer(new ArrayList<>(Arrays.asList(Commands.B.des, Commands.B.des)));
        rover.addCommand(Commands.F.des,Directions.N.des);
        assertEquals((char) rover.commandBuffer.commands.get(rover.commandBuffer.commands.size() - 1), Commands.F.des);
    }

    @Test
    public void forwardX_when_E_direction() {
        rover.commandBuffer = new CommandBuffer(new ArrayList<>(Arrays.asList(Commands.B.des, Commands.B.des)));
        rover.addCommand(Commands.F.des,Directions.E.des);
        assertEquals((char) rover.commandBuffer.commands.get(rover.commandBuffer.commands.size() - 1), Commands.F.des);
    }

    @Test
    public void backwardX_when_S_direction() {
        rover.commandBuffer = new CommandBuffer(new ArrayList<>(Arrays.asList(Commands.B.des, Commands.F.des)));
        rover.addCommand(Commands.F.des,Directions.S.des);
        assertEquals((char) rover.commandBuffer.commands.get(rover.commandBuffer.commands.size() - 1), Commands.B.des);
    }

    @Test
    public void backwardX_when_W_direction() {
        rover.commandBuffer = new CommandBuffer(new ArrayList<>(Arrays.asList(Commands.B.des, Commands.F.des)));
        rover.addCommand(Commands.F.des,Directions.W.des);
        assertEquals((char) rover.commandBuffer.commands.get(rover.commandBuffer.commands.size() - 1), Commands.B.des);
    }

    @Test
    public void turnLeftN() {
        rover.direction = Directions.N.des;
        rover.turnLeft();
        assertEquals(rover.direction, Directions.W.des);
    }

    @Test
    public void turnLeftW() {
        rover.direction = Directions.W.des;
        rover.turnLeft();
        assertEquals(rover.direction, Directions.S.des);
    }

    @Test
    public void turnLeftS() {
        rover.direction = Directions.S.des;
        rover.turnLeft();
        assertEquals(rover.direction, Directions.E.des);
    }

    @Test
    public void turnLeftE() {
        rover.direction = Directions.E.des;
        rover.turnLeft();
        assertEquals(rover.direction, Directions.N.des);
    }

    @Test
    public void turnRightN() {
        rover.direction = Directions.N.des;
        rover.turnRight();
        assertEquals(rover.direction, Directions.E.des);
    }

    @Test
    public void turnRightE() {
        rover.direction = Directions.E.des;
        rover.turnRight();
        assertEquals(rover.direction, Directions.S.des);
    }

    @Test
    public void turnRightS() {
        rover.direction = Directions.S.des;
        rover.turnRight();
        assertEquals(rover.direction, Directions.W.des);
    }

    @Test
    public void turnRightW() {
        rover.direction = Directions.W.des;
        rover.turnRight();
        assertEquals(rover.direction, Directions.N.des);
    }
}
