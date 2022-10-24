package main.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class readFile{

	
	public void readWords(String text){
		
		int i;
		String word = "";
		ArrayList<Character> character = new ArrayList<>();
		ArrayList<String> str = new ArrayList<>();
		
		try {
			FileReader file = new FileReader(text);
			
			while((i = file.read()) != -1) {
				
				if((char)i == ' ') {
					
					for (int j = 0; j < character.size(); j++) {
						word += character.get(j);
					}
					str.add(word);
					word = "";
					character.clear();
				}
				else {
					character.add((char)i);
				}
			}
			for(int k = 0; k < str.size(); k++) {
				System.out.println(str.get(k));
			}
		} 
		
		catch (IOException e) {
			
			System.out.println("Dosya bulunamadı!");
		}
	}
	
	public void readLineAt(String text, int lineAt) {
		
		int i = 1;
		String line;
		
		try {
			FileReader file = new FileReader(text);
			BufferedReader buffer = new BufferedReader(file);
			
			while(i <= lineAt) {
				line = buffer.readLine();
				
				if(i == lineAt) {
					System.out.println(line);
				}
				i++;
			}
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Dosya Bulunamadı!");
		}
		
		catch (IOException e) {
			System.out.println("Dosya boş!");
		}
	}
}
