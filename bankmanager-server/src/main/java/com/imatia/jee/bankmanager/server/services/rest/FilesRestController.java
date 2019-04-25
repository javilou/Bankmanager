package com.imatia.jee.bankmanager.server.services.rest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

@RestController
@RequestMapping("/files")
public class FilesRestController {

	@PostMapping(value = "upload")
	public ResponseEntity<String> upload(@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files, @RequestParam(name = "data", required = false) String data)
			throws JsonParseException, JsonMappingException, IOException {

		HashMap<String, Object> extraData = new HashMap<>();

		if (data != null) {
			extraData = new ObjectMapper().readValue(data, HashMap.class);
		}

		System.out.println("----- SE RECIBIO EL ARCHIVO -----");

		for (int i = 0; i < files.length; i++) {
			File file = new File(files[i].getOriginalFilename());
			File path = file.getAbsoluteFile();
			System.out.println("Nombre original del archivo: " + files[i].getOriginalFilename());
			System.out.println("Tamaño del archivo: " + files[i].getSize());
			System.out.println("Numero de archivos: " + files.length);
			System.out.println("Ruta del archivo: " + path);
		}
		return ResponseEntity.ok("-----SE SUBIO EL ARCIHVO-----");
	}

}