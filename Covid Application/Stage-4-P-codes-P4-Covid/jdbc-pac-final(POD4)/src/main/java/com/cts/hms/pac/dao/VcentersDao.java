package com.cts.hms.pac.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cts.hms.pac.entity.Vcenters;

@Repository
public interface VcentersDao {

	int create(Vcenters vcenters);

	List<Vcenters> read();
	
	Vcenters read(Long id);

	List<Vcenters> readbyPincode(Long pinCode);

	int update(Vcenters vcenters);

	int delete(Long id);

}
