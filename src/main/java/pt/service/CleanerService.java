package pt.service;
import pt.domain.Cleaner;

import java.util.Set;

public interface CleanerService extends IService<Cleaner, String>{

    Set<Cleaner> getAll();

}
