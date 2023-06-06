package com.fnac.petclinic.features.vet.domain;

import java.util.Collection;

public record Vet(Collection<Speciality> specialities, String firstName, String lastName) {

	@Override
	public Collection<Speciality> specialities() {
		return specialities.stream().sorted().toList();
	}
}
