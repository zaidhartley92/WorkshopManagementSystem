package pt.repository;

import pt.domain.Window;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface WindowRepository extends IRepository<Window, String>{

    Set<Window> getAll();

}