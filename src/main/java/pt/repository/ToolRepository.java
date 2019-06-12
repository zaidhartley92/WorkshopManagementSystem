package pt.repository;

import pt.domain.Tool;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ToolRepository extends IRepository<Tool, String>{

    Set<Tool> getAll();

}