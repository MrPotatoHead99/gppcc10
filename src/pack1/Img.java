package pack1;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Img 
{
	static Font Max, Pew;
	
	public static void loadMaxFont()
	{	
	 	try 
	 	{
		    Max = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/max.ttf")).deriveFont(36f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/max.ttf")));
		} catch(FontFormatException e) 
		{
			e.printStackTrace();
			System.out.println("Fehler beim laden der Schriftart");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Fehler beim laden der Schriftart");
		} 
	}
	
	public static void loadusualFont()
	{	
	 	try 
	 	{
		    Pew = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/coders_crux.ttf")).deriveFont(28f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/coders_crux.ttf")));
		} catch(FontFormatException e) 
		{
			e.printStackTrace();
			System.out.println("Fehler beim laden der Schriftart");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Fehler beim laden der Schriftart");
		} 
	}

	public static BufferedImage load(String path, int x, int y, int w, int h){
		
		BufferedImage sheet = null;
		
		try {
			
			sheet = ImageIO.read(new File(path));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sheet.getSubimage(x, y, w, h);
		
	}
	
	public static BufferedImage load(String path){
		
		BufferedImage sprite = null;
		
		try {
			
			sprite = ImageIO.read(new File(path));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sprite;
		
	}
	
}
