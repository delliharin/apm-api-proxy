package com.emc.cm.service;

import com.emc.cm.entity.ApmInstance;
import com.emc.cm.exception.DatabaseAccessException;
import com.emc.cm.exception.ProductNotFoundException;
import com.emc.cm.repository.ApmApiProxyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ApmApiProxyServiceImpl implements ApmApiProxyService{

    @Autowired
    private ApmApiProxyRepository apmApiProxyRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public String findApmById(final String id) {
        try {
            ApmInstance apmInstance = apmApiProxyRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
            System.out.println(apmInstance.getUrl());
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);

            return restTemplate.exchange(apmInstance.getUrl(), HttpMethod.GET, entity, String.class).getBody();
        } catch(DataAccessException ex) {
            throw new DatabaseAccessException("Error accessing the database");
        }
    }

}
