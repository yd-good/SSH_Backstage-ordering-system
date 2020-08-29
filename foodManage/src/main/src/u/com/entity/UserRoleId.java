/*
信息:
*/
package u.com.entity;

import role.com.entity.Role;

import java.io.Serializable;
import java.util.Objects;
//必须实现serializable接口和重写equals和hashCode方法
public class UserRoleId implements Serializable {
    private Role role;
    private String user_Id;

    public UserRoleId() {
    }

    public UserRoleId(Role role, String user_Id) {
        this.role = role;
        this.user_Id = user_Id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoleId)) return false;
        UserRoleId that = (UserRoleId) o;
        return Objects.equals(getRole(), that.getRole()) &&
                Objects.equals(getUser_Id(), that.getUser_Id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRole(), getUser_Id());
    }
}
