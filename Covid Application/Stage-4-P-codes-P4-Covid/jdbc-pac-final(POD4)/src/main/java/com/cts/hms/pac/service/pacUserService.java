package com.cts.hms.pac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hms.pac.dao.pacUserDao;
import com.cts.hms.pac.entity.pacUser;

@Service
public class pacUserService {
	@Autowired
	private pacUserDao udao;
	
	public int create(pacUser pacuser)
	{
		return udao.create(pacuser);
	}

	public List<pacUser> read()
	{
		return udao.read();
	}

	public pacUser read(Long id)
	{
		return udao.read(id);
	}
	public pacUser read(String userName)
	{
		return udao.read(userName);
	}
	
	public  pacUser fetchUserByUserNameAndPassword(String tempUserId, String tempPass) {
		// TODO Auto-generated method stub
		return udao.fetchUserByUserNameAndPassword(tempUserId,tempPass);
	}

	public int update(pacUser pacuser)
	{
		return udao.update(pacuser);
	}

	public int delete(Long id)
	{
		return udao.delete(id);
	}
}


