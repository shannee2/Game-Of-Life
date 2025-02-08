import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.swiggy.ConsoleMessages;
import org.swiggy.GameRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameRunnerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testRunWithValidInput() {
        String input = "5\n5\n50\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        GameRunner.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains(ConsoleMessages.GRID_ROW_INPUT.getRepresentation()));
        assertTrue(output.contains(ConsoleMessages.GRID_COLUMN_INPUT.getRepresentation()));
        assertTrue(output.contains(ConsoleMessages.SEED_PERCENTAGE_INPUT.getRepresentation()));
    }

    @Test
    public void testRunWithInvalidSeedPercentage() {
        String input = "5\n5\n150\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        GameRunner.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains(ConsoleMessages.INVALID_SEED_PERCENTAGE_ERROR.getRepresentation()));
    }

    @Test
    public void testRunWithInvalidGridSize() {
        String input = "-1\n5\n50\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        GameRunner.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains(ConsoleMessages.INVALID_GRID_SIZE_ERROR.getRepresentation()));
    }
}