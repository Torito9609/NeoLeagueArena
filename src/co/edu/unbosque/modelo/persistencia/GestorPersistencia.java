package co.edu.unbosque.modelo.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GestorPersistencia <T>{
	
	public void guardarLista(String rutaArchivo, List<T> lista) throws IOException{
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
			oos.writeObject(lista);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> cargarLista(String rutaArchivo) throws IOException, ClassNotFoundException{
		File file = new File(rutaArchivo);
		if(!file.exists()) return new ArrayList<>();	
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject();
        }
	}
}
