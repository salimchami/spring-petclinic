package com.fnac.petclinic.features.vet.dao;

import java.util.List;

public record PagedVetEntity(List<VetEntity> vets, int numberOfElements, int totalPages) {


}
