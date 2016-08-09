
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Main m = new Main();
		m.parseHands();

	}

	public void parseHands() {

		ArrayList<String> list = new ArrayList<String>();

		try {
			for (String line : Files.readAllLines(Paths.get("poker.txt"))) {
				list.add(line.substring(0, 14));
				list.add(line.substring(14, 29));
			}

			System.out.println(list.toString());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
