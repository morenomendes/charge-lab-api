package ca.charge.lab.home;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.charge.lab.station.model.service.Station;
import ca.charge.lab.station.service.StationService;

@RestController
@RequestMapping("/stations")
public class StationController {
	
	@Autowired
	private  StationService stationService;
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public Station stations(@NotNull @PathVariable("id") Integer id) {
		return stationService.findById(id);
	}
	

	@GetMapping
	@ResponseBody
	public ResponseEntity<Collection<Station>>stations() {
		
		Collection<Station> models = stationService.findAll();
		
		if(models != null && !models.isEmpty()) {
			return new ResponseEntity<>(models, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}	
		
	@RequestMapping("/testeStations")
	public String teste() {
		return "testeStations";
	}

	
}
