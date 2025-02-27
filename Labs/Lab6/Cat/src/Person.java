public class Person {
    private String name;
    private int age;

    /** Constructs a Person with a given name and age. */
    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String getName() { return this.name;}

    public void setName(String name) { this.name = name; }

    public int getAge() { return this.age;}

    public void setAge(int age) { this.age = age;}
}
