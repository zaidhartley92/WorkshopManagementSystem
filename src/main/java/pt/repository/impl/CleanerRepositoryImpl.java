package pt.repository.impl;

import pt.domain.Cleaner;
import pt.repository.CleanerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("CleanerRepo")
public class CleanerRepositoryImpl implements CleanerRepository {

    private static CleanerRepositoryImpl repository = null;
    private Set<Cleaner> cleaners;

    private CleanerRepositoryImpl(){
        this.cleaners = new HashSet<>();
    }

    public static CleanerRepositoryImpl getRepository(){
        if (repository == null) repository = new CleanerRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Cleaner> getAll() {
        return this.cleaners;
    }

    @Override
    public Cleaner create(Cleaner cleaner) {
        this.cleaners.add(cleaner);
        return cleaner;
    }

    @Override
    public Cleaner update(Cleaner cleaner) {

        Cleaner[] cloneOfCleaners = cleaners.toArray(new Cleaner[cleaners.size()]);
        for (int i = 0; i<cloneOfCleaners.length;i++) {
            if (cloneOfCleaners[i].equals(cleaner)) {
                cleaners.remove(cloneOfCleaners[i]);
            }
        }
        return create(cleaner);
    }

    @Override
    public void delete(String cleanerId) {
        Cleaner[] cloneOfCleaners = cleaners.toArray(new Cleaner[cleaners.size()]);
        for (int i = 0; i<cloneOfCleaners.length;i++) {
            if (cloneOfCleaners[i].getCleanerId() == cleanerId) {
                if (cleaners.contains(cloneOfCleaners[i])){
                    cleaners.remove(cloneOfCleaners[i]);
                }
            }
        }
    }

    @Override
    public Cleaner read(String cleanerId) {

        Cleaner cleanerToReturn = null;

        Cleaner[] cloneOfCleaners = cleaners.toArray(new Cleaner[cleaners.size()]);

        for (int i = 0; i<cloneOfCleaners.length;i++) {
            if (cloneOfCleaners[i].getCleanerId() == cleanerId) {
                cleanerToReturn = cloneOfCleaners[i];
            }
        }

        return cleanerToReturn;
    }
}