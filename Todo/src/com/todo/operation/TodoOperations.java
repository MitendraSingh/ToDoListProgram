package com.todo.operation;

import java.io.IOException;

import com.todo.fileoperation.FileOperation;

/**
 * @createdAt 13-July-2020
 * @author Mitendra
 * @description
 *              <p>
 *              Class for perform delete, update and create operation on file
 *              </p>
 */
public class TodoOperations {
	
	/**
	 * <p>
	 * This method delete the records in file
	 * </p>
	 * @param input
	 * 			record to be deleted
	 * @throws IOException
	 */
	public void deleteOperation(String input) throws IOException {
		// remove the entry from the arraylist 
		if (FileOperation.fileRecords.remove(Integer.parseInt(input)-1) == null) {
			System.out.println(input + " ToDo task is not present in list");
		} else {
			// write on the file
			FileOperation.writeTask();
		}

	}
	/**
	 * <p>
	 * This method update the records in file
	 * </p>
	 * @param input
	 * 			record to be updated
	 * @param replace
	 * 			replace value
	 * @throws IOException
	 */
	public void updateOperation(String input, String replace) throws IOException {
		// update the entry from the arraylist 
		if (FileOperation.fileRecords.set(Integer.parseInt(input)-1, replace) == null) {
			System.out.println(input + " ToDo task is not present in list");
		} else {
			// write on the file
			FileOperation.writeTask();
		}

	}
	
	/**
	 * <p>
	 * This method create the records in file
	 * </p>
	 * @param input
	 * 			record to be created
	 * @throws IOException
	 */
	public void createOperation(String input) throws IOException {
		if (input == "") {
			System.out.println(" Blank value can not be inserted in ToDo");
		} else {
			// add the task in array list
			FileOperation.fileRecords.add(input);
			// write on the file
			FileOperation.writeTask();
		}

	}

}
