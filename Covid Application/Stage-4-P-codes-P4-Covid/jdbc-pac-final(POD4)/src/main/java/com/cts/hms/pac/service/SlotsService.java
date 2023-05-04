package com.cts.hms.pac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hms.pac.dao.SlotsDao;
import com.cts.hms.pac.entity.Slots;

@Service
public class SlotsService {
	@Autowired
	private SlotsDao sdao;
	
	public int create(Slots slots)
	{
		return sdao.create(slots);
	}

	public List<Slots> read()
	{
		return sdao.read();
	}

	public Slots read(Long id)
	{
		return sdao.read(id);
	}
public Slots readbyUsername(String userName)
{
	return sdao.readbyUsername(userName);
}
	public int update(Slots slots)
	{
		return sdao.update(slots);
	}

	public int delete(Long id)
	{
		return sdao.delete(id);
	}
	
	
}
