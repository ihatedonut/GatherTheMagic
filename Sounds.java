import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
public class Sounds 
{
	private File file;

	public static void NAMENAME() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		File file = new File("NAMENAME.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
	}
	
	public static void mike() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		File file = new File("Mike.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
	}
	public static void john() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		File file = new File("John.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
	}
	
	public static void mellis() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		File file = new File("Mellis2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
	}

	public static void blocking() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		File file = new File("Blocking.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
	}

	public static void sam() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		File file = new File("Sam.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
	}

	public static void aidan() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		File file = new File("Heavenly Music Sound Effect.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
	}

	public static void cardFail() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		File file = new File("Card Fail.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
	}

	public static void returnToHand() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		File file = new File("ReturnToHand.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
	}

	public static void attack() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		File file = new File("Attack.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
	}

}
