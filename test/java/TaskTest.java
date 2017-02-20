import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class TaskTest {


//check whether the test instantiate correctly
  @Test
  public void Task_instantiatesCorrectly_true() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(true, myTask instanceof Task);
  }

  //check whether the test take the arguement

 @Test
   public void Task_instantiatesWithDescription_String() {
     Task myTask = new Task("Mow the lawn");
     assertEquals("Mow the lawn", myTask.getDescription());
   }


   //whether a task has been completed
   @Test
   public void isCompleted_isFalseAfterInstantiation_false() {
     Task myTask = new Task("Mow the lawn");
     assertEquals(false, myTask.isCompleted());
   }

   //time
   @Test
   public void getCreatedAt_instantiatesWithCurrentTime_today() {
     Task myTask = new Task("Mow the lawn");
     assertEquals(LocalDateTime.now().getDayOfWeek(), myTask.getCreatedAt().getDayOfWeek());
   }

   //Retrieving a List of All Objects
   @Test
     public void all_returnsAllInstancesOfTask_true() {
       Task firstTask = new Task("Mow the lawn");
       Task secondTask = new Task("Buy groceries");
       assertEquals(true, Task.all().contains(firstTask));
       assertEquals(true, Task.all().contains(secondTask));
     }

     //clearing task
     @Test
     public void clear_emptiesAllTasksFromArrayList_0() {
       Task myTask = new Task("Mow the lawn");
       Task.clear();
       assertEquals(Task.all().size(), 0);
     }

     //Assigning Unique IDs
     @Test
     public void getId_tasksInstantiateWithAnID_1() {
       Task.clear();  // Remember, the test will fail without this line! We need to empty leftover Tasks from previous tests!
       Task myTask = new Task("Mow the lawn");
       assertEquals(1, myTask.getId());
     }

     //Finding Specific Objects
     @Test
     public void find_returnsTaskWithSameId_secondTask() {
       Task firstTask = new Task("Mow the lawn");
       Task secondTask = new Task("Buy groceries");
       assertEquals(Task.find(secondTask.getId()), secondTask);
     }
}