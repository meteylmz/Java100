import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name = input.nextLine().toLowerCase();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < name.length(); i++) {
			int count = 0;
			char iterator = name.charAt(i);
			for (int j = 0; j < name.length(); j++) {
				if (iterator == name.charAt(j)) {
					count++;
				}
			}
			if(iterator != ' ') {
				map.put(iterator, count);
			}
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.print(entry.getKey());
			System.out.print(entry.getValue());	
		}
	}

}
