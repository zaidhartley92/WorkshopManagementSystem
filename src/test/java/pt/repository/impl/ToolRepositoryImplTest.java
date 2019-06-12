package pt.repository.impl;

import org.junit.Test;

import pt.domain.Tool;
import pt.factory.ToolFactory;
import pt.repository.ToolRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@FixMethodOrder(MethodSorters.DEFAULT)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class ToolRepositoryImplTest {

    @Autowired
    private ToolRepository repository;
    private Tool tool;

    private Tool getSavedTool(){
        Set<Tool> savedTools = this.repository.getAll();
        return savedTools.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = ToolRepositoryImpl.getRepository();
        this.tool = ToolFactory.getTool("Test Tool");
    }

    @Test
    public void create() {

        Tool testCreate = this.repository.create(this.tool);
        Assert.assertSame(testCreate, this.tool);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        Tool savedTool = getSavedTool();
        this.repository.delete(savedTool.getToolId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another tool after deleting so that Read() has something to read.
        this.repository.create(this.tool);

    }

    @Test
    public void read() {

        Tool savedTool = getSavedTool();
        String id = savedTool.getToolId();
        Tool readTool = this.repository.read(id);
        Assert.assertEquals(savedTool, readTool);
    }

    @Test
    public void update() {

        Tool saved = getSavedTool();
        String id = saved.getToolId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Tool> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}