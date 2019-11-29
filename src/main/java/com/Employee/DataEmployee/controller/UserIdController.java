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
//import com.Employee.DataEmployee.model.UserId;
//import com.Employee.DataEmployee.repository.UserIdRepository;
//
//import Model_DTO.UserIdDTO;
//
//@RestController
//@RequestMapping("/userId")
//public class UserIdController {
//	
//	@Autowired
//	UserIdRepository userIdRepository;
//	ModelMapper modelMapper = new ModelMapper();
//	
//	//Get DTO
//	@GetMapping("/get_userIdDTO")
//	public Map<String, Object> getAllUserIdDTO() {
//		List<UserId> listUserIdEntity = userIdRepository.findAll();
//		
//		List<UserIdDTO> listUserIdDTO = new ArrayList<UserIdDTO>();
//		
//		Map<String, Object> result = new HashMap<String, Object>();
//		
//		for (UserId userIdEntity : listUserIdEntity) {
//			UserIdDTO userIdDTO = new UserIdDTO();		
//		
//			userIdDTO = modelMapper.map(userIdEntity, UserIdDTO.class);
//			
//			listUserIdDTO.add(userIdDTO);
//		}
//		
//		result.put("Status", 200);
//    	result.put("message", "Read All Data User Success");
//    	
//    	result.put("Data", listUserIdDTO);
//    	
//    	return result;
//	}
//	
//	//Create 
//    @PostMapping("/create_userIdDTO")
//    public Map<String, Object> createUserIdDTO(@Valid @RequestBody UserIdDTO userIdDTO) {
//    	
//    	Map<String, Object> result = new HashMap<String, Object>();
//    	
//    	UserId userIdEntity = new UserId();
//    	
//		userIdEntity = modelMapper.map(userIdDTO, UserId.class);
//    	
//		userIdRepository.save(userIdEntity);
//		
//    	result.put("Status", 200);
//        result.put("message", "Create New User Data Success");
//        result.put("Data", userIdDTO);
//        
//		return result;
//    	
//    }
//    
// // Get a Single 
//    @GetMapping("/get_single_userIdDTO/{id}")
//    public Map<String, Object> getUserIdDTOById(@PathVariable(value = "id") Long userIdId){
//		
//    	Map<String, Object> result = new HashMap<String,Object>();
//    	UserId userIdEntity = userIdRepository.findById(userIdId).get();
//    	UserIdDTO userIdDTO = new UserIdDTO();
//    	
//		userIdDTO = modelMapper.map(userIdEntity, UserIdDTO.class);
//    	
//    	result.put("Status", 200);
//        result.put("message", "Read The Specific User Data Success");
//        result.put("Data", userIdDTO);
//
//        return result;
//    }
//    
//    // Update
//    @PutMapping("/update_userIdDTO/{id}")
//    public Map<String, Object> updateUserIdDTO(@PathVariable(value = "id") Long userIdId,
//            @Valid @RequestBody UserIdDTO userIdDTO) {
//			
//    	Map<String, Object> result = new HashMap<String,Object>();
//    	UserId userIdEntity = userIdRepository.findById(userIdId).get();
//    	
//		userIdEntity = modelMapper.map(userIdDTO, UserId.class);
//
//        userIdRepository.save(userIdEntity);
//    	
//    	result.put("Status", 200);
//        result.put("message", "Update User Data Success");
//        result.put("Data", userIdDTO);
//        
//    	return result;
//    }
//    
//    //Delete
//    @DeleteMapping("/delete_userIdDTO/{id}")
//    public Map<String, Object> deleteUserIdDTO(@PathVariable(value = "id") Long userIdId,
//            @Valid @RequestBody UserIdDTO userIdDTO) {
//    	
//    	Map<String, Object> result = new HashMap<String,Object>();
//    	UserId userIdEntity = userIdRepository.findById(userIdId).get();    	
//    	userIdRepository.delete(userIdEntity);
//    	
//    	result.put("Status", 200);
//        result.put("message", "Delete Data User Success");
//        result.put("Data", userIdDTO);
//        
//    	return result;
//    }
//}
