
public class Programmer extends Person implements Comparable<Person> {
    private String programmingLanguage;

    public Programmer(int id, String birthDate, String name, String programmingLanguage) {
        super(id, birthDate, name);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public int compareTo(Person o) {
        return super.compareTo(o);
    }
}
