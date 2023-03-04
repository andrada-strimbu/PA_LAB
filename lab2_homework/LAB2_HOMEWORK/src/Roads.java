public class Roads {
    /**
     * clasa Location implementeaza datele unui drum
     * @param obj= obiect de tip drum
     * functia booleana equals care verifica daca drumul este deja in array
     */
    private float length;

    private Locations a;
    private Locations b;

    public Roads( Locations a, Locations b) {
        this.a = a;
        this.b = b;
        this.length = (float) Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY()) * (b.getY() - a.getY()));
    }
    public float getLength() {

        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Roads)) {
            return false;
        }
        Roads o = (Roads) obj;
        return a.equals(o.a) && b.equals(o.b);
    }
    public Locations getA() {
        return a;
    }

    public Locations getB() {
        return b;
    }
}