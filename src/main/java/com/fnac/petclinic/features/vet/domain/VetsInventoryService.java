package com.fnac.petclinic.features.vet.domain;

import com.fnac.petclinic.features.vet.common.VetMapper;
import com.fnac.petclinic.features.vet.dao.VetEntity;
import com.fnac.petclinic.features.vet.dao.VetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VetsInventoryService implements VetsInventory {

	private final VetRepository vetsRepository;
	private final VetMapper vetMapper;

	public VetsInventoryService(VetRepository vetRepository, VetMapper vetMapper) {
		this.vetsRepository = vetRepository;
		this.vetMapper = vetMapper;
	}

	@Override
	public Vets findAll(int currentPage, int pageSize) {
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
		final Page<VetEntity> pagedVets = vetsRepository.findAll(pageable);
		var vets = vetMapper.entityToDomain(pagedVets.getContent());
		return Vets.of(vets, pagedVets.getNumberOfElements(), pagedVets.getTotalPages());
	}

	@Override
	public Vets findAll() {
		final Collection<VetEntity> vets = vetsRepository.findAll();
		return Vets.of(vetMapper.entityToDomain(vets));
	}
}
