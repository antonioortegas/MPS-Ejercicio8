package avl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class NewAvlNodeTest {

    private NewAvlNode<Integer> node;

    @BeforeEach
    void setUp() {
        node = new NewAvlNode<Integer>(5);
    }

    @AfterEach
    public void tearDown() {
        node = null;
    }

}