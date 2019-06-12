package pt.repository.impl;

import pt.domain.JuniorMechanic;
import pt.repository.JuniorMechanicRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("JuniorMechanicRepo")
public class JuniorMechanicRepositoryImpl implements JuniorMechanicRepository {

    private static JuniorMechanicRepositoryImpl repository = null;
    private Set<JuniorMechanic> juniorMechanics;

    private JuniorMechanicRepositoryImpl(){
        this.juniorMechanics = new HashSet<>();
    }

    public static JuniorMechanicRepositoryImpl getRepository(){
        if (repository == null) repository = new JuniorMechanicRepositoryImpl();
        return repository;
    }

    @Override
    public Set<JuniorMechanic> getAll() {
        return this.juniorMechanics;
    }

    @Override
    public JuniorMechanic create(JuniorMechanic juniorMechanic) {
        this.juniorMechanics.add(juniorMechanic);
        return juniorMechanic;
    }

    @Override
    public JuniorMechanic update(JuniorMechanic juniorMechanic) {

        JuniorMechanic[] cloneOfJuniorMechanics = juniorMechanics.toArray(new JuniorMechanic[juniorMechanics.size()]);
        for (int i = 0; i<cloneOfJuniorMechanics.length;i++) {
            if (cloneOfJuniorMechanics[i].equals(juniorMechanic)) {
                juniorMechanics.remove(cloneOfJuniorMechanics[i]);
            }
        }
        return create(juniorMechanic);
    }

    @Override
    public void delete(String juniorMechanicId) {
        JuniorMechanic[] cloneOfJuniorMechanics = juniorMechanics.toArray(new JuniorMechanic[juniorMechanics.size()]);
        for (int i = 0; i<cloneOfJuniorMechanics.length;i++) {
            if (cloneOfJuniorMechanics[i].getJuniorMechanicId() == juniorMechanicId) {
                if (juniorMechanics.contains(cloneOfJuniorMechanics[i])){
                    juniorMechanics.remove(cloneOfJuniorMechanics[i]);
                }
            }
        }
    }

    @Override
    public JuniorMechanic read(String juniorMechanicId) {

        JuniorMechanic juniorMechanicToReturn = null;

        JuniorMechanic[] cloneOfJuniorMechanics = juniorMechanics.toArray(new JuniorMechanic[juniorMechanics.size()]);

        for (int i = 0; i<cloneOfJuniorMechanics.length;i++) {
            if (cloneOfJuniorMechanics[i].getJuniorMechanicId() == juniorMechanicId) {
                juniorMechanicToReturn = cloneOfJuniorMechanics[i];
            }
        }

        return juniorMechanicToReturn;
    }
}