import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable 
{
	public static ArrayList<ClientHandler> clientHandlers = new ArrayList<ClientHandler>();
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String clientUsername;
	
	public ClientHandler(Socket socket, String username, boolean b)
	{
		try 
		{
			this.socket = socket;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.clientUsername = username;
			System.out.println(clientUsername);
			clientHandlers.add(this);
			broadcastMessage("SERVER: " + clientUsername + " has connected");
			if (b)
			{
				broadcastToSelf("Your Turn - Starting Turn");
			}
			
		}
		catch (IOException e)
		{
			closeEverything(socket, bufferedReader, bufferedWriter);
		}
			
	}
	
	@Override
	public void run()
	{
		String messageFromClient;
		
		while (socket.isConnected())
		{
			try 
			{
				messageFromClient = bufferedReader.readLine();
				broadcastMessage(messageFromClient);
			}
			catch (IOException e)
			{
				closeEverything(socket, bufferedReader, bufferedWriter);
				break;
			}
		}
	}
	
	public void broadcastMessage(String messageToSend)
	{
		for (ClientHandler clientHandler: clientHandlers)
		{
			try
			{
				if (!(clientHandler.clientUsername.equals(clientUsername)))
				{
					clientHandler.bufferedWriter.write(messageToSend);
					clientHandler.bufferedWriter.newLine();
					clientHandler.bufferedWriter.flush();
				}
			}
			catch (IOException e)
			{
				closeEverything(socket, bufferedReader, bufferedWriter);
			}
		}
	}
	public void broadcastToSelf(String messageToSend)
	{
		for (ClientHandler clientHandler : clientHandlers)
		{
			try
			{
				if (clientHandler.clientUsername.equals(clientUsername))
				{
					clientHandler.bufferedWriter.write(messageToSend);
					clientHandler.bufferedWriter.newLine();
					clientHandler.bufferedWriter.flush();
				}
			}
			catch (IOException e)
			{
				closeEverything(socket, bufferedReader, bufferedWriter);
			}
		}
	}
	
	public void removeClientHandler()
	{
		clientHandlers.remove(this);
		broadcastMessage("SERVER: " + clientUsername + " has lost connection!");
	}
	
	public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter)
	{
		removeClientHandler();
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
}
