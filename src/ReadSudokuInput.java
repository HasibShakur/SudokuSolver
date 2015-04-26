import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Hasib
 *
 */
public class ReadSudokuInput {

	/**
	 * @param args
	 * @throws IOException 
	 * Enter the filename with full path, cnf file name and for an N*N sudoku enter N
	 */
	public static void main(String[] args) throws IOException {
		String inputFileNameWithPath = args[0];
		String cnfFileName = args[1];
		BufferedReader inputReader = new BufferedReader(new FileReader(inputFileNameWithPath));
		String line = null;
		int N = Integer.parseInt(args[2]);
		int[][] sudoku = new int[N][N];
		for(int i=0;i<N;i++)
		{
			try {
				line = inputReader.readLine();
				line = line.trim();
				line = line.replaceAll(" ", "");
				//Remove all the middle spaces Space
				for(int j=0;j<line.length();j++)
				{
					sudoku[i][j] = Integer.parseInt(line.substring(j, j+1));
					
				}
				line = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		inputReader.close();
		SudokuToCnf scnf = new SudokuToCnf();
		scnf.generateCnf(cnfFileName,sudoku, N);
	}

}
