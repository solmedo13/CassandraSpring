package cassandraexample.sergio.olmedo.CassandraSpring.Persona;

import java.util.ArrayList;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.Indexed;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Entity
@Table
public class Persona {
	@PrimaryKey
	int id;
	@Column
	String nombre;
	@ElementCollection
	ArrayList<Double> sueldos;

	public Persona(int i, String string, ArrayList<Double> lista) {
		// TODO Auto-generated constructor stub
		this.id=i;
		this.nombre=string;
		this.sueldos=lista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Double> getSueldos() {
		return sueldos;
	}

	public void setSueldos(ArrayList<Double> sueldos) {
		this.sueldos = sueldos;
	}

}
