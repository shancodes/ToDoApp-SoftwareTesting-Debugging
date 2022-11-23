import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ToDoGUITest
{
    TodoGUI toTest;

    public ToDoGUITest() {
        CLIMenu menu = new CLIMenu();
        toTest = new TodoGUI();
    }
    @Test
    public void ToDoGUITest_TestFrameSettings_ReturnExpectedValues() {
        assertEquals(700, toTest.getSize().getWidth());
        assertEquals(300, toTest.getSize().getHeight());
        assertEquals("To Do List Application", toTest.getTitle());
        assertEquals(3, toTest.getDefaultCloseOperation());
        assertEquals(300, toTest.getLocation().x);
        assertEquals(300, toTest.getLocation().y);
    }

    @Test
    public void TestUIIsRenderedProperly()
    {
        Assertions.assertTrue(toTest.addButton.isEnabled());
        Assertions.assertTrue(toTest.updateButton.isEnabled());
        Assertions.assertTrue(toTest.deleteButton.isEnabled());
        Assertions.assertTrue(toTest.newListButton.isEnabled());
    }

    @Test
    public void actionPerformed_WhenAddToDo_GUIDisposed()
    {
        String commandName = "Add To-do";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        toTest.actionPerformed(event);
        assertEquals(false, toTest.isVisible());
    }

    @Test
    public void actionPerformed_WhenUpdateToDo_NoCurrentToDo()
    {
        String commandName = "Update To-do";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        toTest.actionPerformed(event);
        assertEquals("Please select a todo to update.", toTest.text.getText());
    }

    @Test
    public void actionPerformed_WhenDeleteToDo_NoCurrentToDo()
    {
        String commandName = "Delete To-do";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        toTest.actionPerformed(event);
        assertEquals("Please select a todo to delete.", toTest.text.getText());
    }

    @Test
    public void actionPerformed_WhenImportToDo_GUIDisposed()
    {
        String commandName = "Open Another List";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        toTest.actionPerformed(event);
        assertEquals(false, toTest.isVisible());
    }

    @Test
    public void actionPerformed_WhenUpdateToDo_GUIDisposed()
    {
        LocalDateTime time = LocalDateTime.of(2022,10,11,22,00);
        toTest.currentTodo = new Todo("Test", time, Category.Blue, Importance.High, Status.Started);
        String commandName = "Update To-do";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        toTest.actionPerformed(event);
        assertEquals(false, toTest.isVisible());
    }

    @Test
    public void actionPerformed_WhenDeleteToDo_GUIDisposed()
    {
        LocalDateTime time = LocalDateTime.of(2022,10,11,22,00);
        toTest.currentTodo = new Todo("Test", time, Category.Blue, Importance.High, Status.Started);
        String commandName = "Delete To-do";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        toTest.actionPerformed(event);
        assertEquals(false, toTest.isVisible());
    }
}
