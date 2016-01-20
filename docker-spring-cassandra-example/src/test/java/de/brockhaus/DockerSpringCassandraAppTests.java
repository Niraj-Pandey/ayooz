package de.brockhaus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.brockhaus.DockerSpringCassandraApp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DockerSpringCassandraApp.class)
@WebAppConfiguration
public class DockerSpringCassandraAppTests {

	@Test
	public void contextLoads() {
	}

}
