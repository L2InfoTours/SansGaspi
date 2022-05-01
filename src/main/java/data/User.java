package data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
	private Long id;

	private String username;
	private String email;
	private String password;
	
	private Set<Role> roles;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
	public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    @ManyToMany
    @JoinTable(name = "user_role", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    private String confirmPassWord;
    
	public String getPasswordConfirm() {
		return confirmPassWord;
	}
	public void setPasswordConfirm(String password) {
		confirmPassWord = password;
	}
}
