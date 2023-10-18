package tests.singularNonRelatedTests;

public class userTest {
    public static void main(String[] args) {
        User user1 = new User("random@testing.pl", "abd1234@", 1);
        if (user1.isPatient()) {
            System.out.println(user1 +" jest pacjentem");
        }
    }
}