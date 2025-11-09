package interview.hash;

public class User {
    private String email;


    private String name;
    private Integer creditScore;

    public User(String email, String name, Integer creditScore) {
        this.email = email;
        this.name = name;
        this.creditScore = creditScore;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", creditScore=" + creditScore +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public int hashCode() {
        System.out.println(email.hashCode());
        return email.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("in equals");
        if(this==obj) return true;
        if(obj==null||getClass()!=obj.getClass()) return false;
        return email.equals(((User) obj).getEmail());

    }
}
