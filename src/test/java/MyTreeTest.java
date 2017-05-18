import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyTreeTest {
    private MyTree myTree;

    @Before
    public void setUp() throws Exception {
        myTree = new MyTree();
    }

    @Test
    public void testAddDuplicate() throws Exception {
        assertTrue(myTree.add("AAA"));
        assertFalse(myTree.add("AAA"));
    }

    @Test
    public void testAddTrueSize() throws Exception {
        myTree.add("ADh");
        assertEquals(1, myTree.getSize());
        myTree.add("AD5");
        assertEquals(2, myTree.getSize());
    }

    @Test
    public void testAddNull() throws Exception {
        assertTrue(myTree.add(null));

    }

    @Test
    public void testAddManyElements() throws Exception {
        for (int i = 0; i < 15000000; i++) {
            assertTrue(myTree.add(String.valueOf(i)));
        }
        assertTrue(myTree.getSize() == 10000);

    }

    @Test
    public void testContainsAfterAddAManyElements() throws Exception {
        for (int i = 0; i < 15000000; i++) {
            assertTrue(myTree.add(String.valueOf(i)));
        }
        assertTrue(myTree.contains("8916"));
    }

    @Test
    public void testContainsAfterAddOneElement() throws Exception {
        myTree.add("Gof");
        assertTrue(myTree.contains("Gof"));
    }

    @Test
    public void testDeleteDuplicate() throws Exception {
        for (int i = 0; i < 15; i++) {
            myTree.add(String.valueOf(i));
        }
        assertTrue(myTree.delete("0"));
        assertFalse(myTree.delete("0"));
    }

    @Test
    public void testDeleteIfNotContains() throws Exception {
        for (int i = 0; i < 15; i++) {
            myTree.add(String.valueOf(i));
        }
        assertFalse(myTree.contains("18"));
        assertFalse(myTree.delete("18"));

    }

    @Test
    public void testToArray() throws Exception {
        for (int i = 0; i < 15; i++) {
            myTree.add(String.valueOf(i));
        }
        String[] elements = myTree.toArray();
        assertTrue(elements.length == myTree.getSize());
    }
}
