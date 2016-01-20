package de.brockhaus.domain;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

public interface SensorRepository extends CassandraRepository<Sensor> {
	
	@Query("SELECT*FROM sensors WHERE name=?0 LIMIT ?1")
    //@Query("SELECT * FROM sensors WHERE name=?0")
	Iterable<Sensor> findByName(String name,Integer limit);

}
