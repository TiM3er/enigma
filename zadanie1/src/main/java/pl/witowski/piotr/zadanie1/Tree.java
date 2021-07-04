package pl.witowski.piotr.zadanie1;

public class Tree {
    private Trunk trunk;

    boolean isConifer;

    public Tree(boolean isConifer) {
        this.trunk = new Trunk(1);
        this.isConifer = isConifer;
    }

    public void loseLeaves() {
        trunk.loseLeaves();
    }

    public void growLeaves() {
        trunk.growLeaves();
    }

    public void changeColor() {
        trunk.changeColor();
    }

    public Trunk getTrunk() {
        return trunk;
    }

    public void setTrunk(Trunk trunk) {
        this.trunk = trunk;
    }

    public void grow() {
        trunk.grow();
    }

    public boolean isConifer() {
        return isConifer;
    }

    public void setConifer(boolean conifer) {
        isConifer = conifer;
    }

    @Override
    public String toString() {
        return "pl.witowski.piotr.zadanie1.Tree{" +
                "trunk=" + trunk +
                trunk.toString() +
                ", isConifer=" + isConifer +
                '}';
    }
}
