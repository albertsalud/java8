package com.albertsalud.spring.videoclub.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.albertsalud.spring.videoclub.config.AppConfig;
import com.albertsalud.spring.videoclub.model.Film;

@Component
public class CSVFileReader {
	
	
	private final int ID = 0;
	private final int TITLE = 1;
	private final int YEAR = 2;
	private final int GENRES = 3;
	
	@Autowired
	private AppConfig appConfig;
	
	public CSVFileReader() {}
	
	public List<Film> readFile(){
		List<Film> result = new ArrayList<Film>();
		
		try {
			result = Files.lines(Paths.get(ResourceUtils.getFile(appConfig.getCsvPath()).toURI()))
				.skip(1)
				.map(line -> {
					String[] filmValues = line.split(appConfig.getFieldsSeparator());
					
					return new Film(Long.valueOf(filmValues[ID]), filmValues[TITLE], 
							filmValues[YEAR], Arrays.asList(filmValues[GENRES].split(appConfig.getListsSeparator())));
					
				}).collect(Collectors.toList());
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	public static void main(String[] args) {
		CSVFileReader csvReader = new CSVFileReader();
		List<Film> films = csvReader.readFile();
		
		System.out.println("Peliculas cargadas en memoria: " + films.size());
	}

}
