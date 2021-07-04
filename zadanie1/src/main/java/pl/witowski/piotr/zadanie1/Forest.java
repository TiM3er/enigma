package pl.witowski.piotr.zadanie1;

import java.util.LinkedList;
import java.util.List;

public class Forest {

    private List<Tree> trees = new LinkedList<Tree>();

    public List<Tree> getTrees() {
        return trees;
    }

    public void addNewTree(boolean isConifer) {
        trees.add(new Tree(isConifer));
    }

    public void growTree() {
        for (Tree tree : trees) {
            tree.grow();
        }
    }

    public void itsWinterTime() {
        for (Tree tree : trees) {
            if (!tree.isConifer) {
                tree.loseLeaves();
            }
        }
    }

    public void itsAutumnTime() {
        for (Tree tree : trees) {
            if (!tree.isConifer) {
                tree.changeColor();
            }
        }
    }

    public void itsSpringTime() {
        for (Tree tree : trees) {
            if (!tree.isConifer) {
                tree.growLeaves();
            }
        }
    }


}
