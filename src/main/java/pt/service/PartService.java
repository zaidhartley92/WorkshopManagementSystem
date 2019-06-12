package pt.service;
import pt.domain.Part;

import java.util.Set;

public interface PartService extends IService<Part, String>{
    Set<Part> getAll();
}
