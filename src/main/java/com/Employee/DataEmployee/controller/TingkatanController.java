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

import com.Employee.DataEmployee.model.Tingkatan;
import com.Employee.DataEmployee.repository.TingkatanRepository;

import Model_DTO.TingkatanDTO;

@RestController
@RequestMapping("/tingkatan")
public class TingkatanController {
	
	@Autowired
	TingkatanRepository tingkatanRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	//Get DTO
	@GetMapping("/get_tingkatanDTO")
	public Map<String, Object> getAllTingkatanDTO() {
		List<Tingkatan> listTingkatanEntity = tingkatanRepository.findAll();
		
		List<TingkatanDTO> listTingkatanDTO = new ArrayList<TingkatanDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (Tingkatan tingkatanEntity : listTingkatanEntity) {
			TingkatanDTO tingkatanDTO = new TingkatanDTO();		
		
			tingkatanDTO = modelMapper.map(tingkatanEntity, TingkatanDTO.class);
			
			listTingkatanDTO.add(tingkatanDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data Levels Success");
    	
    	result.put("Data", listTingkatanDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_tingkatanDTO")
    public Map<String, Object> createTingkatanDTO(@Valid @RequestBody TingkatanDTO tingkatanDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	Tingkatan tingkatanEntity = new Tingkatan();
    	
		tingkatanEntity = modelMapper.map(tingkatanDTO, Tingkatan.class);
    	
		tingkatanRepository.save(tingkatanEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New Levels Data Success");
        result.put("Data", tingkatanDTO);
        
		return result;
    	
    }
    
 // Get a Single 
    @GetMapping("/get_single_tingkatanDTO/{id}")
    public Map<String, Object> getTingkatanDTOById(@PathVariable(value = "id") Long tingkatanId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	Tingkatan tingkatanEntity = tingkatanRepository.findById(tingkatanId).get();
    	TingkatanDTO tingkatanDTO = new TingkatanDTO();
    	
		tingkatanDTO = modelMapper.map(tingkatanEntity, TingkatanDTO.class);
    	
    	result.put("Status", 200);
        result.put("message", "Read The Specific Levels Data Success");
        result.put("Data", tingkatanDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_tingkatanDTO/{id}")
    public Map<String, Object> updateTingkatanDTO(@PathVariable(value = "id") Long tingkatanId,
            @Valid @RequestBody TingkatanDTO tingkatanDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	Tingkatan tingkatanEntity = tingkatanRepository.findById(tingkatanId).get();
    	
		tingkatanEntity = modelMapper.map(tingkatanDTO, Tingkatan.class);
		tingkatanEntity.setIdTingkatan(tingkatanId);
		
        tingkatanRepository.save(tingkatanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update Levels Data Success");
        result.put("Data", tingkatanDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_tingkatanDTO/{id}")
    public Map<String, Object> deleteTingkatanDTO(@PathVariable(value = "id") Long tingkatanId,
            @Valid @RequestBody TingkatanDTO tingkatanDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	Tingkatan tingkatanEntity = tingkatanRepository.findById(tingkatanId).get();    	
    	tingkatanRepository.delete(tingkatanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Data Levels Success");
        result.put("Data", tingkatanDTO);
        
    	return result;
    }
}
