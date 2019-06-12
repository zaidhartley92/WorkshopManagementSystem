package pt.service.impl;

import pt.domain.Tool;
import pt.factory.ToolFactory;
import pt.service.ToolService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class ToolServiceImplTest {

    private ToolService service;
    private Tool tool;

    private Tool getSavedTool(){
        Set<Tool> savedTools = this.service.getAll();
        return savedTools.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = ToolServiceImpl.getService();
        this.tool = ToolFactory.getTool("Test Tool");
    }

    @Test
    public void create() {

        Tool testCreate = this.service.create(this.tool);
        Assert.assertSame(testCreate, this.tool);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Tool savedTool = getSavedTool();
        this.service.delete(savedTool.getToolId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another tool after deleting so that Read() has something to read.
        this.service.create(this.tool);

    }

    @Test
    public void read() {

        Tool savedTool = getSavedTool();
        String id = savedTool.getToolId();
        Tool readTool = this.service.read(id);
        Assert.assertEquals(savedTool, readTool);
    }

    @Test
    public void update() {

        Tool saved = getSavedTool();
        String id = saved.getToolId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Tool> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}