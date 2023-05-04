package com.cts.hms.pac.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cts.hms.pac.entity.Slots;

@Repository
public interface SlotsDao {

	int create(Slots slots);

	List<Slots> read();

	Slots read(Long id);

	int update(Slots slots);

	int delete(Long id);

	//Slots read(String userName);

	Slots readbyUsername(String userName);
}
