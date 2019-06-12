package pt.service;
import pt.domain.Tool;

import java.util.Set;

public interface ToolService extends IService<Tool, String>{
    Set<Tool> getAll();
}
