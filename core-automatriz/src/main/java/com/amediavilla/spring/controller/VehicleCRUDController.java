package com.amediavilla.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amediavilla.spring.exception.ProductNotFoundException;
import com.amediavilla.spring.model.optionals.OptionalProductFactory;
import com.amediavilla.spring.model.vehicles.AbstractProduct;
import com.amediavilla.spring.model.vehicles.VehicleFactory;
import com.amediavilla.spring.repository.ProductRepository;

@RestController
@RequestMapping("/vehicles")
public class VehicleCRUDController {

	@Autowired
	private ProductRepository productRepo;

	// Listar
	@GetMapping("/")
	public List<AbstractProduct> getAllVehicles() {
		return this.productRepo.findAll();
	}

	// Listar por id
	@GetMapping("/{id}")
	public ResponseEntity<AbstractProduct> getVehicleById(@PathVariable(value = "id") Long VehicleId)
			throws ProductNotFoundException {
		AbstractProduct auto = findVehicle(VehicleId);

		return ResponseEntity.ok().body(auto);
	}

	// Crear auto con adicionales
	// TODO Se guarda toda la estructura con el ultimo adicional como referente
	@PostMapping("/create")
	public AbstractProduct createVehicle(@RequestBody VehicleRequest request) throws ProductNotFoundException {
		AbstractProduct v = null;
		// parse
		if (!request.getCarCode().isEmpty()) {
			v = VehicleFactory.getInstance().createVehicleByCode(request.getCarCode());
		}
		if (request.getOptionalCodes() != null) {
			for (String code : request.getOptionalCodes()) {
				v = OptionalProductFactory.getInstance().addOptionalProductByCode(code, v);
			}
		}
		this.productRepo.save(v);

		return v;
	}

	// Modificar auto
	/*
	 * @PutMapping("/{id}") public ResponseEntity<AbstractProduct>
	 * updateVehicle(@PathVariable(value = "id") Long VehicleId,
	 * 
	 * @Validated @RequestBody AbstractProduct modifiedAuto) throws
	 * ProductNotFoundException {
	 * 
	 * AbstractProduct auto = findVehicle(VehicleId);
	 * auto.setName(modifiedAuto.getName());
	 * 
	 * return ResponseEntity.ok().body(this.productRepo.save(auto)); }
	 */

	// Eliminar auto -
	// TODO Esta eliminando con el id del ultimo adicional agregado
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteVehicleById(@PathVariable(value = "id") Long VehicleId)
			throws ProductNotFoundException {
		AbstractProduct auto = findVehicle(VehicleId);

		this.productRepo.delete(auto);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return response;
	}

	private AbstractProduct findVehicle(Long id) throws ProductNotFoundException {
		AbstractProduct auto = productRepo.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Car not found by ID: " + id));
		return auto;
	}
}
