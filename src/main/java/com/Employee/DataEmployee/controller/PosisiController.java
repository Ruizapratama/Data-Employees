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

import com.Employee.DataEmployee.model.Posisi;
import com.Employee.DataEmployee.repository.PosisiRepository;

import Model_DTO.PosisiDTO;

@RestController
@RequestMapping("/posisi")
public class PosisiController {
	
	@Autowired
	PosisiRepository posisiRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	//Get DTO
	@GetMapping("/get_posisiDTO")
	public Map<String, Object> getAllPosisiDTO() {
		List<Posisi> listPosisiEntity = posisiRepository.findAll();
		
		List<PosisiDTO> listPosisiDTO = new ArrayList<PosisiDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (Posisi posisiEntity : listPosisiEntity) {
			PosisiDTO posisiDTO = new PosisiDTO();		
		
			posisiDTO = modelMapper.map(posisiEntity, PosisiDTO.class);
			
			listPosisiDTO.add(posisiDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data Position Success");
    	
    	result.put("Data", listPosisiDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_posisiDTO")
    public Map<String, Object> createPosisiDTO(@Valid @RequestBody PosisiDTO posisiDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	Posisi posisiEntity = new Posisi();
    	
		posisiEntity = modelMapper.map(posisiDTO, Posisi.class);
    	
		posisiRepository.save(posisiEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New Position Data Success");
        result.put("Data", posisiDTO);
        
		return result;
    	
    }
    
 // Get a Single 
    @GetMapping("/get_single_posisiDTO/{id}")
    public Map<String, Object> getPosisiDTOById(@PathVariable(value = "id") Long posisiId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	Posisi posisiEntity = posisiRepository.findById(posisiId).get();
    	PosisiDTO posisiDTO = new PosisiDTO();
    	
		posisiDTO = modelMapper.map(posisiEntity, PosisiDTO.class);
    	
    	result.put("Status", 200);
        result.put("message", "Read The Specific Position Data Success");
        result.put("Data", posisiDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_posisiDTO/{id}")
    public Map<String, Object> updatePosisiDTO(@PathVariable(value = "id") Long posisiId,
            @Valid @RequestBody PosisiDTO posisiDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	Posisi posisiEntity = posisiRepository.findById(posisiId).get();
    	
		posisiEntity = modelMapper.map(posisiDTO, Posisi.class);
		posisiEntity.setIdPosisi(posisiId);
		
        posisiRepository.save(posisiEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update Position Data Success");
        result.put("Data", posisiDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_posisiDTO/{id}")
    public Map<String, Object> deletePosisiDTO(@PathVariable(value = "id") Long posisiId,
            @Valid @RequestBody PosisiDTO posisiDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	Posisi posisiEntity = posisiRepository.findById(posisiId).get();    	
    	posisiRepository.delete(posisiEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Data Position Success");
        result.put("Data", posisiDTO);
        
    	return result;
    }
}
