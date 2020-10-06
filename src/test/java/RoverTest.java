import static org.junit.Assert.*;

import Rover_Exercise.CommandBuffer;
import Rover_Exercise.Commands;
import Rover_Exercise.Directions;
import Rover_Exercise.Rover;
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
        CommandBuffer commandBuffer = new CommandBuffer(new ArrayList<>());
        assertEquals(0, commandBuffer.commands.size());
    }

    @Test
    public void singleCommandBuffer() {
        CommandBuffer commandBuffer = new CommandBuffer(new ArrayList<>(Collections.singletonList(Commands.B.des)));
        assertEquals(1, commandBuffer.commands.size());
    }

    @Test
    public void twoCommandBuffer() {
        CommandBuffer commandBuffer = new CommandBuffer(new ArrayList<>(Arrays.asList(Commands.B.des, Commands.B.des)));
        assertEquals(2, commandBuffer.commands.size());
    }

    @Test
    public void moveRight() {
        rover.position.x = rover.MIN_X;
        rover.moveRight();
        assertEquals(rover.position.x, rover.MIN_X + 1, 0.0);
    }

    @Test
    public void capRight() {
        rover.position.x = rover.MAX_X + 1;
        rover.moveRight();
        assertEquals(rover.position.x, rover.MAX_X, 0.0);
    }

    @Test
    public void capNoRight() {
        rover.position.x = rover.MIN_X;
        rover.moveRight();
        assertNotEquals(rover.position.x, rover.MAX_X, 0.0);
    }

    @Test
    public void moveUp() {
        rover.position.y = rover.MIN_Y;
        rover.moveUp();
        assertEquals(rover.position.y, rover.MIN_Y + 1, 0.0);
    }


    @Test
    public void capUp() {
        rover.position.y = rover.MAX_Y + 1;
        rover.moveUp();
        assertEquals(rover.position.y, rover.MAX_Y, 0.0);
    }

    @Test
    public void capNoUp() {
        rover.position.y = rover.MIN_Y;
        rover.moveUp();
        assertNotEquals(rover.position.y, rover.MAX_Y, 0.0);
    }

    @Test
    public void moveLeft() {
        rover.position.x = rover.MAX_X;
        rover.moveLeft();
        assertEquals(rover.position.x, rover.MAX_X - 1, 0.0);
    }

    @Test
    public void capLeft() {
        rover.position.x = rover.MIN_X - 1;
        rover.moveLeft();
        assertEquals(rover.position.x, rover.MIN_X, 0.0);
    }

    @Test
    public void capNoLeft() {
        rover.position.x = rover.MAX_X;
        rover.moveLeft();
        assertNotEquals(rover.position.x, rover.MIN_X, 0.0);
    }

    @Test
    public void moveDown() {
        rover.position.y = rover.MAX_Y;
        rover.moveDown();
        assertEquals(rover.position.y, rover.MAX_Y - 1, 0.0);
    }

    @Test
    public void capDown() {
        rover.position.y = rover.MIN_Y - 1;
        rover.moveDown();
        assertEquals(rover.position.y, rover.MIN_Y, 0.0);
    }

    @Test
    public void capNoDown() {
        rover.position.y = rover.MAX_Y;
        rover.moveDown();
        assertNotEquals(rover.position.y, rover.MIN_Y, 0.0);
    }

    @Test
    public void forwardX_when_N_direction() {
        rover.commandBuffer = new CommandBuffer(new ArrayList<>(Arrays.asList(Commands.B.des, Commands.B.des)));
        rover.addCommand(Commands.F.des, Directions.N.des);
        assertEquals((char) rover.commandBuffer.commands.get(rover.commandBuffer.commands.size() - 1), Commands.F.des);
    }

    @Test
    public void forwardX_when_E_direction() {
        rover.commandBuffer = new CommandBuffer(new ArrayList<>(Arrays.asList(Commands.B.des, Commands.B.des)));
        rover.addCommand(Commands.F.des, Directions.E.des);
        assertEquals((char) rover.commandBuffer.commands.get(rover.commandBuffer.commands.size() - 1), Commands.F.des);
    }

    @Test
    public void backwardX_when_S_direction() {
        rover.commandBuffer = new CommandBuffer(new ArrayList<>(Arrays.asList(Commands.B.des, Commands.F.des)));
        rover.addCommand(Commands.F.des, Directions.S.des);
        assertEquals((char) rover.commandBuffer.commands.get(rover.commandBuffer.commands.size() - 1), Commands.B.des);
    }

    @Test
    public void backwardX_when_W_direction() {
        rover.commandBuffer = new CommandBuffer(new ArrayList<>(Arrays.asList(Commands.B.des, Commands.F.des)));
        rover.addCommand(Commands.F.des, Directions.W.des);
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
