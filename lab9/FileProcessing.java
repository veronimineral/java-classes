import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.awt.Point;

public class FileProcessing{
	public static void readFile(String myFile){
        Charset charset = Charset.forName("UTF-8");
        String outputFile = "";
		int currentLine = 0;
		int imgWidth = 0;
		int imgHeight = 0;
        int numberOfLines;
		List<Point> pointsList = new ArrayList<Point>();
	

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(myFile), charset)){
			String line = null;
			while ((line = reader.readLine()) != null){	
				if (currentLine == 0){
					String[] data = line.split(" ");
					imgWidth = Integer.parseInt(data[0]);
					imgHeight = Integer.parseInt(data[1]);
					outputFile = data[2];
				}
				else if (currentLine == 1){
					numberOfLines = Integer.valueOf(line);
				}
				else{
					String[] data = line.split(",");
					int x = Integer.parseInt(data[0]);
					int y = Integer.parseInt(data[1]);
					pointsList.add(new Point(x, y));
				}

                currentLine++;
			}

    	}
		catch (NumberFormatException e){
			System.err.println("Zawartość pliku jest nieprawidłowa.");
		} 
		catch (IOException e){
			System.err.println("Nie można odczytać danych z podanego pliku.");
		}
		catch(Exception e){
			System.err.println("Blad!");
		}

		int[][] outputData = new int[imgWidth][imgHeight];
		List<Double> distancesList = new ArrayList<Double>();
        
		for(int i = 0; i < imgWidth; ++i){
			for (int j = 0; j < imgHeight; ++j){
				distancesList.clear();
				outputData[i][j] = 0;
				for(int k = 0; k < pointsList.size(); ++k){
					double distance = Math.hypot(i - j, (int)pointsList.get(k).getX() - (int)pointsList.get(k).getY());
					distancesList.add(distance);
				}

				Collections.sort(distancesList);

				if (distancesList.size() > 1 && Math.abs(distancesList.get(0) - distancesList.get(1)) < 0.1){
					outputData[i][j] = 1;
					break;
				}
			}
		}
		
		for(int i = 0; i < pointsList.size(); ++i){
			int x = (int)pointsList.get(i).getX();
			int y = (int)pointsList.get(i).getY();
			outputData[x][y] = 2;
		}

		saveToFile(outputData, imgWidth, imgHeight, outputFile);
	}



	public static void saveToFile(int[][] outputData, int imgWidth, int imgHeight, String outputFile)	{
		StringBuilder builder = new StringBuilder();
		builder.append("P3\n");
		builder.append("#Weronika Schabowicz\n");
		builder.append(imgWidth + " " + imgHeight + "\n");
		builder.append("255\n");
		for(int i = 0; i < imgHeight; ++i){
			for(int j = 0; j < imgWidth; ++j){
				if (outputData[j][i] == 0){
					builder.append("255 255 255 ");
				}
				else if (outputData[j][i] == 1){
					builder.append("0 0 0 ");
				}
				else{
					builder.append("255 0 0 ");
				}
			}
		}

		Charset charset = Charset.forName("UTF-8");
		String str = String.valueOf(builder.toString());
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile), charset)){
			writer.write(str, 0, str.length());
		} 
		catch (IOException e){
			System.err.println("Blad zapisu do pliku.");
		}
		catch(Exception e)
		{
			System.err.println("Blad!");
		}
	}
}
