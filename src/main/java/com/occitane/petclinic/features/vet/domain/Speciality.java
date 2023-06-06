package com.occitane.petclinic.features.vet.domain;

import java.util.Comparator;

public record Speciality(String name) implements Comparable<Speciality> {

	@Override
	public int compareTo(Speciality o) {
		return Comparator.comparing(Speciality::name).compare(this, o);
	}
}
