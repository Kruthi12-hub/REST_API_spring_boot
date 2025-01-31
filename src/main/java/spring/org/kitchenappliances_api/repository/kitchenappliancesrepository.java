package spring.org.kitchenappliances_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.org.kitchenappliances_api.dto.kitchenappliances;

public interface kitchenappliancesrepository extends JpaRepository<kitchenappliances, Integer>{
	List<kitchenappliances> findByName(String name);
	List<kitchenappliances> findBymodle(String modle);
	List<kitchenappliances> findBybrand(String brand);
}
