package pt.service;

import pt.domain.Bay;

import java.util.Set;


public interface BayService extends IService<Bay, String>{

    Set<Bay> getAll();

}
