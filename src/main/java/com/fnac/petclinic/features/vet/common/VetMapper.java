package com.fnac.petclinic.features.vet.common;

import com.fnac.petclinic.features.vet.dao.VetEntity;
import com.fnac.petclinic.features.vet.domain.Vet;
import com.fnac.petclinic.features.vet.domain.Vets;
import com.fnac.petclinic.features.vet.web.VetDTO;
import com.fnac.petclinic.features.vet.web.VetsDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Collection;

@Component
public class VetMapper {

	private final SpecialityMapper specialityMapper;

	public VetMapper(SpecialityMapper specialityMapper) {
		this.specialityMapper = specialityMapper;
	}

	public void addVetListToModelDTO(Vets vets, Model model, int currentPage) {
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", vets.totalPages());
		model.addAttribute("totalItems", vets.totalVetsCount());
		var vetsDTO = domainToDto(vets.vetsList());
		model.addAttribute("listVets", vetsDTO.getVetList());
	}

	public VetsDTO domainToDto(Vets vets) {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects, so it is simpler for JSon/Object mapping
		return domainToDto(vets.vetsList());
	}

	public VetsDTO domainToDto(Collection<Vet> vets) {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects, so it is simpler for JSon/Object mapping
		return new VetsDTO(vets.stream().map(this::domainToDto).toList());
	}

	public VetDTO domainToDto(Vet vet) {
		return new VetDTO(specialityMapper.domainToDto(vet.specialities()), vet.firstName(), vet.lastName());
	}

	public Collection<Vet> entityToDomain(Collection<VetEntity> vets) {
		return vets.stream().map(this::entityToDomain).toList();
	}
	public Vet entityToDomain(VetEntity vet) {
		var specialities = specialityMapper.entityToDomain(vet.getspecialities());
		return new Vet(specialities, vet.getFirstName(), vet.getLastName());
	}
}
