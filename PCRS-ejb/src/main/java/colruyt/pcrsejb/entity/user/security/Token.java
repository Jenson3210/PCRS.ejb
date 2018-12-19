package colruyt.pcrsejb.entity.user.security;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import colruyt.pcrsejb.entity.user.User;

@Entity
public class Token {

	@Id
	private String token;
	
	private LocalDate TimeActive;
	private User user;
	
	
	
	public Token(String token, LocalDate timeActive, User user) {
		super();
		this.token = token;
		TimeActive = timeActive;
		this.user = user;
	}
	
	
	public Token() {
		
	}


	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LocalDate getTimeActive() {
		return TimeActive;
	}
	public void setTimeActive(LocalDate timeActive) {
		TimeActive = timeActive;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
	
	
}
