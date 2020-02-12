package cranelevel6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class MultiplayerHost {
	ServerSocket socket1;
	Board board;
	Chess c;

	public MultiplayerHost(Chess c) throws IOException {
		this.c = c;
		socket1 = new ServerSocket(8585);
		String hostIP = "";
		try {
			hostIP = InetAddress.getLocalHost().getHostAddress().trim();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Your IP Address is " + hostIP, "Multiplayer Connect",
				JOptionPane.PLAIN_MESSAGE, null);
	}

	public void run() {
		boolean bool = true;
		while (bool) {
			try {
				JOptionPane.showMessageDialog(null, "Waiting for opponent to connect...", "Multiplayer Connect",
						JOptionPane.PLAIN_MESSAGE, null);
				Socket socket2 = socket1.accept();
				JOptionPane.showMessageDialog(null, "Oppenent connected to the game", "Multiplayer Connect",
						JOptionPane.PLAIN_MESSAGE, null);
				Board board = new Board(c);
				DataInputStream streamIn = new DataInputStream(socket2.getInputStream());
				System.out.println(streamIn.readUTF());
				DataOutputStream streamOut = new DataOutputStream(socket2.getOutputStream());
				streamOut.writeUTF("host test");
				socket2.close();
			} catch (SocketTimeoutException e) {
				System.out.println("SocketTimeoutException Caught");
				bool = false;
			} catch (IOException e) {
				System.out.println("IOException Caught");
				bool = false;
			}
		}

	}

}
