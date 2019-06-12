package pt.repository.impl;

import pt.domain.Manager;
import pt.repository.ManagerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ManagerRepo")
public class ManagerRepositoryImpl implements ManagerRepository {

    private static ManagerRepositoryImpl repository = null;
    private Set<Manager> managers;

    private ManagerRepositoryImpl(){
        this.managers = new HashSet<>();
    }

    public static ManagerRepositoryImpl getRepository(){
        if (repository == null) repository = new ManagerRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Manager> getAll() {
        return this.managers;
    }

    @Override
    public Manager create(Manager manager) {
        this.managers.add(manager);
        return manager;
    }

    @Override
    public Manager update(Manager manager) {

        Manager[] cloneOfManagers = managers.toArray(new Manager[managers.size()]);
        for (int i = 0; i<cloneOfManagers.length;i++) {
            if (cloneOfManagers[i].equals(manager)) {
                managers.remove(cloneOfManagers[i]);
            }
        }
        return create(manager);
    }

    @Override
    public void delete(String managerId) {
        Manager[] cloneOfManagers = managers.toArray(new Manager[managers.size()]);
        for (int i = 0; i<cloneOfManagers.length;i++) {
            if (cloneOfManagers[i].getManagerId() == managerId) {
                if (managers.contains(cloneOfManagers[i])){
                    managers.remove(cloneOfManagers[i]);
                }
            }
        }
    }

    @Override
    public Manager read(String managerId) {

        Manager managerToReturn = null;

        Manager[] cloneOfManagers = managers.toArray(new Manager[managers.size()]);

        for (int i = 0; i<cloneOfManagers.length;i++) {
            if (cloneOfManagers[i].getManagerId() == managerId) {
                managerToReturn = cloneOfManagers[i];
            }
        }

        return managerToReturn;
    }
}