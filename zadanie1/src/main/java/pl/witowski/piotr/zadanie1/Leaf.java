package pl.witowski.piotr.zadanie1;

public class Leaf {
    private int size;
    private int color;//0-> green , 1-> brown

    public Leaf(int size, int color) {
        this.size = size;
        this.color = color;
    }

    public void grow() {
        if (size < 3) {
            size++;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "pl.witowski.piotr.zadanie1.Leaf{" +
                "size=" + size +
                ", color=" + color +
                '}';
    }
}
