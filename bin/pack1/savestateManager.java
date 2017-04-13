package pack1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class savestateManager 
{
	static File localFolder = new File("Savestate");
	static File localFile = new File("Savestate/Save.txt");
	static boolean gespeichert = false; //Wird für den beenden Knopf gebraucht
	
	public savestateManager() 
	{
		createFile(localFolder, localFile);
		load(localFile);
		save(localFile);
	}

	public static void load(File localFile) 
	{
		File localfile = localFile;
		if(localfile.exists()) //Besteht datei bereits?
		{
			try 
			{
				Scanner sc = new Scanner(localfile);
				while(sc.hasNextLine()) //Solange Datei nicht leer
				{
					System.out.println(sc.nextLine()); //gebe nächste Zeile aus (später Variablen mit gelesenen gleichsetzen)
				}
			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
				System.out.println("Fehler beim laden");
			}
		}else //Falls Datei nicht vorhanden, datein sollen erstellt werden
		{
			createFile(localFolder, localFile);
		}
	}


	public static void save(File localFile) 
	{
		File localfile = localFile;
		//Falls zu speichernede Variablen als int vorliegen, vorher in String umwandeln!
		String contetnsToWrite = "Variable 1: 27\nVariable 2: 5";
		try //Versuche datei zu öffnen, zu schreiben und datei zu schließen
		{
			OutputStream out = new FileOutputStream(localfile); //File wird geöffnet
			out.write(contetnsToWrite.getBytes()); //File wird beschrieben
			out.close(); //File wird geschlossen
			//gespeichert = true; //dieser Wert muss später verändert werden, wenn eine Speichervariable verändert wird
		} catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("Fehler beim speichern");
			gespeichert = false;
		}
		
	}

	public static void createFile(File localFolder, File localFile) 
	{
		File localfolder = localFolder;
		File localfile = localFile;
		
		if(!localfolder.exists())
		{
			localfolder.mkdirs(); //Falls Order noch nicht vorhanden, Ordner wird erstellt
			System.out.println("Neuer ordner " + localfolder.getName() + "wurde erstellt");
		}
		
		if(!localfile.exists())
		{
			try 
			{
				localfile.createNewFile(); //Falls Textdatei noch nicht vorhanden, Datei wird erstellt
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Fehler beim erstellen der Savestate Datei!");
			} 
			System.out.println("Neue Datei " + localfile.getName() + "wurde erstellt");
		}
	}

}
