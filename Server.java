import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
	private ServerSocket serverSocket;
	private int numClients;
	private int startingPlayer;
	
	public Server(ServerSocket serverSocket)
	{
		this.serverSocket = serverSocket;
		startingPlayer = (int)(Math.random()*2 + 1);
		numClients = 0;
	}
	
	public void startServer()
	{
		try
		{
			while(!(serverSocket.isClosed()))
			{
				if (numClients < 2)
				{
					Socket socket = serverSocket.accept();
					numClients++;
					System.out.println("New client connected!");
					ClientHandler clientHandler;
					if (numClients == startingPlayer)
					{
						clientHandler = new ClientHandler(socket, "Client" + numClients, true);
					}
					else
					{
						clientHandler = new ClientHandler(socket, "Client" + numClients, false);
					}
					Thread thread = new Thread(clientHandler);
					thread.start();
				}
			}
		}
		catch (IOException e)
		{}
	}
	
	public void closeServerSocket()
	{
		try
		{
			if (serverSocket != null)
			{
				serverSocket.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		ServerSocket serverSocket = new ServerSocket(5000);
		Server server = new Server(serverSocket);
		server.startServer();
	}
}

