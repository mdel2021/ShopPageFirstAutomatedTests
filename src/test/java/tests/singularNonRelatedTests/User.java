package tests.singularNonRelatedTests;

public class User {
    private String login;
    private String password;
    private int roleId;

    public User(String login, String password, int roleId) {
        this.login = login;
        this.password = password;
        this.roleId = roleId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public boolean isPatient() {
        return roleId == 1;
    }

    public boolean isDoctor() {
        return roleId == 2;
    }

    @Override
    public String toString() {
        return "Użytkownik "+login;
    }
}
