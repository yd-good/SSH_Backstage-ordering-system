/*
信息:
*/
package role.com.entity;

public class Role {
    private String role_Id;
    private String role_Name;
    private String role_right;

    public Role() {
    }

    public Role(String role_Id) {
        this.role_Id = role_Id;
    }

    public String getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(String role_Id) {
        this.role_Id = role_Id;
    }

    public String getRole_Name() {
        return role_Name;
    }

    public void setRole_Name(String role_Name) {
        this.role_Name = role_Name;
    }

    public String getRole_right() {
        return role_right;
    }

    public void setRole_right(String role_right) {
        this.role_right = role_right;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_Id='" + role_Id + '\'' +
                ", role_Name='" + role_Name + '\'' +
                ", role_right='" + role_right + '\'' +
                '}';
    }
}
