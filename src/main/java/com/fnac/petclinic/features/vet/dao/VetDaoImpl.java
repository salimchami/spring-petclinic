package com.fnac.petclinic.features.vet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class VetDaoImpl implements VetDAO {

	private final VetRepository vetRepository;

	public VetDaoImpl(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public PagedVetEntity findAll(int currentPage, int pageSize) {
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
		final Page<VetEntity> pagedVets = vetRepository.findAll(pageable);
		return new PagedVetEntity(pagedVets.getContent(), pagedVets.getNumberOfElements(), pagedVets.getTotalPages());
	}

	@Override
	public Collection<VetEntity> findAll() {
		return vetRepository.findAll();
	}
}
