package com.Employee.DataEmployee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.DataEmployee.model.ListKemampuan;
import com.Employee.DataEmployee.repository.ListKemampuanRepository;

import Model_DTO.ListKemampuanDTO;

@RestController
@RequestMapping("/listKemampuan")
public class ListKemampuanController {
	
	@Autowired
	ListKemampuanRepository listKemampuanRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	//Get DTO
	@GetMapping("/get_listKemampuanDTO")
	public Map<String, Object> getAllListKemampuanDTO() {
		List<ListKemampuan> listListKemampuanEntity = listKemampuanRepository.findAll();
		
		List<ListKemampuanDTO> listListKemampuanDTO = new ArrayList<ListKemampuanDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (ListKemampuan listKemampuanEntity : listListKemampuanEntity) {
			ListKemampuanDTO listKemampuanDTO = new ListKemampuanDTO();		
		
			listKemampuanDTO = modelMapper.map(listKemampuanEntity, ListKemampuanDTO.class);
			
			listListKemampuanDTO.add(listKemampuanDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data List Skill Success");
    	
    	result.put("Data", listListKemampuanDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_listKemampuanDTO")
    public Map<String, Object> createListKemampuanDTO(@Valid @RequestBody ListKemampuanDTO listKemampuanDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	ListKemampuan listKemampuanEntity = new ListKemampuan();
    	
		listKemampuanEntity = modelMapper.map(listKemampuanDTO, ListKemampuan.class);
    	
		listKemampuanRepository.save(listKemampuanEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New List Skill Data Success");
        result.put("Data", listKemampuanDTO);
        
		return result;
    	
    }
    
 // Get a Single 
    @GetMapping("/get_single_listKemampuanDTO/{id}")
    public Map<String, Object> getListKemampuanDTOById(@PathVariable(value = "id") Long listKemampuanId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	ListKemampuan listKemampuanEntity = listKemampuanRepository.findById(listKemampuanId).get();
    	ListKemampuanDTO listKemampuanDTO = new ListKemampuanDTO();
    	
		listKemampuanDTO = modelMapper.map(listKemampuanEntity, ListKemampuanDTO.class);
    	
    	result.put("Status", 200);
        result.put("message", "Read The Specific List Skill Data Success");
        result.put("Data", listKemampuanDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_listKemampuanDTO/{id}")
    public Map<String, Object> updateListKemampuanDTO(@PathVariable(value = "id") Long listKemampuanId,
            @Valid @RequestBody ListKemampuanDTO listKemampuanDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	ListKemampuan listKemampuanEntity = listKemampuanRepository.findById(listKemampuanId).get();
    	
		listKemampuanEntity = modelMapper.map(listKemampuanDTO, ListKemampuan.class);
		
		listKemampuanEntity.setIdListKemampuan(listKemampuanId);

        listKemampuanRepository.save(listKemampuanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update List Skill Data Success");
        result.put("Data", listKemampuanDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_listKemampuanDTO/{id}")
    public Map<String, Object> deleteListKemampuanDTO(@PathVariable(value = "id") Long listKemampuanId,
            @Valid @RequestBody ListKemampuanDTO listKemampuanDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	ListKemampuan listKemampuanEntity = listKemampuanRepository.findById(listKemampuanId).get();    	
    	listKemampuanRepository.delete(listKemampuanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Data List Skill Success");
        result.put("Data", listKemampuanDTO);
        
    	return result;
    }
}
