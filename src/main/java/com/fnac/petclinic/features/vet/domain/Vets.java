package com.fnac.petclinic.features.vet.domain;

import java.util.Collection;
import java.util.Objects;

public final class Vets {
	private final Collection<Vet> vetsList;
	private final Integer totalVetsCount;
	private final Integer totalPages;

	public static Vets of(Collection<Vet> vetsList, int totalVetsCount, int totalPages) {
		return new Vets(vetsList, totalVetsCount, totalPages);
	}
	public static Vets of(Collection<Vet> vetsList) {
		return new Vets(vetsList, null, null);
	}

	private Vets(Collection<Vet> vetsList, Integer totalVetsCount, Integer totalPages) {
		this.vetsList = vetsList;
		this.totalVetsCount = totalVetsCount;
		this.totalPages = totalPages;
	}

	public Collection<Vet> vetsList() {
		return vetsList;
	}

	public int totalVetsCount() {
		return totalVetsCount;
	}

	public int totalPages() {
		return totalPages;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = (Vets) obj;
		return Objects.equals(this.vetsList, that.vetsList) &&
			Objects.equals(this.totalVetsCount, that.totalVetsCount) &&
			Objects.equals(this.totalPages, that.totalPages);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vetsList, totalVetsCount, totalPages);
	}

	@Override
	public String toString() {
		return "Vets[" +
			"vetsList=" + vetsList + ", " +
			"totalVetsCount=" + totalVetsCount + ", " +
			"totalPages=" + totalPages + ']';
	}


}
