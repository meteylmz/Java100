package main;

import java.io.IOException;

import main.reader.readFile;

public class mainClass {

	public static void main(String[] args){
		
		readFile myReader = new readFile();
		
		myReader.readWords("file.txt");
		myReader.readLineAt("file.txt", 2);

	}

}
