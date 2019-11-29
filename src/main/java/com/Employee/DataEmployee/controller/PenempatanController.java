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

import com.Employee.DataEmployee.model.Penempatan;
import com.Employee.DataEmployee.repository.PenempatanRepository;

import Model_DTO.PenempatanDTO;

@RestController
@RequestMapping("/penempatan")
public class PenempatanController {
	
	@Autowired
	PenempatanRepository penempatanRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	//Get DTO
	@GetMapping("/get_penempatanDTO")
	public Map<String, Object> getAllPenempatanDTO() {
		List<Penempatan> listPenempatanEntity = penempatanRepository.findAll();
		
		List<PenempatanDTO> listPenempatanDTO = new ArrayList<PenempatanDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (Penempatan penempatanEntity : listPenempatanEntity) {
			PenempatanDTO penempatanDTO = new PenempatanDTO();		
		
			penempatanDTO = modelMapper.map(penempatanEntity, PenempatanDTO.class);
			
			listPenempatanDTO.add(penempatanDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data Placement Success");
    	
    	result.put("Data", listPenempatanDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_penempatanDTO")
    public Map<String, Object> createPenempatanDTO(@Valid @RequestBody PenempatanDTO penempatanDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	Penempatan penempatanEntity = new Penempatan();
    	
		penempatanEntity = modelMapper.map(penempatanDTO, Penempatan.class);
    	
		penempatanRepository.save(penempatanEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New Placement Data Success");
        result.put("Data", penempatanDTO);
        
		return result;
    	
    }
    
 // Get a Single 
    @GetMapping("/get_single_penempatanDTO/{id}")
    public Map<String, Object> getPenempatanDTOById(@PathVariable(value = "id") Long penempatanId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	Penempatan penempatanEntity = penempatanRepository.findById(penempatanId).get();
    	PenempatanDTO penempatanDTO = new PenempatanDTO();
    	
		penempatanDTO = modelMapper.map(penempatanEntity, PenempatanDTO.class);
    	
    	result.put("Status", 200);
        result.put("message", "Read The Specific Placement Data Success");
        result.put("Data", penempatanDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_penempatanDTO/{id}")
    public Map<String, Object> updatePenempatanDTO(@PathVariable(value = "id") Long penempatanId,
            @Valid @RequestBody PenempatanDTO penempatanDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	Penempatan penempatanEntity = penempatanRepository.findById(penempatanId).get();
    	    	
		penempatanEntity = modelMapper.map(penempatanDTO, Penempatan.class);
    	penempatanEntity.setIdPenempatan(penempatanId);

        penempatanRepository.save(penempatanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update Placement Data Success");
        result.put("Data", penempatanDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_penempatanDTO/{id}")
    public Map<String, Object> deletePenempatanDTO(@PathVariable(value = "id") Long penempatanId,
            @Valid @RequestBody PenempatanDTO penempatanDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	Penempatan penempatanEntity = penempatanRepository.findById(penempatanId).get();    	
    	penempatanRepository.delete(penempatanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Placement Data Success");
        result.put("Data", penempatanDTO);
        
    	return result;
    }
}