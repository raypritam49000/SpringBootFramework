package com.validation.springvalidation.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginData {
    @NotBlank(message = "UserName can not be null !!")
    @Size(min = 3,max = 12,message = "Userame must be between 3-12 character !!!")
    private String userName;

    @NotBlank(message = "Email can not be null !!")
    @Pattern(regexp ="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message ="Invalid Email !!!" )
    //@Email(regexp ="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message ="Invalid Email !!!" )
    private String email;
    
    @AssertTrue(message = "Must agree terms and conditions !!")
    private boolean agreed;

    public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
