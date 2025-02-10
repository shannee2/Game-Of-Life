import org.junit.jupiter.api.Test;
import org.swiggy.GameOfLife;
import org.swiggy.exceptions.InvalidGridSizeException;
import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {
    @Test
    public void testThrowException_WhenInitializedWithNegativeRows() {
        assertThrows(InvalidGridSizeException.class, () -> new GameOfLife(-1, 1,10));
    }

    @Test
    public void testThrowException_WhenInitializedWithNegativeCols() {
        assertThrows(InvalidGridSizeException.class, () -> new GameOfLife(1, -1,10));
    }

    @Test
    public void testGameLogicCreation() {
        assertDoesNotThrow(()->new GameOfLife(1,1,10));
    }
}