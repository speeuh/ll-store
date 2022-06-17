package com.ll.store.service.user;

import com.ll.store.config.validation.exceptions.UserNotFoundException;
import com.ll.store.repository.entity.user.User;
import com.ll.store.repository.user.UserRepository;
import com.ll.store.service.dto.user.UserRequestDto;
import com.ll.store.service.dto.user.UserResponseDto;
import com.ll.store.service.dto.user.UserUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto userRequestDto){

        User user = userRequestDto.convertRequestDtoToEntity();
        User userResponse = userRepository.save(user);

        return userResponse.convertEntityToResponseDto();
    }

    public Page<UserResponseDto> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(User::convertEntityToResponseDto);
    }

    public UserResponseDto getById(long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Not found user with id " + id));
        return user.convertEntityToResponseDto();
    }

    public void deleteById(long id){
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new UserNotFoundException("Not found user with id " + id);
        }
    }

    public UserResponseDto updateById(UserUpdateDto userUpdateDto, long id){

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Not found user with id " + id));

        if(userUpdateDto.getPassword() != null){
            user.setPassword(userUpdateDto.getPassword());
        }

        User userResponse = userRepository.save(user);
        return userResponse.convertEntityToResponseDto();
    }

}
