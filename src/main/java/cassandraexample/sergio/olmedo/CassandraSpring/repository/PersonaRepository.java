package cassandraexample.sergio.olmedo.CassandraSpring.repository;

import java.util.ArrayList;

import org.springframework.data.cassandra.repository.CassandraRepository;

import cassandraexample.sergio.olmedo.CassandraSpring.Persona.Persona;

public interface PersonaRepository extends CassandraRepository<Persona> {
	


}
