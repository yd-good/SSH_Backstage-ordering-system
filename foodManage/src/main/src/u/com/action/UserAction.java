/*
信息:
*/
package u.com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import role.com.entity.Role;
import role.com.service.RoleService;
import u.com.entity.User;
import u.com.entity.UserRole;
import u.com.service.UserService;
import yd.com.core.utils.SendEmail;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAction extends ActionSupport implements ModelDriven<User>{
    private User user =new User();
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    public String login(){
            if (user!=null&&StringUtils.isNotBlank(user.getEmail())){
                User user1=userService.findByEmailAndPassWord(user);
                userRoles=userService.findUserRoleAll();
                if (user1!=null){
                    for (UserRole userRole:userRoles){
                        if (user1.getId().equals(userRole.getUserRoleId().getUser_Id())){
                            role=userRole.getUserRoleId().getRole();
                        }
                    }
                    ServletActionContext.getRequest().getSession().setAttribute("admin",user1);
                    ServletActionContext.getRequest().getSession().setAttribute("admin_role",role);
                    return "success";
                }
            }
      return "login";
    }
    public String inRegister(){
        roles=roleService.findAll();
        return "inRegister";
    }
    public String register() {
        if (roleIds != null) {

       if (user!=null&&StringUtils.isNotBlank(user.getEmail())){
           if (!StringUtils.isNotBlank(user.getPassWord())){
               user.setPassWord("123456");
           }
           userService.saveUserAndRole(user,roleIds);
       }
        }
        return userList();
    }
    public String searchEmail(){
        if (user!=null){
           users=userService.findByEmail(user.getEmail());
           if (users.size()>0&&users!=null){
               System.out.println(users.get(0));
               SendEmail.sendEmail(users.get(0));
           }
        }
        return login();
    }
    public String exit_system(){
        ServletActionContext.getRequest().getSession().removeAttribute("admin_role");
        ServletActionContext.getRequest().getSession().removeAttribute("admin");
        return "login";
    }
    //邮箱的唯一校验
    public void verifyAccount(){
        try {
            //1.获取账号
            if (user!=null&& StringUtils.isNotBlank(user.getEmail())){//使用字符串工具类
                //2.根据账号到数据库中校验是否存在该账号对应的用户
                String strResult="false";
                List<User> list= userService.findByEmail(user.getEmail());
                if (list!=null&&list.size()>0){
                    //该账号已经存在
                    strResult="true";
                }
//         通过ServletActionContext获取Response
                HttpServletResponse response= ServletActionContext.getResponse();
//         设置输出到页面的内容类型
                response.setContentType("text/html");
                //获取输出流
                OutputStream outputStream=response.getOutputStream();
                //将内容写到输出流中
                outputStream.write(strResult.getBytes());
                //关闭输出流
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String userList(){
       userRoles=userService.findUserRoleAll();
       for (UserRole userRole:userRoles){
           user=userService.findById(userRole.getUserRoleId().getUser_Id());
           role=userRole.getUserRoleId().getRole();
           maps.put(user,role);
       }
        return "userList";
    }

    public User getUser() {
        return user;
    }
    public List<User> users;
    public Role role;
    public List<Role> roles;
    public String roleIds;
    public List<UserRole> userRoles;
    public  Map<Object,Object> maps=new HashMap<Object, Object>();
    public String getRoleIds() {
        return roleIds;
    }
    public Map<Object, Object> getMaps() {
        return maps;
    }
    public void setMaps(Map<Object, Object> maps) {
        this.maps = maps;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public User getModel() {
        return user;
    }

}
