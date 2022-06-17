package com.ll.store.model.user;

import com.ll.store.service.dto.user.UserRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UserRequestModel {

    @NotNull @NotBlank
    private String userName;

    @NotNull @NotBlank @Email
    private String email;

    @NotNull @NotBlank
    private String password;

    public UserRequestDto convertRequestModelToDto() {
        return new UserRequestDto(userName, email, password);
    }
}
