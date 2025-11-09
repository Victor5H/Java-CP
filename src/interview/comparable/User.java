package interview.comparable;

public class User implements Comparable<User> {
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
    public int compareTo(User user) {
        return this.getEmail().compareTo(user.getEmail());
    }
}
