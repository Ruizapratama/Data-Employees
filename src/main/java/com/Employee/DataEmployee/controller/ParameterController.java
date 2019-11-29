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

import com.Employee.DataEmployee.model.Parameter;
import com.Employee.DataEmployee.repository.ParameterRepository;

import Model_DTO.ParameterDTO;

@RestController
@RequestMapping("/parameter")
public class ParameterController {
	
	@Autowired
	ParameterRepository parameterRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	//Get DTO
	@GetMapping("/get_parameterDTO")
	public Map<String, Object> getAllParameterDTO() {
		List<Parameter> listParameterEntity = parameterRepository.findAll();
		
		List<ParameterDTO> listParameterDTO = new ArrayList<ParameterDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (Parameter parameterEntity : listParameterEntity) {
			ParameterDTO parameterDTO = new ParameterDTO();		
		
			parameterDTO = modelMapper.map(parameterEntity, ParameterDTO.class);
			
			listParameterDTO.add(parameterDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data Parameter Success");
    	
    	result.put("Data", listParameterDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_parameterDTO")
    public Map<String, Object> createParameterDTO(@Valid @RequestBody ParameterDTO parameterDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	Parameter parameterEntity = new Parameter();
    	
		parameterEntity = modelMapper.map(parameterDTO, Parameter.class);
    	
		parameterRepository.save(parameterEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New Parameter Data Success");
        result.put("Data", parameterDTO);
        
		return result;
    	
    }
    
 // Get a Single 
    @GetMapping("/get_single_parameterDTO/{id}")
    public Map<String, Object> getParameterDTOById(@PathVariable(value = "id") Long parameterId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	Parameter parameterEntity = parameterRepository.findById(parameterId).get();
    	ParameterDTO parameterDTO = new ParameterDTO();
    	
		parameterDTO = modelMapper.map(parameterEntity, ParameterDTO.class);
    	
    	result.put("Status", 200);
        result.put("message", "Read The Specific Parameter Data Success");
        result.put("Data", parameterDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_parameterDTO/{id}")
    public Map<String, Object> updateParameterDTO(@PathVariable(value = "id") Long parameterId,
            @Valid @RequestBody ParameterDTO parameterDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	Parameter parameterEntity = parameterRepository.findById(parameterId).get();
    	
		parameterEntity = modelMapper.map(parameterDTO, Parameter.class);
		parameterEntity.setIdParam(parameterId);

        parameterRepository.save(parameterEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update Parameter Data Success");
        result.put("Data", parameterDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_parameterDTO/{id}")
    public Map<String, Object> deleteParameterDTO(@PathVariable(value = "id") Long parameterId,
            @Valid @RequestBody ParameterDTO parameterDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	Parameter parameterEntity = parameterRepository.findById(parameterId).get();    	
    	parameterRepository.delete(parameterEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Data Parameter Success");
        result.put("Data", parameterDTO);
        
    	return result;
    }
}
