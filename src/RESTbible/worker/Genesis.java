package RESTbible.worker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Charles R. Edwards Jr.
 *
 */
public class Genesis {
	public static void main(String[] args) {

		System.out.println("Found = " + searchGenesis("the"));
	}

	/** Search of the Genesis 1 text called from the Bible Service class
	 * @param word
	 * @return User word input to be searched.
	 */
	public static int searchGenesis(String word) {
		File file = new File("C:\\Users\\CJ Edwards\\WorkspaceCST-235\\RESTful_Bible\\genesis.txt");
		int count = 0;
		BufferedReader buff;
		try {
			buff = new BufferedReader(new FileReader(file));

			String line;
			while ((line = buff.readLine()) != null) {
				if (line.contains(word))
					count++;
			}
			buff.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return count;
	}

}
