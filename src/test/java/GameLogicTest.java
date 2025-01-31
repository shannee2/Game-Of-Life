import org.junit.jupiter.api.Test;
import org.swiggy.GameLogic;
import org.swiggy.exceptions.InvalidGridSizeException;
import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {
    @Test
    public void testThrowException_WhenInitializedWithNegativeRows() {
        assertThrows(InvalidGridSizeException.class, () -> new GameLogic(-1, 1,10));
    }

    @Test
    public void testThrowException_WhenInitializedWithNegativeCols() {
        assertThrows(InvalidGridSizeException.class, () -> new GameLogic(1, -1,10));
    }

    @Test
    public void testGameLogicCreation() {
        assertDoesNotThrow(()->new GameLogic(1,1,10));
    }
}