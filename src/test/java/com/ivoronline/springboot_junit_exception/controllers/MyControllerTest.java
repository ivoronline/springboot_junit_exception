package com.ivoronline.springboot_junit_exception.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyControllerTest {

  @Autowired MyController myController;

  //===============================================================
  // assertThrows() - Lambda
  //===============================================================
  @Test
  void hello1() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> myController.hello() ); //Check Type
    assertEquals("Argument is missing", exception.getMessage());                                     //Check Message
  }

  //===============================================================
  // assertThrows() - Executable
  //===============================================================
  @Test
  void hello2() {

    //CHECK TYPE
    Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        myController.hello();
      }
    });

    //CHECK MESSAGE
    assertEquals("Argument is missing", exception.getMessage());

  }

  //===============================================================
  // TRY - CATCH
  //===============================================================
  @Test
  void hello3() {
    try {
      myController.hello();
      fail();                                                            //Fail if no Exception was thrown
    }
    catch (IllegalArgumentException exception) {                         //Catch Excpetions of expected Type
      assertEquals("Argument is missing", exception.getMessage());       //Fail if Message is wrong
    }
    catch(Exception exception) {
      fail();                                                            //Fail if Exception is of wrong Type
    }
  }

}
