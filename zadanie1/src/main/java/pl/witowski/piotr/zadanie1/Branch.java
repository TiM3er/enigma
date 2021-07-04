package pl.witowski.piotr.zadanie1;

import java.util.LinkedList;
import java.util.List;

public class Branch {
    private int size;

    private List<Leaf> leaves;


    public Branch() {
        this.size = 0;
        this.leaves = new LinkedList<Leaf>();
    }

    public void grow() {
        if (size < 10) {
            size++;
        }
        if (size > 0) {
            leaves.add(new Leaf(1, 0));
        }
        for (Leaf leaf : leaves) {
            leaf.grow();
        }
    }

    public void loseLeaves() {
        leaves.clear();
    }

    public void changeColor() {
        for (Leaf leaf : leaves) {
            if (leaf.getColor() == 1) {
                leaf.setColor(0);
            } else {
                leaf.setColor(1);
            }
        }
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Leaf> getBranches() {
        return leaves;
    }

    public void setBranches(List<Leaf> branches) {
        this.leaves = branches;
    }


    public void growLeaves() {
        if (leaves.isEmpty())
            for (int i = 0; i < size * 5; i++) {
                leaves.add(new Leaf(1, 0));
            }
    }

    @Override
    public String toString() {
        return "pl.witowski.piotr.zadanie1.Branch{" +
                "size=" + size +
                ", leaves=" + leaves +
                ", leavesSize=" + leaves.size() +
                '}';
    }

    public List<Leaf> getLeaves() {
        return leaves;
    }
}
