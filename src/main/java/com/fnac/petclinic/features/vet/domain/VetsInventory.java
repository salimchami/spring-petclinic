package com.fnac.petclinic.features.vet.domain;

public interface VetsInventory {
	Vets findAll(int currentPage, int pageSize);
	Vets findAll();
}
