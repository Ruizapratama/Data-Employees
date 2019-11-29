//package com.Employee.DataEmployee.controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.validation.Valid;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Employee.DataEmployee.model.User;
//import com.Employee.DataEmployee.repository.UserRepository;
//
//import Model_DTO.UserDTO;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//	
//	@Autowired
//	UserRepository userRepository;
//	ModelMapper modelMapper = new ModelMapper();
//	
//	//Get DTO
//	@GetMapping("/get_userDTO")
//	public Map<String, Object> getAllUserDTO() {
//		List<User> listUserEntity = userRepository.findAll();
//		
//		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
//		
//		Map<String, Object> result = new HashMap<String, Object>();
//		
//		for (User userEntity : listUserEntity) {
//			UserDTO userDTO = new UserDTO();		
//		
//			userDTO = modelMapper.map(userEntity, UserDTO.class);
//			
//			listUserDTO.add(userDTO);
//		}
//		
//		result.put("Status", 200);
//    	result.put("message", "Read All Data User Success");
//    	
//    	result.put("Data", listUserDTO);
//    	
//    	return result;
//	}
//	
//	//Create 
//    @PostMapping("/create_userDTO")
//    public Map<String, Object> createUserDTO(@Valid @RequestBody UserDTO userDTO) {
//    	
//    	Map<String, Object> result = new HashMap<String, Object>();
//    	
//    	User userEntity = new User();
//    	
//		userEntity = modelMapper.map(userDTO, User.class);
//    	
//		userRepository.save(userEntity);
//		
//    	result.put("Status", 200);
//        result.put("message", "Create New User Data Success");
//        result.put("Data", userDTO);
//        
//		return result;
//    	
//    }
//    
// // Get a Single 
//    @GetMapping("/get_single_userDTO/{id}")
//    public Map<String, Object> getUserDTOById(@PathVariable(value = "id") Long userId){
//		
//    	Map<String, Object> result = new HashMap<String,Object>();
//    	User userEntity = userRepository.findById(userId).get();
//    	UserDTO userDTO = new UserDTO();
//    	
//		userDTO = modelMapper.map(userEntity, UserDTO.class);
//    	
//    	result.put("Status", 200);
//        result.put("message", "Read The Specific User Data Success");
//        result.put("Data", userDTO);
//
//        return result;
//    }
//    
//    // Update
//    @PutMapping("/update_userDTO/{id}")
//    public Map<String, Object> updateUserDTO(@PathVariable(value = "id") Long userId,
//            @Valid @RequestBody UserDTO userDTO) {
//			
//    	Map<String, Object> result = new HashMap<String,Object>();
//    	User userEntity = userRepository.findById(userId).get();
//    	
//		userEntity = modelMapper.map(userDTO, User.class);
//
//        userRepository.save(userEntity);
//    	
//    	result.put("Status", 200);
//        result.put("message", "Update User Data Success");
//        result.put("Data", userDTO);
//        
//    	return result;
//    }
//    
//    //Delete
//    @DeleteMapping("/delete_userDTO/{id}")
//    public Map<String, Object> deleteUserDTO(@PathVariable(value = "id") Long userId,
//            @Valid @RequestBody UserDTO userDTO) {
//    	
//    	Map<String, Object> result = new HashMap<String,Object>();
//    	User userEntity = userRepository.findById(userId).get();    	
//    	userRepository.delete(userEntity);
//    	
//    	result.put("Status", 200);
//        result.put("message", "Delete Data User Success");
//        result.put("Data", userDTO);
//        
//    	return result;
//    }
//}
