/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fnac.petclinic.features.vet.web;

import com.fnac.petclinic.features.vet.common.VetMapper;
import com.fnac.petclinic.features.vet.domain.Vets;
import com.fnac.petclinic.features.vet.domain.VetsInventory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
class VetController {

	private final VetsInventory vetsInventory;
	private final VetMapper vetMapper;

	public VetController(VetsInventory vetsInventory, VetMapper vetMapper) {
		this.vetsInventory = vetsInventory;
		this.vetMapper = vetMapper;
	}

	@GetMapping("/vets.html")
	public String showVetList(@RequestParam(defaultValue = "1") int page, Model model) {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects so it is simpler for Object-Xml mapping
		// FIXME: info de pagination pageSize : devrait être envoyée par le client.
		int pageSize = 5;
		final Vets vetsList = vetsInventory.findAll(page, pageSize);
		vetMapper.addVetListToModelDTO(vetsList, model, page);
		return "vets/vetList";
	}

	@GetMapping({"/vets"})
	public @ResponseBody VetsDTO showResourcesVetList() {
		var vets = this.vetsInventory.findAll();
		return vetMapper.domainToDto(vets);
	}

}
