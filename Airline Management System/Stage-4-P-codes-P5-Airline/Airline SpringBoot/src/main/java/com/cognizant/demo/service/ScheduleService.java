package com.cognizant.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.demo.dao.ScheduleDao;
import com.cognizant.demo.entity.Schedule;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleDao sdao;

	public int create(Schedule schedule) {
		return sdao.create(schedule);
	}

	public List<Schedule> read() {
		return sdao.read();
	}

	public Schedule read(Long id) {
		return sdao.read(id);
	}

	public int update(Schedule schedule) {
		return sdao.update(schedule);
	}

	public int delete(Long id) {
		return sdao.delete(id);
	}

	public List<Schedule> getSourceDestination(String source, String destination) {
		return sdao.getSourceDestination(source, destination);
	}
}
