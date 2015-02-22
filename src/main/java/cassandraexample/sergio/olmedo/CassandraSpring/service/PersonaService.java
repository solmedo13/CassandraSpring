package cassandraexample.sergio.olmedo.CassandraSpring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cassandraexample.sergio.olmedo.CassandraSpring.Persona.Persona;
import cassandraexample.sergio.olmedo.CassandraSpring.repository.PersonaRepository;
@Service
public class PersonaService {
	@Autowired 
	private PersonaRepository repository;
	
	public void guardar(ArrayList<Persona> personas){
		repository.save(personas);
		
	}

}
