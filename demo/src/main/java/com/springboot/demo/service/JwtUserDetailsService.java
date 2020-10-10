package com.springboot.demo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	private static final Logger logger = LogManager.getLogger(JwtUserDetailsService.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<String> usuarios = new ArrayList<>();
		
		try {
			usuarios = obtenerUsuariosTxt("C:\\usuarios.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (usuarios.contains(username)) {
			return new User(username, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
		} else {
			logger.info("Datos incorrectos en el logueo");
			throw new UsernameNotFoundException("Usuario no encontrado con username: " + username);
		}
		
	}
	
	public List<String> obtenerUsuariosTxt(String archivo) throws IOException {
		
		String cadena = "";
		List<String> registros = new ArrayList<>();
		List<String> usuarios = new ArrayList<>();
		
		FileReader fileReader = new FileReader(archivo);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		// Extraemos los registros del archivo de texto
		while ((cadena = bufferedReader.readLine()) != null) {
			registros.add(cadena);
		}
		
		bufferedReader.close();
		
		// Recorremos cada registro del archivo de texto
		for (String registro : registros) {
			String[] credenciales = registro.split(",");

			for (int i = 0; i < credenciales.length;) {
				// Agregamos el usuario a la lista
				usuarios.add(credenciales[i]);
				break;
			}	
		}
		
		return usuarios;
	}

}
