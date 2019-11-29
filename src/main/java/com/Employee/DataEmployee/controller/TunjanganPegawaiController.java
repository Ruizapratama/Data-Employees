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

import com.Employee.DataEmployee.model.TunjanganPegawai;
import com.Employee.DataEmployee.repository.TunjanganPegawaiRepository;

import Model_DTO.TunjanganPegawaiDTO;

@RestController
@RequestMapping("/tunjanganPegawai")
public class TunjanganPegawaiController {
	
	@Autowired
	TunjanganPegawaiRepository tunjanganPegawaiRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	//Get DTO
	@GetMapping("/get_tunjanganPegawaiDTO")
	public Map<String, Object> getAllTunjanganPegawaiDTO() {
		List<TunjanganPegawai> listTunjanganPegawaiEntity = tunjanganPegawaiRepository.findAll();
		
		List<TunjanganPegawaiDTO> listTunjanganPegawaiDTO = new ArrayList<TunjanganPegawaiDTO>();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (TunjanganPegawai tunjanganPegawaiEntity : listTunjanganPegawaiEntity) {
			TunjanganPegawaiDTO tunjanganPegawaiDTO = new TunjanganPegawaiDTO();		
		
			tunjanganPegawaiDTO = modelMapper.map(tunjanganPegawaiEntity, TunjanganPegawaiDTO.class);
			
			listTunjanganPegawaiDTO.add(tunjanganPegawaiDTO);
		}
		
		result.put("Status", 200);
    	result.put("message", "Read All Data Employee Benefits Success");
    	
    	result.put("Data", listTunjanganPegawaiDTO);
    	
    	return result;
	}
	
	//Create 
    @PostMapping("/create_tunjanganPegawaiDTO")
    public Map<String, Object> createTunjanganPegawaiDTO(@Valid @RequestBody TunjanganPegawaiDTO tunjanganPegawaiDTO) {
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	TunjanganPegawai tunjanganPegawaiEntity = new TunjanganPegawai();
    	
		tunjanganPegawaiEntity = modelMapper.map(tunjanganPegawaiDTO, TunjanganPegawai.class);
    	
		tunjanganPegawaiRepository.save(tunjanganPegawaiEntity);
		
    	result.put("Status", 200);
        result.put("message", "Create New Employee Benefits Data Success");
        result.put("Data", tunjanganPegawaiDTO);
        
		return result;
    	
    }
    
 // Get a Single 
    @GetMapping("/get_single_tunjanganPegawaiDTO/{id}")
    public Map<String, Object> getTunjanganPegawaiDTOById(@PathVariable(value = "id") Long tunjanganPegawaiId){
		
    	Map<String, Object> result = new HashMap<String,Object>();
    	TunjanganPegawai tunjanganPegawaiEntity = tunjanganPegawaiRepository.findById(tunjanganPegawaiId).get();
    	TunjanganPegawaiDTO tunjanganPegawaiDTO = new TunjanganPegawaiDTO();
    	
		tunjanganPegawaiDTO = modelMapper.map(tunjanganPegawaiEntity, TunjanganPegawaiDTO.class);
    	
    	result.put("Status", 200);
        result.put("message", "Read The Specific Employee Benefits Data Success");
        result.put("Data", tunjanganPegawaiDTO);

        return result;
    }
    
    // Update
    @PutMapping("/update_tunjanganPegawaiDTO/{id}")
    public Map<String, Object> updateTunjanganPegawaiDTO(@PathVariable(value = "id") Long tunjanganPegawaiId,
            @Valid @RequestBody TunjanganPegawaiDTO tunjanganPegawaiDTO) {
			
    	Map<String, Object> result = new HashMap<String,Object>();
    	TunjanganPegawai tunjanganPegawaiEntity = tunjanganPegawaiRepository.findById(tunjanganPegawaiId).get();
    	
		tunjanganPegawaiEntity = modelMapper.map(tunjanganPegawaiDTO, TunjanganPegawai.class);
		tunjanganPegawaiEntity.setIdTunjanganPegawai(tunjanganPegawaiId);

        tunjanganPegawaiRepository.save(tunjanganPegawaiEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Update Employee Benefits Data Success");
        result.put("Data", tunjanganPegawaiDTO);
        
    	return result;
    }
    
    //Delete
    @DeleteMapping("/delete_tunjanganPegawaiDTO/{id}")
    public Map<String, Object> deleteTunjanganPegawaiDTO(@PathVariable(value = "id") Long tunjanganPegawaiId,
            @Valid @RequestBody TunjanganPegawaiDTO tunjanganPegawaiDTO) {
    	
    	Map<String, Object> result = new HashMap<String,Object>();
    	TunjanganPegawai tunjanganPegawaiEntity = tunjanganPegawaiRepository.findById(tunjanganPegawaiId).get();    	
    	tunjanganPegawaiRepository.delete(tunjanganPegawaiEntity);
    	
    	result.put("Status", 200);
        result.put("message", "Delete Data Employee Benefits Success");
        result.put("Data", tunjanganPegawaiDTO);
        
    	return result;
    }
}
