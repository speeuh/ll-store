package com.ll.store.controller.user;

import com.ll.store.model.user.UserRequestModel;
import com.ll.store.model.user.UserResponseModel;
import com.ll.store.model.user.UserUpdateModel;
import com.ll.store.service.dto.user.UserRequestDto;
import com.ll.store.service.dto.user.UserResponseDto;
import com.ll.store.service.dto.user.UserUpdateDto;
import com.ll.store.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Objects;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseModel> createUser(@RequestBody @Valid UserRequestModel userRequestModel) {

        UserRequestDto userRequestDto = userRequestModel.convertRequestModelToDto();
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        UserResponseModel userResponseModel = userResponseDto.convertResponseDtoToModel();

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseModel);
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseModel>> getAllUsers(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        Page<UserResponseDto> userResponseDto = userService.getAllUsers(pageable);
        return ResponseEntity.ok(userResponseDto.map(UserResponseDto::convertResponseDtoToModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseModel> getById(@PathVariable long id){

        UserResponseDto userResponseDto = userService.getById(id);
        return ResponseEntity.ok(userResponseDto.convertResponseDtoToModel());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable long id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseModel> updateUserById(@RequestBody @Valid UserUpdateModel userUpdateModel, @PathVariable long id, BindingResult result) throws Exception{

        try {
            if(result.hasErrors()){
                throw new IllegalArgumentException(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
            }

            UserUpdateDto userUpdateDto = userUpdateModel.convertUpdateModelToDto();
            UserResponseDto userResponseDto = userService.updateById(userUpdateDto, id);
            UserResponseModel userResponseModel = userResponseDto.convertResponseDtoToModel();

            return new ResponseEntity<>(userResponseModel, HttpStatus.OK);

        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
