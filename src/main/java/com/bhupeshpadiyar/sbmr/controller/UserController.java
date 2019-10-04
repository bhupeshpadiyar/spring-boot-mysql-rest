package com.bhupeshpadiyar.sbmr.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhupeshpadiyar.sbmr.exceptions.UserNotFoundException;
import com.bhupeshpadiyar.sbmr.repositories.UserRepository;
import com.bhupeshpadiyar.sbmr.models.User;

/**
 * @author Bhupesh Singh Padiyar
 *
 */

@RestController
@RequestMapping("/api")
public class UserController {
	
	  @Autowired
	  private UserRepository userRepository;
	  /**
	   * Get all users list.
	   *
	   * @return the list
	   */
	  @GetMapping("/users")
	  public List<User> getAllUsers() {
	    return userRepository.findAll();
	  }
	  /**
	   * Gets users by id.
	   *
	   * @param userId the user id
	   * @return the users by id
	   * @throws UserNotFoundException the user not found exception
	   */
	  @GetMapping("/users/{id}")
	  public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
	      throws UserNotFoundException {
	    User user =
	        userRepository
	            .findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found on :: " + userId));
	    return ResponseEntity.ok().body(user);
	  }
	  /**
	   * Create user user.
	   *
	   * @param user the user
	   * @return the user
	   */
	  @PostMapping("/user")
	  public User createUser(@Valid @RequestBody User user) {
		
	    return userRepository.save(user);
	  }
	  /**
	   * Update user response entity.
	   *
	   * @param userId the user id
	   * @param userDetails the user details
	   * @return the response entity
	   * @throws UserNotFoundException the user not found exception
	   */
	  @PutMapping("/user/{id}")
	  public ResponseEntity<User> updateUser(
	      @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
	      throws UserNotFoundException {
		  User user =
	        userRepository
	            .findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found on :: " + userId));
	    user.setEmail(userDetails.getEmail());
	    user.setLastName(userDetails.getLastName());
	    user.setFirstName(userDetails.getFirstName());
	    user.setUpdatedOn(new Date());
	    final User updatedUser = userRepository.save(user);
	    return ResponseEntity.ok(updatedUser);
	  }
	  /**
	   * Delete user map.
	   *
	   * @param userId the user id
	   * @return the map
	   * @throws Exception the exception
	   */
	  @DeleteMapping("/user/{id}")
	  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
		  User user =
	        userRepository
	            .findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found on :: " + userId));
	    userRepository.delete(user);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }
}

