package pt.service.impl;

import pt.domain.Tool;
import pt.repository.ToolRepository;
import pt.repository.impl.ToolRepositoryImpl;
import pt.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ToolServiceImpl implements ToolService {

    @Autowired
    @Qualifier("ToolRepo")
    private static ToolServiceImpl service = null;
    private ToolRepository repository;

    private ToolServiceImpl(){
        this.repository = ToolRepositoryImpl.getRepository();
    }

    public static ToolService getService(){
        if (service == null) service = new ToolServiceImpl();
        return service;
    }

    @Override
    public Tool create(Tool tool) {
        return this.repository.create(tool);
    }

    @Override
    public Tool update(Tool tool) {
        return this.repository.update(tool);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Tool read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Tool> getAll() {
        return repository.getAll();
    }

}