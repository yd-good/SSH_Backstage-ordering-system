/*
信息:
*/
package u.com.entity;

public class UserRole {
    private UserRoleId userRoleId;

    public UserRole(UserRoleId userRoleId) {
        this.userRoleId = userRoleId;
    }

    public UserRole() {
    }

    public UserRoleId getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(UserRoleId userRoleId) {
        this.userRoleId = userRoleId;
    }
}
