package avl;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.*;

@Nested
@DisplayName("Starting with an empty tree")
class AvlTreeTest {

    private AvlTree<Integer> tree;
    private Comparator comparator;

    @BeforeEach
    void setUp() {
        comparator = comparator = Comparator.comparingInt((Integer o) -> o);
        tree = new AvlTree<Integer>(comparator);
    }

    @AfterEach
    public void tearDown() {
        tree = null;
        comparator = null;
    }



    @Test
    @DisplayName("Should be empty when created")
    public void shouldTreeBeEmptyWhenANewTreeIsCreated() {
        assertThat(tree.avlIsEmpty())
                .isTrue();
    }

    @Test
    @DisplayName("Should not be empty when a node is inserted")
    public void shouldTreeNotBeEmptyWhenANodeIsInserted() {
        AvlNode<Integer> node = new AvlNode<Integer>(1);
        tree.insertAvlNode(node);
        assertThat(tree.avlIsEmpty())
                .isFalse();
    }

    @Test
    @DisplayName("Should be empty when a node is inserted and removed")
    public void shouldTreeBeEmptyWhenANodeIsInsertedAndRemoved() {
        tree.insert(1);
        tree.delete(1);
        assertThat(tree.avlIsEmpty())
                .isTrue();
    }

    @Test
    @DisplayName("Inserting a node at the top")
    public void shouldInsertingANodeAtTheTopResultInTheCorrectTree() {
        AvlNode<Integer> node = new AvlNode<Integer>(1);
        tree.insertTop(node);
        String expected = " | 1";

        assertThat(tree.getTop())
                .isEqualTo(node);
        assertThat(tree.avlIsEmpty())
                .isFalse();
        assertThat(tree.height(tree.getTop()))
                .isEqualTo(0);
        assertThat(tree.toString())
                .isEqualTo(expected);
        assertThat(node.isLeaf())
                .isTrue();
    }

    @Nested
    @DisplayName("When a node has already been inserted")
    class nodeInserted{

        @Test
        @DisplayName("Inserting a node left")
        public void shouldInsertingANodeLeftResultInTheCorrectTree() {
            AvlNode<Integer> node = new AvlNode<Integer>(2);
            tree.insertAvlNode(node);

            AvlNode<Integer> left = new AvlNode<Integer>(1);
            tree.insertAvlNode(left);

            assertThat(node.hasOnlyALeftChild())
                    .isTrue();
            assertThat(node.hasOnlyARightChild())
                    .isFalse();
            assertThat(node.isLeaf())
                    .isFalse();
        }

        @Test
        @DisplayName("Inserting a node right")
        public void shouldInsertingANodeRightResultInTheCorrectTree() {
            AvlNode<Integer> node = new AvlNode<Integer>(2);
            tree.insertAvlNode(node);

            AvlNode<Integer> right = new AvlNode<Integer>(3);
            tree.insertAvlNode(right);

            assertThat(node.hasOnlyARightChild())
                    .isTrue();
            assertThat(node.isLeaf())
                    .isFalse();
        }

        @Test
        @DisplayName("Inserting nodes left and right of the root")
        public void shouldSearchFunctionsReturnTheCorrectValuesWhenTryingToInsertNodesLeftAndRightOfTheRoot() {
            AvlNode<Integer> node = new AvlNode<Integer>(2);
            tree.insertAvlNode(node);

            AvlNode<Integer> left = new AvlNode<Integer>(1);
            AvlNode<Integer> right = new AvlNode<Integer>(3);

            //Check Equilibrium Factor before insertion
            assertThat(tree.searchClosestNode(left))
                    .isEqualTo(-1);
            assertThat(tree.searchClosestNode(right))
                    .isEqualTo(1);
            assertThat(tree.searchClosestNode(node))
                    .isEqualTo(0);
        }

        @Test
        @DisplayName("Inserting nodes left and right of the root results in the correct tree")
        public void shouldInsertingNodesLeftAndRightOfTheRootResultInTheCorrectTree() {
            AvlNode<Integer> node = new AvlNode<Integer>(2);
            tree.insertAvlNode(node);

            AvlNode<Integer> left = new AvlNode<Integer>(1);
            AvlNode<Integer> right = new AvlNode<Integer>(3);

            tree.insertAvlNode(left);
            tree.insertAvlNode(right);

            String expected = " | 2 | 1 | 3";

            assertThat(tree.getTop())
                    .isEqualTo(node);
            assertThat(tree.avlIsEmpty())
                    .isFalse();
            assertThat(tree.height(tree.getTop()))
                    .isEqualTo(1);
            assertThat(tree.toString())
                    .isEqualTo(expected);

            assertThat(node.hasLeft()).isTrue();
            assertThat(node.hasRight()).isTrue();
            assertThat(node.getLeft()).isEqualTo(left);
            assertThat(node.getRight()).isEqualTo(right);
        }

    }
}