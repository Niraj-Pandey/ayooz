package de.brockhaus.rest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.brockhaus.domain.Sensor;
import de.brockhaus.domain.SensorRepository;

/**
 * @author z.ouftou
 */
@RestController
public class SensorController {

	@Autowired
	private SensorRepository sensorRepo;

	@PostConstruct
	public void initData() {
		sensorRepo.deleteAll();
		sensorRepo.save(new Sensor("0001", "oilpression"));
		sensorRepo.save(new Sensor("0002", "temperature"));
	}

	@RequestMapping("/")
	public String index() {
		return "<center></br><h1>*** Brockhaus Gruppe ***</h1></br><h2> Docker Spring Cassandra Example</h2></center>";
	}

	@RequestMapping(value = "/sensor/{name}")
	public Sensor getSensor(@PathVariable("name") String pName) {
		return (Sensor) sensorRepo.findByName(pName, 1);
	}

	@RequestMapping("/sensors")
	public List<Sensor> getAllSensors() {
		return (List<Sensor>) sensorRepo.findAll();
	}
}
