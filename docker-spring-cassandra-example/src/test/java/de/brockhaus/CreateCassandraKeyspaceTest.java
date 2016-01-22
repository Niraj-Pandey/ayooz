package de.brockhaus;

import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import de.brockhaus.domain.Sensor;

/**
 * @author Z.OUFTOU
 */
public class CreateCassandraKeyspaceTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreateCassandraKeyspaceTest.class);
	private static Cluster cluster;
	private static Session session;
	
	private static String keyspace="brockhaus";
	private static String host="52.49.84.99";
	private static int port=9042;

	public static void main(String[] args) {

		try {

	        cluster = Cluster.builder().addContactPointsWithPorts(Collections.singletonList(new InetSocketAddress(host, port))).build();
			session = cluster.connect();

            session.execute("CREATE KEYSPACE IF NOT EXISTS " + keyspace + " with replication = {'class':'SimpleStrategy', 'replication_factor':1}");
            session.execute("USE " + keyspace);
            session.execute("CREATE TABLE IF NOT EXISTS " + keyspace + ".sensors (\n" +
                    "    id text PRIMARY KEY,\n" +
                    "    name text,\n" +
                    ")");
            session.execute("CREATE INDEX IF NOT EXISTS name_idx ON " + keyspace + ".sensors (name)");
	        
			
			CassandraOperations cassandraOps = new CassandraTemplate(session);

			final String[] columns = new String[] { "id","name" };

			Select select = QueryBuilder.select(columns).from("sensors");
			select.where(QueryBuilder.eq("id", "0001"));

			LOGGER.info(select.toString());
			final List<Sensor> results = cassandraOps.select(select, Sensor.class);

			LOGGER.info("Spring Data Cassandra Example");
			LOGGER.info("==============================");

			for (Sensor sensor : results) {
				LOGGER.info("Sensor Id is: " + sensor.getId());
				LOGGER.info("Sensor Name is: " + sensor.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cluster.close();
		}
	}
}
