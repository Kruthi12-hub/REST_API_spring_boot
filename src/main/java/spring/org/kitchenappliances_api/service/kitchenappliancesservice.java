package spring.org.kitchenappliances_api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import spring.org.kitchenappliances_api.dto.kitchenappliances;
import spring.org.kitchenappliances_api.repository.kitchenappliancesrepository;

@Service
public class kitchenappliancesservice {
@Autowired
kitchenappliancesrepository repository;
public ResponseEntity<Object> savekitchenappliances(kitchenappliances kitchen) {
	repository.save(kitchen);


	Map<String, Object> map = new HashMap<String, Object>();
	map.put("message", "appliances Added Success");
	map.put("data", kitchen);

	return new ResponseEntity<Object>(map, HttpStatus.CREATED);
}
public ResponseEntity<Object> savekitchens(List<kitchenappliances> kitchens) {
	repository.saveAll(kitchens);
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("message", "appliances Added Success");
	map.put("data", kitchens);

	return new ResponseEntity<Object>(map, HttpStatus.CREATED);
}

public ResponseEntity<Object> fetchAllkitchens() {
	List<kitchenappliances> list = repository.findAll();
	if (list.isEmpty()) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "No appliances Found");

		return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
	} else {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "appliances Found");
		map.put("data", list);

		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
}
public ResponseEntity<Object> fetchById(int id) {
	Optional<kitchenappliances> optional = repository.findById(id);
	if(optional.isEmpty()) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "No appliances Found with Id: "+id);

		return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
	}else {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "appliances Found");
		map.put("data", optional.get());

		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
}
public ResponseEntity<Object> fetchByName(String name) {
	List<kitchenappliances> list = repository.findByName(name);
	if (list.isEmpty()) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "No appliances Found with Name :"+name);

		return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
	} else {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "appliances Found");
		map.put("data", list);

		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

}

public ResponseEntity<Object> fetchBymodle(String modle) {
	List<kitchenappliances> list = repository.findBymodle(modle);
	if (list.isEmpty()) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "No appliances Found with movie: "+modle);

		return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
	} else {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "appliances Found with movie");
		map.put("data", list);

		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
}

public ResponseEntity<Object> fetchBybrand(String brand) {
	List<kitchenappliances> list = repository.findBymodle(brand);
	if (list.isEmpty()) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "No appliances Found :" +brand);

		return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
	} else {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "appliances Found");
		map.put("data", list);

		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
}
public ResponseEntity<Object> deleteById(int id) {
	Optional<kitchenappliances> optional = repository.findById(id);
	if(optional.isEmpty()) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "No appliances Found with Id: "+id);

		return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
	}else {
		Map<String, Object> map = new HashMap<String, Object>();
		repository.deleteById(id);
		map.put("message", "appliances Deleted Success");

		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
}

public ResponseEntity<Object> updatekitchenappliances(kitchenappliances kitchen) {
	repository.save(kitchen);
	
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("message", "Appliances Updated Success");

	return new ResponseEntity<Object>(map, HttpStatus.OK);
}

public ResponseEntity<Object> updatekitchenappliances(int id, kitchenappliances kitchenappliances) {
	Optional<kitchenappliances> optional = repository.findById(id);
	if(optional.isEmpty()) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "No appliances Found with Id: "+id);

		return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
	}else {
		Map<String, Object> map = new HashMap<String, Object>();
		
		kitchenappliances existingkitchenappliances = optional.get();
		if(kitchenappliances .getname()!=null)
			existingkitchenappliances .setname(kitchenappliances .getname());
		if(kitchenappliances .getModle()!=null)
			existingkitchenappliances .setModle(kitchenappliances .getModle());
		if(kitchenappliances .getPrice()!=0)
			existingkitchenappliances .setPrice(kitchenappliances .getPrice());
		if(kitchenappliances .getBrand()!=null)
			existingkitchenappliances .setBrand(kitchenappliances .getBrand());
		
		repository.save(existingkitchenappliances);
		
		map.put("message", "appliances Updated Success");

		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
}
}
