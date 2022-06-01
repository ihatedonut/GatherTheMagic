import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client 
{
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private Socket socket;
	private String username;
	private TestGUI game;
	
	public Client(Socket socket)
	{
		game = new TestGUI(this);
		try
		{
			this.socket = socket;
			this.username = username;
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		}
		catch (IOException e)
		{
			closeEverything(socket, bufferedReader, bufferedWriter);
		}	
	}
	
	public void sendMessage()
	{
		try
		{
			Scanner scanner = new Scanner(System.in);
			while (socket.isConnected())
			{
				String messageToSend = scanner.nextLine();
				bufferedWriter.write(messageToSend);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		}
		catch (IOException e)
		{
			closeEverything(socket, bufferedReader, bufferedWriter);
		}
	}
	
	public void listenForMessages()
	{
		new Thread(new Runnable() {
			@Override
			public void run()
			{
				String message;
				
				while (socket.isConnected())
				{
					try
					{
						message = bufferedReader.readLine();
						System.out.println(message);
					}
					catch (IOException e)
					{
						closeEverything(socket, bufferedReader, bufferedWriter);
					}
				}
			}
		}).start();
	}
	
	public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter)
	{
		try
		{
			if (bufferedReader != null)
			{
				bufferedReader.close();
			}
			if (bufferedWriter != null)
			{
				bufferedWriter.close();
			}
			if (socket != null)
			{
				socket.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		Socket socket = new Socket("127.0.0.1",1234);
		Client client = new Client(socket);
		client.listenForMessages();
		client.sendMessage();
	}
}
