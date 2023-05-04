package com.cognizant.demo.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.demo.entity.Schedule;
import com.cognizant.demo.service.ScheduleService;

@RestController
@CrossOrigin(origins = { "*" })
public class ScheduleController {

	@Autowired
	private ScheduleService ss;

	@GetMapping("/schedule")
	public List<Schedule> getAllSchedule() {
		return ss.read();
	}

	@GetMapping("/schedule/{id}")
	public Schedule getScheduleById(@PathVariable Long id) {
		return ss.read(id);
	}

	@PostMapping("/schedule")
	public int addSchedule(@RequestBody Schedule schedule) {
		schedule.setId(generateScheduleId());
		return ss.create(schedule);
	}

	@PostMapping("/schedule/repeat")
	public void repeat(@RequestBody Schedule schedule) {
		System.out.println("To repeat " + schedule.getRepeat() + " times");

		ZoneId defaultZoneId = ZoneId.systemDefault();

		int noOfDays = schedule.getRepeat();

		Date sdate = schedule.getSdate();

		LocalDate fromDate = Instant.ofEpochMilli(sdate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		for (int i = 1; i <= noOfDays; i++) {

			LocalDate temp = fromDate.plusDays(i);

			schedule.setSdate(Date.from(temp.atStartOfDay(defaultZoneId).toInstant()));

			addSchedule(schedule);
		}
	}

	private Long generateScheduleId() {
		List<Schedule> schedules = getAllSchedule();
		Collections.sort(schedules, (a, b) -> a.getId().compareTo(b.getId()));
		if (schedules.size() == 0)
			return 1L;
		Schedule lastSchedule = schedules.get(schedules.size() - 1);
		Long id = 0L;
		if (lastSchedule != null)
			id = lastSchedule.getId();
		id++;
		return id;
	}

	@GetMapping("/schedule/{source}/{destination}")
	public Object searchFlight(@PathVariable String source, @PathVariable String destination) {
		return ss.getSourceDestination(source, destination);
	}

	@PutMapping("/schedule")
	public int modifySchedule(@RequestBody Schedule schedule) {
		return ss.update(schedule);
	}

	@DeleteMapping("/schedule/{id}")
	public int deleteSchedule(@PathVariable Long id) {
		return ss.delete(id);
	}

}
