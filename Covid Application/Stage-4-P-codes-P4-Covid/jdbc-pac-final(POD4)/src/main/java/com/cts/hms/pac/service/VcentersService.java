package com.cts.hms.pac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hms.pac.dao.VcentersDao;
import com.cts.hms.pac.entity.Vcenters;

@Service
public class VcentersService {
	@Autowired
	private VcentersDao vdao;
	
	public int create(Vcenters vcenters)
	{
		return vdao.create(vcenters);
	}

	public List<Vcenters> read()
	{
		return vdao.read();
	}
	
	public Vcenters read(Long id)
	{
		return vdao.read(id);
	}

	public List<Vcenters> readbyPincode(Long pinCode) {
		
		return vdao.readbyPincode(pinCode);
		}

	public int update(Vcenters vcenters)
	{
		return vdao.update(vcenters);
	}

	public int delete(Long id)
	{
		return vdao.delete(id);
	}
	
	
}
