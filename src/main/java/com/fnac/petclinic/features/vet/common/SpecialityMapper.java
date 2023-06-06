package com.fnac.petclinic.features.vet.common;

import com.fnac.petclinic.features.vet.dao.SpecialtyEntity;
import com.fnac.petclinic.features.vet.domain.Speciality;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SpecialityMapper {
	public Collection<Speciality> entityToDomain(Collection<SpecialtyEntity> specialities) {
		return specialities.stream().map(this::entityToDomain).toList();
	}
	public Speciality entityToDomain(SpecialtyEntity specialty) {
		return new Speciality(specialty.getName());
	}

	public Collection<Speciality> domainToDto(Collection<Speciality> specialities) {
		return specialities.stream().map(this::domainToDto).toList();
	}
	public Speciality domainToDto(Speciality speciality) {
		return new Speciality(speciality.name());
	}
}
