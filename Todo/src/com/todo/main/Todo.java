package com.todo.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.todo.common.TodoConstants.YES;
import static com.todo.common.TodoMessages.INVALID_INPUT;

import com.todo.display.Display;
import com.todo.fileoperation.FileOperation;
import com.todo.operation.TodoOperations;

/**
 * @createdAt 13-July-2020
 * @author Mitendra
 * @description
 *              <p>
 *              This class contains main method for application start.
 *              </p>
 */
public class Todo {

	/**
	 * <p>
	 * This method responsible for application start and provide
	 * input output functionality
	 * </p>
	 * 
	 * @param args
	 *            for command line input
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// Variable declaration
		String inputOption, inputProceed, inputToBeUpdate, inputTask;

		// calling init method to initialize arraylist from file
		FileOperation.init();

		// object creation of Display TodoOperations class
		Display display = new Display();
		TodoOperations todoOperations = new TodoOperations();

		// for input from command line
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader bufferReader = new BufferedReader(reader);

		do {
			// display the options
			display.printOptions();

			// input the options
			inputOption = bufferReader.readLine();

			// switch statements
			switch (inputOption) {
			// case for creating ToDo task
			case "1":
				System.out.println("Enter the ToDo task for create");
				inputTask = bufferReader.readLine();
				todoOperations.createOperation(inputTask);
				break;
			// case for update ToDO task
			case "2":
				display.displayAllTodoList();
				System.out.println("enter the record number");
				inputTask = bufferReader.readLine();
				System.out.println("Enter the ToDo task ");
				inputToBeUpdate = bufferReader.readLine();
				todoOperations.updateOperation(inputTask, inputToBeUpdate);
				break;
			// case for delete ToDO task
			case "3":
				display.displayAllTodoList();
				System.out.println("enter the record number");
				inputTask = bufferReader.readLine();
				todoOperations.deleteOperation(inputTask);
				break;
			// case for display all ToDO task
			case "4":
				display.displayAllTodoList();
				break;
			default:
				System.out.println(INVALID_INPUT);
			}
			// printing message for continuing the operations
			display.printProceed();
			inputProceed = bufferReader.readLine();

		} while (YES.equalsIgnoreCase(inputProceed));

		// close bufferReader connection
		bufferReader.close();
		System.out.println("Thanks !! For Using ToDo List");

	}

}
