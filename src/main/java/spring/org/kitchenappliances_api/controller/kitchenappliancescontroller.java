package spring.org.kitchenappliances_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.org.kitchenappliances_api.dto.kitchenappliances;
import spring.org.kitchenappliances_api.service.kitchenappliancesservice;

@RestController
public class kitchenappliancescontroller {
	@Autowired
	kitchenappliancesservice service;
	
	@PostMapping("/kitchen")
	public ResponseEntity<Object> savekitchenappliances(@RequestBody kitchenappliances kitchen){
		return service.savekitchenappliances(kitchen);
	}
	
	@PostMapping("/kitchens/many")
	public ResponseEntity<Object> savekitchens(@RequestBody List<kitchenappliances> kitchens){
		return service.savekitchens(kitchens);
	}
	@GetMapping("/kitchens")
	public ResponseEntity<Object> fetchAllkitchens(){
		return service.fetchAllkitchens();
	}
	
	//Fetch appliances By Id
		@GetMapping("/kitchens/{id}")
		public ResponseEntity<Object> fetchById(@PathVariable int id){
			return service.fetchById(id);
		}
		
		//Fetch appliances By Name
		@GetMapping("/kitchens/name/{name}")
		public ResponseEntity<Object> fetchByName(@PathVariable String name){
			return service.fetchByName(name);
		}
		
		//Fetch appliances by modle
		@GetMapping("/kitchens/Modle/{Modle}")
		public ResponseEntity<Object> fetchBymodle(@PathVariable String modle){
			return service.fetchBymodle(modle);
		}
		
		//Fetch appliances By brand
		@GetMapping("/kitchens/brand/{brand}")
		public ResponseEntity<Object> fetchBybrand(@PathVariable String brand){
			return service.fetchBybrand(brand);
		}
		
		//Delete appliances  By Id
		@DeleteMapping("/kitchens/{id}")
		public ResponseEntity<Object> deleteById(@PathVariable int id){
			return service.deleteById(id);
		}
		
		//Update appliances  - PUT
		@PutMapping("/kitchens")
		public ResponseEntity<Object> updateRecord(@RequestBody kitchenappliances kitchen){
			return service.updatekitchenappliances(kitchen);
		}
		
		//Update appliances - PATCH
		@PatchMapping("/kitchens/{id}")
		public ResponseEntity<Object> updateById(@PathVariable kitchenappliances id){
			return service.updatekitchenappliances(id);
		}
		
}
