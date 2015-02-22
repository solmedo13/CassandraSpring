package cassandraexample.sergio.olmedo.CassandraSpring;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cassandraexample.sergio.olmedo.CassandraSpring.Persona.Persona;
import cassandraexample.sergio.olmedo.CassandraSpring.cassandraconfiguration.CassandraConfiguration;
import cassandraexample.sergio.olmedo.CassandraSpring.service.PersonaService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext app= new AnnotationConfigApplicationContext(CassandraConfiguration.class);
    	PersonaService servicio=app.getBean(PersonaService.class);
    	ArrayList<Persona> personas = new ArrayList<Persona>();
    	ArrayList<Double> lista = new ArrayList<Double>();
    	for (int i=0;i<100;i++){
    		lista.add(2.854);
    		lista.add(2.824);
    		lista.add(4.854);
    		lista.add(6.854);
    		
    		personas.add(new Persona(i,"pepe",lista));
    		
    		
    	}
    	for(int i=0;i<1000;i++){
    		System.out.println(i);
    	servicio.guardar(personas);
    	}
    	System.out.println("FIN");
    	
       
       
    }
}
