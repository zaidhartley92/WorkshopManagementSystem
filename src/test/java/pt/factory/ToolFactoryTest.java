package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Tool;

public class ToolFactoryTest {

    //Create
    @Test
    public void getTool() {

        String name = "ADP 3";
        Tool tool = ToolFactory.getTool(name);
        System.out.println(tool);
        Assert.assertNotNull(tool.getToolId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Tool tool = ToolFactory.getTool(name);
        System.out.println(tool);
        Assert.assertEquals("ADP 3", tool.getName());
    }

    //Update
    @Test
    public void updateTool() {

        String name ="ADP 3";
        Tool tool = ToolFactory.getTool(name);
        tool.setName("Fun");
        System.out.println(tool);
        Assert.assertEquals("Fun", tool.getName());
    }

    //Delete
    @Test
    public void deleteTool() {

        String name = "ADP 3";
        Tool tool = ToolFactory.getTool(name);
        tool = null;
        System.out.println(tool);
        Assert.assertNull(tool);
    }
}