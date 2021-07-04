package pl.witowski.piotr.zadanie1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ForestTest {
    Forest forest;

    @Before
    public void initForest() {
        forest = new Forest();
    }

    @Test
    public void testCreateTree() {
        forest.addNewTree(false);
        Assert.assertFalse(forest.getTrees().isEmpty());
    }

    @Test
    public void testAddspecificTree() {
        forest.addNewTree(false);
        Assert.assertFalse(forest.getTrees().isEmpty());
        Assert.assertFalse(forest.getTrees().get(0).isConifer());
        forest.getTrees().clear();
        Assert.assertTrue(forest.getTrees().isEmpty());
        forest.addNewTree(true);
        Assert.assertTrue(forest.getTrees().get(0).isConifer());
    }

    @Test
    public void growTree() {
        forest.addNewTree(false);
        int size = forest.getTrees().get(0).getTrunk().getSize();
        forest.growTree();
        Assert.assertNotEquals(size, forest.getTrees().get(0).getTrunk().getSize());
    }

    @Test
    public void growLeaves() {
        forest.addNewTree(false);
        for (int i = 0; i < 6; i++) {
            forest.growTree();
        }
        Assert.assertFalse(forest.getTrees().get(0).getTrunk().getBranches().get(0).getLeaves().isEmpty());
    }

    @Test
    public void testingOfTheSeasons() {
        forest.addNewTree(false);
        for (int i = 0; i < 6; i++) {
            forest.growTree();
        }
        Assert.assertFalse(forest.getTrees().get(0).getTrunk().getBranches().get(0).getLeaves().isEmpty());
        Assert.assertEquals(0, forest.getTrees().get(0).getTrunk().getBranches().get(0).getLeaves().get(0).getColor());
        forest.itsAutumnTime();
        Assert.assertEquals(1, forest.getTrees().get(0).getTrunk().getBranches().get(0).getLeaves().get(0).getColor());
        forest.itsWinterTime();
        Assert.assertTrue( forest.getTrees().get(0).getTrunk().getBranches().get(0).getLeaves().isEmpty());

    }
}
