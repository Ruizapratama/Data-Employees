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

import com.Employee.DataEmployee.model.Agama;
import com.Employee.DataEmployee.repository.AgamaRepository;

import Model_DTO.AgamaDTO;

@RestController
@RequestMapping("/agama")
public class AgamaController {
	
	@Autowired
	AgamaRepository agamaRepository;
	ModelMapper modelMapper = new ModelMapper();

//==============================================================================================================
	
	//Read
	@GetMapping("/get_agamaDTO")
	public Map<String, Object> getAllAgamaDTO() {
		List<Agama> listAgamaEntity = agamaRepository.findAll();
		
		List<AgamaDTO> listAgamaDTO = new ArrayList<AgamaDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (Agama agamaEntity : listAgamaEntity) {
			AgamaDTO agamaDTO = new AgamaDTO();		
		
			agamaDTO = modelMapper.map(agamaEntity, AgamaDTO.class);
			
			listAgamaDTO.add(agamaDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data Religion Success");
    	
    	result.put("Data", listAgamaDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_agamaDTO")
    public Map<String, Object> createAgamaDTO(@Valid @RequestBody AgamaDTO agamaDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	Agama agamaEntity = new Agama();
    	
		agamaEntity = modelMapper.map(agamaDTO, Agama.class);
    	
		agamaRepository.save(agamaEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New Religion Data Success");
        result.put("Data", agamaDTO);
        
		return result;
    	
    } 
    
 // Get a Single 
    @GetMapping("/get_single_agamaDTO/{id}")
    public Map<String, Object> getAgamaDTOById(@PathVariable(value = "id") Long agamaId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	Agama agamaEntity = agamaRepository.findById(agamaId).get();
    	AgamaDTO agamaDTO = new AgamaDTO();
    	
		agamaDTO = modelMapper.map(agamaEntity, AgamaDTO.class);
		
    	result.put("Status", 200);
        result.put("message", "Read The Specific Religion Data Success");
        result.put("Data", agamaDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_agamaDTO/{id}")
    public Map<String, Object> updateAgamaDTO(@PathVariable(value = "id") Long agamaId,
            @Valid @RequestBody AgamaDTO agamaDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	Agama agamaEntity = agamaRepository.findById(agamaId).get();
    	
		agamaEntity = modelMapper.map(agamaDTO, Agama.class);

		agamaEntity.setIdAgama(agamaId);
		
        agamaRepository.save(agamaEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update Religion Data Success");
        result.put("Data", agamaDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_agamaDTO/{id}")
    public Map<String, Object> deleteAgamaDTO(@PathVariable(value = "id") Long agamaId,
            @Valid @RequestBody AgamaDTO agamaDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	Agama agamaEntity = agamaRepository.findById(agamaId).get();    	
    	agamaRepository.delete(agamaEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Data Religion Success");
        result.put("Data", agamaDTO);
        
    	return result;
    }
}
