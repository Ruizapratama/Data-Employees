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

import com.Employee.DataEmployee.model.ParameterPajak;
import com.Employee.DataEmployee.repository.ParameterPajakRepository;

import Model_DTO.ParameterPajakDTO;

@RestController
@RequestMapping("/parameterPajak")
public class ParameterPajakController {
	
	@Autowired
	ParameterPajakRepository parameterPajakRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	//Get DTO
	@GetMapping("/get_parameterPajakDTO")
	public Map<String, Object> getAllParameterPajakDTO() {
		List<ParameterPajak> listParameterPajakEntity = parameterPajakRepository.findAll();
		
		List<ParameterPajakDTO> listParameterPajakDTO = new ArrayList<ParameterPajakDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (ParameterPajak parameterPajakEntity : listParameterPajakEntity) {
			ParameterPajakDTO parameterPajakDTO = new ParameterPajakDTO();		
		
			parameterPajakDTO = modelMapper.map(parameterPajakEntity, ParameterPajakDTO.class);
			
			listParameterPajakDTO.add(parameterPajakDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data Tax Parameter Success");
    	
    	result.put("Data", listParameterPajakDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_parameterPajakDTO")
    public Map<String, Object> createParameterPajakDTO(@Valid @RequestBody ParameterPajakDTO parameterPajakDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	ParameterPajak parameterPajakEntity = new ParameterPajak();
    	
		parameterPajakEntity = modelMapper.map(parameterPajakDTO, ParameterPajak.class);
    	
		parameterPajakRepository.save(parameterPajakEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New Tax Parameter Data Success");
        result.put("Data", parameterPajakDTO);
        
		return result;
    	
    }
    
 // Get a Single 
    @GetMapping("/get_single_parameterPajakDTO/{id}")
    public Map<String, Object> getParameterPajakDTOById(@PathVariable(value = "id") Long parameterPajakId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	ParameterPajak parameterPajakEntity = parameterPajakRepository.findById(parameterPajakId).get();
    	ParameterPajakDTO parameterPajakDTO = new ParameterPajakDTO();
    	
		parameterPajakDTO = modelMapper.map(parameterPajakEntity, ParameterPajakDTO.class);
    	
    	result.put("Status", 200);
        result.put("message", "Read The Specific Tax Parameter Data Success");
        result.put("Data", parameterPajakDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_parameterPajakDTO/{id}")
    public Map<String, Object> updateParameterPajakDTO(@PathVariable(value = "id") Long parameterPajakId,
            @Valid @RequestBody ParameterPajakDTO parameterPajakDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	ParameterPajak parameterPajakEntity = parameterPajakRepository.findById(parameterPajakId).get();
    	
		parameterPajakEntity = modelMapper.map(parameterPajakDTO, ParameterPajak.class);
		parameterPajakEntity.setIdParamPajak(parameterPajakId);

        parameterPajakRepository.save(parameterPajakEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update Tax Parameter Data Success");
        result.put("Data", parameterPajakDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_parameterPajakDTO/{id}")
    public Map<String, Object> deleteParameterPajakDTO(@PathVariable(value = "id") Long parameterPajakId,
            @Valid @RequestBody ParameterPajakDTO parameterPajakDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	ParameterPajak parameterPajakEntity = parameterPajakRepository.findById(parameterPajakId).get();    	
    	parameterPajakRepository.delete(parameterPajakEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Data Tax Parameter Success");
        result.put("Data", parameterPajakDTO);
        
    	return result;
    }
}
