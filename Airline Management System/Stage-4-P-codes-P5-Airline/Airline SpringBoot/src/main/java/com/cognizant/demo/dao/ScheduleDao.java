package com.cognizant.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.demo.entity.Schedule;

@Repository
public interface ScheduleDao {

	int create(Schedule schedule);

	List<Schedule> read();

	Schedule read(Long id);

	int update(Schedule schedule);

	int delete(Long id);

	List<Schedule> getSourceDestination(String source, String destination);
}