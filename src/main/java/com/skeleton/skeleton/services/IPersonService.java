package com.skeleton.skeleton.services;

import com.skeleton.skeleton.pojos.service.request.PersonServiceRequest;
import com.skeleton.skeleton.pojos.service.response.PersonServiceResponse;
import org.springframework.stereotype.Service;

@Service
public interface IPersonService {

  PersonServiceResponse createNewPerson(final PersonServiceRequest request);
}
