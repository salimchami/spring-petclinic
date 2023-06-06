package com.occitane.petclinic.features.vet.web;

import com.occitane.petclinic.features.vet.domain.Speciality;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Collection;

@XmlRootElement
public class VetDTO {

	@XmlElement
	private final Collection<Speciality> specialities;
	@XmlElement
	private final String firstName;
	@XmlElement
	private final String lastName;
	@XmlElement
	private final int nrOfSpecialities;

	public VetDTO(Collection<Speciality> specialities, String firstName, String lastName) {
		this.specialities = specialities;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nrOfSpecialities = specialities.size();
	}

	public Collection<Speciality> getSpecialities() {
		return specialities;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getNrOfSpecialities() {
		return nrOfSpecialities;
	}
}
