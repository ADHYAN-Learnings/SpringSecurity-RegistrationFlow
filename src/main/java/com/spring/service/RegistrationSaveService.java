package com.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.model.RegistrationFlow;
import com.spring.persistence.RegistrationFlowRepository;

@Service
@Transactional
public class RegistrationSaveService implements InterfRegistrationSaveService {
	
	@Autowired
	private RegistrationFlowRepository registrationFlowRepository;

	@Override
	public RegistrationFlow save(RegistrationFlow registrationFlow) {
		return registrationFlowRepository.save(registrationFlow);
	}

}
