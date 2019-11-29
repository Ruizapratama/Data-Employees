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

import com.Employee.DataEmployee.model.Kemampuan;
import com.Employee.DataEmployee.repository.KemampuanRepository;

import Model_DTO.KemampuanDTO;

@RestController
@RequestMapping("/kemampuan")
public class KemampuanController {
	
	@Autowired
	KemampuanRepository kemampuanRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	//Get DTO
	@GetMapping("/get_kemampuanDTO")
	public Map<String, Object> getAllKemampuanDTO() {
		List<Kemampuan> listKemampuanEntity = kemampuanRepository.findAll();
		
		List<KemampuanDTO> listKemampuanDTO = new ArrayList<KemampuanDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (Kemampuan kemampuanEntity : listKemampuanEntity) {
			KemampuanDTO kemampuanDTO = new KemampuanDTO();		
		
			kemampuanDTO = modelMapper.map(kemampuanEntity, KemampuanDTO.class);
			
			listKemampuanDTO.add(kemampuanDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data Skills Success");
    	
    	result.put("Data", listKemampuanDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_kemampuanDTO")
    public Map<String, Object> createKemampuanDTO(@Valid @RequestBody KemampuanDTO kemampuanDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	Kemampuan kemampuanEntity = new Kemampuan();
    	
		kemampuanEntity = modelMapper.map(kemampuanDTO, Kemampuan.class);
    	
		kemampuanRepository.save(kemampuanEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New Skills Data Success");
        result.put("Data", kemampuanDTO);
        
		return result;
    	
    }
    
 // Get a Single 
    @GetMapping("/get_single_kemampuanDTO/{id}")
    public Map<String, Object> getKemampuanDTOById(@PathVariable(value = "id") Long kemampuanId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	Kemampuan kemampuanEntity = kemampuanRepository.findById(kemampuanId).get();
    	KemampuanDTO kemampuanDTO = new KemampuanDTO();
    	
		kemampuanDTO = modelMapper.map(kemampuanEntity, KemampuanDTO.class);
    	
    	result.put("Status", 200);
        result.put("message", "Read The Specific Skills Data Success");
        result.put("Data", kemampuanDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_kemampuanDTO/{id}")
    public Map<String, Object> updateKemampuanDTO(@PathVariable(value = "id") Long kemampuanId,
            @Valid @RequestBody KemampuanDTO kemampuanDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	Kemampuan kemampuanEntity = kemampuanRepository.findById(kemampuanId).get();
    	
		kemampuanEntity = modelMapper.map(kemampuanDTO, Kemampuan.class);
		
		kemampuanEntity.setIdKemampuan(kemampuanId);

        kemampuanRepository.save(kemampuanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update Skills Data Success");
        result.put("Data", kemampuanDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_kemampuanDTO/{id}")
    public Map<String, Object> deleteKemampuanDTO(@PathVariable(value = "id") Long kemampuanId,
            @Valid @RequestBody KemampuanDTO kemampuanDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	Kemampuan kemampuanEntity = kemampuanRepository.findById(kemampuanId).get();    	
    	kemampuanRepository.delete(kemampuanEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Data Skills Success");
        result.put("Data", kemampuanDTO);
        
    	return result;
    }
}
