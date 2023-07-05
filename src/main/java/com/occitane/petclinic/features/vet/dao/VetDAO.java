package com.occitane.petclinic.features.vet.dao;

import java.util.Collection;

public interface VetDAO {
	PagedVetEntity findAll(int currentPage, int pageSize);

	Collection<VetEntity> findAll();
}
