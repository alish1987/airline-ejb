package com.airline.service;

import com.airline.models.Pilot;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class PilotService {
    @PersistenceContext(unitName = "airline")
    EntityManager entityManager;

    public PilotService() {

    }

    public void addPilot(Pilot pilot) {
        entityManager.persist(pilot);

    }
}
