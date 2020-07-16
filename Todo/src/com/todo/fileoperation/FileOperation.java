package com.todo.fileoperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import static com.todo.common.TodoConstants.FILE_PATH_WITH_FILENAME;

/**
 * @createdAt 13-July-2020
 * @author Mitendra
 * @description
 *              <p>
 *              Class for perform operation on file
 *              </p>
 */
public class FileOperation {
	/** Initializing the arrayList */
	public static List<String> fileRecords = new ArrayList<>();

	/**
	 * <p>
	 * This method loads the records from file to arraylist
	 * </p>
	 * 
	 * @throws IOException
	 */
	public static void init() throws IOException {
		// initialize the path
		Path path = Paths.get(FILE_PATH_WITH_FILENAME);
		// check file exist in given path
		if (!Files.exists(path)) {
			// if file not exist on path then creates txt file
			Files.createFile(path);
		}
		// read all data from text file
		List<String> allLines = Files.readAllLines(path);
		// put all records in arraylist
		for (String line : allLines) {
			fileRecords.add(line);
		}

	}

	/**
	 * <p>
	 * This method write the records from arraylist to file
	 * </p>
	 * 
	 * @throws IOException
	 */
	public static void writeTask() throws IOException {
		// initialize the path
		Path path = Paths.get(FILE_PATH_WITH_FILENAME);
		// delete file if exist
		Files.deleteIfExists(path);
		// create file
		Files.createFile(path);
		// write the latest data on the file
		Files.write(path, fileRecords, StandardOpenOption.APPEND);

	}

}
