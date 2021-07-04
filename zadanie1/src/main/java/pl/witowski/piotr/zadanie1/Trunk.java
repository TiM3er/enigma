package pl.witowski.piotr.zadanie1;

import java.util.LinkedList;
import java.util.List;

public class Trunk {
    private int size;
    private List<Branch> branches = new LinkedList<Branch>();

    public Trunk(int size) {
        this.size = size;
    }

    public void grow() {
        if (size < 25) {
            size++;
        }
        for (Branch branch : branches) {
            branch.grow();
        }
        if (size > 5) {
            branches.add(new Branch());
        }

    }

    public void loseLeaves() {
        for (Branch branch : branches) {
            branch.loseLeaves();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public void changeColor() {
        for (Branch branch : branches) {
            branch.changeColor();
        }
    }

    public void growLeaves() {
        for (Branch branch : branches) {
            branch.growLeaves();
        }
    }

    @Override
    public String toString() {
        return "pl.witowski.piotr.zadanie1.Trunk{" +
                "size=" + size +
                ", branches=" + branches +
                branches.toString() +
                '}';
    }
}
