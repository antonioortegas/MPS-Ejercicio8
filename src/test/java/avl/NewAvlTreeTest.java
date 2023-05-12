package avl;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

class NewAvlTreeTest {

    private NewAvlTree<Integer> tree;
    private Comparator comparator;

    @BeforeEach
    void setUp() {
        comparator = comparator = Comparator.comparingInt((Integer o) -> o);
        tree = new NewAvlTree<Integer>(comparator);
    }

    @AfterEach
    public void tearDown() {
        tree = null;
        comparator = null;
    }

    @Test
    @DisplayName("Should be empty when created")
    public void shouldTreeBeEmpty() {
        assertThat(tree.avlIsEmpty())
                .isTrue();
    }

    @Test
    @DisplayName("Should inserting the three 8, 9, 10, 2, 1, 5, 3, 6, 7, 11, 12 result in a valid tree")
    public void shouldInsertingTheThree8_9_10_2_1_5_3_6_7_11_12ResultInTheCorrectTree() {
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(3);
        tree.insert(6);
        tree.insert(7);
        tree.insert(11);
        tree.insert(12);

        assertThat(tree.avlIsEmpty())
                .isFalse();
        assertThat(tree.getTop().getItem())
                .isEqualTo(8);

    }
}