package pt.repository.impl;

import pt.domain.Tool;
import pt.repository.ToolRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ToolRepo")
public class ToolRepositoryImpl implements ToolRepository {

    private static ToolRepositoryImpl repository = null;
    private Set<Tool> tools;

    private ToolRepositoryImpl(){
        this.tools = new HashSet<>();
    }

    public static ToolRepositoryImpl getRepository(){
        if (repository == null) repository = new ToolRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Tool> getAll() {
        return this.tools;
    }

    @Override
    public Tool create(Tool tool) {
        this.tools.add(tool);
        return tool;
    }

    @Override
    public Tool update(Tool tool) {

        Tool[] cloneOfTools = tools.toArray(new Tool[tools.size()]);
        for (int i = 0; i<cloneOfTools.length;i++) {
            if (cloneOfTools[i].equals(tool)) {
                tools.remove(cloneOfTools[i]);
            }
        }
        return create(tool);
    }

    @Override
    public void delete(String toolId) {
        Tool[] cloneOfTools = tools.toArray(new Tool[tools.size()]);
        for (int i = 0; i<cloneOfTools.length;i++) {
            if (cloneOfTools[i].getToolId() == toolId) {
                if (tools.contains(cloneOfTools[i])){
                    tools.remove(cloneOfTools[i]);
                }
            }
        }
    }

    @Override
    public Tool read(String toolId) {

        Tool toolToReturn = null;

        Tool[] cloneOfTools = tools.toArray(new Tool[tools.size()]);

        for (int i = 0; i<cloneOfTools.length;i++) {
            if (cloneOfTools[i].getToolId() == toolId) {
                toolToReturn = cloneOfTools[i];
            }
        }

        return toolToReturn;
    }
}
