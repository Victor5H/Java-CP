package javaTopics.collections;

public class ComparablePerson implements Comparable<ComparablePerson> {
    private String name;
    private int id;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public ComparablePerson(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(ComparablePerson o) {
        int tid= this.id;
        int oid = o.getId();
        if(tid-oid<0) return -1;
        else if (tid-oid>0) return 1;
        else  return this.getName().compareTo(o.getName());
    }
}
