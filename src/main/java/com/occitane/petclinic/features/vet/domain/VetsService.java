package com.occitane.petclinic.features.vet.domain;

import com.occitane.petclinic.features.vet.common.VetMapper;
import com.occitane.petclinic.features.vet.dao.PagedVetEntity;
import com.occitane.petclinic.features.vet.dao.VetDAO;
import com.occitane.petclinic.features.vet.dao.VetEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VetsService implements VetsInventory {

	private final VetDAO vetsDao;
	private final VetMapper vetMapper;

	public VetsService(VetDAO vetsDao, VetMapper vetMapper) {
		this.vetsDao = vetsDao;
		this.vetMapper = vetMapper;
	}

	@Override
	public Vets findAll(int currentPage, int pageSize) {
		final PagedVetEntity pagedVets = vetsDao.findAll(currentPage, pageSize);
		var vets = vetMapper.entityToDomain(pagedVets.vets());
		return Vets.of(vets, pagedVets.numberOfElements(), pagedVets.totalPages());
	}

	@Override
	public Vets findAll() {
		final Collection<VetEntity> vets = vetsDao.findAll();
		return Vets.of(vetMapper.entityToDomain(vets));
	}
}
