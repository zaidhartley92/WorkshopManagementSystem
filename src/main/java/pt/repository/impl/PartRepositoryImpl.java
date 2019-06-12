package pt.repository.impl;

import pt.domain.Part;
import pt.repository.PartRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("PartRepo")
public class PartRepositoryImpl implements PartRepository {

    private static PartRepositoryImpl repository = null;
    private Set<Part> parts;

    private PartRepositoryImpl(){
        this.parts = new HashSet<>();
    }

    public static PartRepositoryImpl getRepository(){
        if (repository == null) repository = new PartRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Part> getAll() {
        return this.parts;
    }

    @Override
    public Part create(Part part) {
        this.parts.add(part);
        return part;
    }

    @Override
    public Part update(Part part) {

        Part[] cloneOfParts = parts.toArray(new Part[parts.size()]);
        for (int i = 0; i<cloneOfParts.length;i++) {
            if (cloneOfParts[i].equals(part)) {
                parts.remove(cloneOfParts[i]);
            }
        }
        return create(part);
    }

    @Override
    public void delete(String partId) {
        Part[] cloneOfParts = parts.toArray(new Part[parts.size()]);
        for (int i = 0; i<cloneOfParts.length;i++) {
            if (cloneOfParts[i].getPartId() == partId) {
                if (parts.contains(cloneOfParts[i])){
                    parts.remove(cloneOfParts[i]);
                }
            }
        }
    }

    @Override
    public Part read(String partId) {

        Part partToReturn = null;

        Part[] cloneOfParts = parts.toArray(new Part[parts.size()]);

        for (int i = 0; i<cloneOfParts.length;i++) {
            if (cloneOfParts[i].getPartId() == partId) {
                partToReturn = cloneOfParts[i];
            }
        }

        return partToReturn;
    }
}