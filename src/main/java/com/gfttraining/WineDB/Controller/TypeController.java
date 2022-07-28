package com.gfttraining.WineDB.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gfttraining.WineDB.Model.Type;
import com.gfttraining.WineDB.Repository.TypeRepository;

@RestController
@RequestMapping("/api/type")
public class TypeController {

	@Autowired
	TypeRepository typeRepository;

	@GetMapping("findAll")
	public List<Type> findAll() {
		return typeRepository.findAll();
	}

	@GetMapping("/{id}")
	public Type findById(@PathVariable int id) {
		return typeRepository.findById(id).get();
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Type createType(@RequestBody Type wine) {
		return typeRepository.save(wine);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteType(@PathVariable int id) {
		typeRepository.deleteById(id);
	}

	@PutMapping("{id}")
	public Type updateType(@PathVariable int id, @RequestBody Type type) {
		Optional<Type> typ = typeRepository.findById(id);
		if (type.getName() == null || type.getName().isEmpty()) {
			type.setName(typ.get().getName());
		}

		type.setId(id);
		return typeRepository.save(type);
	}
}
