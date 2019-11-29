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

import com.Employee.DataEmployee.model.PresentaseGaji;
import com.Employee.DataEmployee.repository.PresentaseGajiRepository;

import Model_DTO.PresentaseGajiDTO;

@RestController
@RequestMapping("/presentaseGaji")
public class PresentaseGajiController {
	
	@Autowired
	PresentaseGajiRepository presentaseGajiRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	//Get DTO
	@GetMapping("/get_presentaseGajiDTO")
	public Map<String, Object> getAllPresentaseGajiDTO() {
		List<PresentaseGaji> listPresentaseGajiEntity = presentaseGajiRepository.findAll();
		
		List<PresentaseGajiDTO> listPresentaseGajiDTO = new ArrayList<PresentaseGajiDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (PresentaseGaji presentaseGajiEntity : listPresentaseGajiEntity) {
			PresentaseGajiDTO presentaseGajiDTO = new PresentaseGajiDTO();		
		
			presentaseGajiDTO = modelMapper.map(presentaseGajiEntity, PresentaseGajiDTO.class);
			
			listPresentaseGajiDTO.add(presentaseGajiDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data Salary Percentage Success");
    	
    	result.put("Data", listPresentaseGajiDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_presentaseGajiDTO")
    public Map<String, Object> createPresentaseGajiDTO(@Valid @RequestBody PresentaseGajiDTO presentaseGajiDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	PresentaseGaji presentaseGajiEntity = new PresentaseGaji();
    	
		presentaseGajiEntity = modelMapper.map(presentaseGajiDTO, PresentaseGaji.class);
    	
		presentaseGajiRepository.save(presentaseGajiEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New Salary Percentage Data Success");
        result.put("Data", presentaseGajiDTO);
        
		return result;
    	
    }
    
 // Get a Single 
    @GetMapping("/get_single_presentaseGajiDTO/{id}")
    public Map<String, Object> getPresentaseGajiDTOById(@PathVariable(value = "id") Long presentaseGajiId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	PresentaseGaji presentaseGajiEntity = presentaseGajiRepository.findById(presentaseGajiId).get();
    	PresentaseGajiDTO presentaseGajiDTO = new PresentaseGajiDTO();
    	
		presentaseGajiDTO = modelMapper.map(presentaseGajiEntity, PresentaseGajiDTO.class);
    	
    	result.put("Status", 200);
        result.put("message", "Read The Specific Salary Percentage Data Success");
        result.put("Data", presentaseGajiDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_presentaseGajiDTO/{id}")
    public Map<String, Object> updatePresentaseGajiDTO(@PathVariable(value = "id") Long presentaseGajiId,
            @Valid @RequestBody PresentaseGajiDTO presentaseGajiDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	PresentaseGaji presentaseGajiEntity = presentaseGajiRepository.findById(presentaseGajiId).get();
    	
		presentaseGajiEntity = modelMapper.map(presentaseGajiDTO, PresentaseGaji.class);
		presentaseGajiEntity.setIdPresentaseGaji(presentaseGajiId);

        presentaseGajiRepository.save(presentaseGajiEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update Salary Percentage Data Success");
        result.put("Data", presentaseGajiDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_presentaseGajiDTO/{id}")
    public Map<String, Object> deletePresentaseGajiDTO(@PathVariable(value = "id") Long presentaseGajiId,
            @Valid @RequestBody PresentaseGajiDTO presentaseGajiDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	PresentaseGaji presentaseGajiEntity = presentaseGajiRepository.findById(presentaseGajiId).get();    	
    	presentaseGajiRepository.delete(presentaseGajiEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Data Salary Percentage Success");
        result.put("Data", presentaseGajiDTO);
        
    	return result;
    }
}
