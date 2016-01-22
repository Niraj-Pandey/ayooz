FROM java:8 

# Install maven
RUN apt-get update  
RUN apt-get install -y maven

WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml  
RUN ["mvn", "dependency:resolve"]  
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /code/src

# Set env variables of cassandra database
#ENV cassandra.contactpoints 172.17.0.2
#ENV cassandra.port 9042
#ENV cassandra.keyspace brockhaus

RUN ["mvn", "package"]

EXPOSE 8080
  
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"] 