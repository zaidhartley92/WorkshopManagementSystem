package pt.repository.impl;

import pt.domain.Reception;
import pt.repository.ReceptionRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("SecretaryRepo")
public class ReceptionRepositoryImpl implements ReceptionRepository {

    private static ReceptionRepositoryImpl repository = null;
    private Set<Reception> receptions;

    private ReceptionRepositoryImpl(){
        this.receptions = new HashSet<>();
    }

    public static ReceptionRepositoryImpl getRepository(){
        if (repository == null) repository = new ReceptionRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Reception> getAll() {
        return this.receptions;
    }

    @Override
    public Reception create(Reception reception) {
        this.receptions.add(reception);
        return reception;
    }

    @Override
    public Reception update(Reception reception) {

        Reception[] cloneOfReceptions = receptions.toArray(new Reception[receptions.size()]);
        for (int i = 0; i< cloneOfReceptions.length; i++) {
            if (cloneOfReceptions[i].equals(reception)) {
                receptions.remove(cloneOfReceptions[i]);
            }
        }
        return create(reception);
    }

    @Override
    public void delete(String secretaryId) {
        Reception[] cloneOfReceptions = receptions.toArray(new Reception[receptions.size()]);
        for (int i = 0; i< cloneOfReceptions.length; i++) {
            if (cloneOfReceptions[i].getSecretaryId() == secretaryId) {
                if (receptions.contains(cloneOfReceptions[i])){
                    receptions.remove(cloneOfReceptions[i]);
                }
            }
        }
    }

    @Override
    public Reception read(String secretaryId) {

        Reception receptionToReturn = null;

        Reception[] cloneOfReceptions = receptions.toArray(new Reception[receptions.size()]);

        for (int i = 0; i< cloneOfReceptions.length; i++) {
            if (cloneOfReceptions[i].getSecretaryId() == secretaryId) {
                receptionToReturn = cloneOfReceptions[i];
            }
        }

        return receptionToReturn;
    }
}