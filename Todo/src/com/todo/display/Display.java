package com.todo.display;

import com.todo.fileoperation.FileOperation;

/**
 * @createdAt 13-July-2020
 * @author Mitendra
 * @description
 *              <p>
 *              Class for display the print statements
 *              </p>
 */
public class Display {

	/**
	 * <p>
	 * This method for print options
	 * </p>
	 */
	public void printOptions() {
		// print statements
		System.out.println("Enter the option (in Number)");
		System.out.println("1.To insert a TODO task");
		System.out.println("2.To update a TODO task");
		System.out.println("3.To delete a TODO task");
		System.out.println("4.To list all the TODO task");
		System.out.println("Enter the option (in Number)");
	}

	/**
	 * <p>
	 * This method for print continuation
	 * </p>
	 */
	public void printProceed() {
		// print statement
		System.out.println("Press y to continue...");

	}

	/**
	 * <p>
	 * This method for print list of all todo tasks
	 * </p>
	 */
	public void displayAllTodoList() {
		int count=1;
		// traverse fileRecords list and print
		for (String list : FileOperation.fileRecords) {
			System.out.println(count+". " +list);
			count++;
		}
		// when list is empty 
		if (FileOperation.fileRecords.size() == 0) {
			System.out.println("No item Todo in list.");
		}
	}

}
