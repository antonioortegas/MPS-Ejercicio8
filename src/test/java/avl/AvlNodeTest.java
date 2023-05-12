package avl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class AvlNodeTest {

    private AvlNode<Integer> node;

    @BeforeEach
    void setUp() {
        node = new AvlNode<Integer>(5);
    }

    @AfterEach
    public void tearDown() {
        node = null;
    }

}