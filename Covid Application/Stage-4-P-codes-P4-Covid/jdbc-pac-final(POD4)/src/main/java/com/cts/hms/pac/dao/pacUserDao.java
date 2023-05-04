package com.cts.hms.pac.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cts.hms.pac.entity.pacUser;

@Repository
public interface pacUserDao {

	int create(pacUser pacuser);

	List<pacUser> read();

	pacUser read(Long id);
	pacUser read(String userName);

	int update(pacUser pacuser);

	int delete(Long id);
	
	pacUser fetchUserByUserNameAndPassword(String tempUserId, String tempPass);
}
