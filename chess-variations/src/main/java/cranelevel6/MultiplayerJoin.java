package cranelevel6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class MultiplayerJoin {
	String hostIP;
	Board board;
	Chess c;

	public MultiplayerJoin(Chess c) throws IOException {
		this.c = c;
		hostIP = JOptionPane.showInputDialog(null, "Enter Your Opponent's IP Adress", "Multiplayer Connect",
				JOptionPane.PLAIN_MESSAGE);
	}

	public void run() {
		Integer port = 8585;
		try {
			Socket socket = new Socket(hostIP, port);
			Board board = new Board(c);
			JOptionPane.showMessageDialog(null, "You connected to the game", "Multiplayer Connect",
					JOptionPane.PLAIN_MESSAGE, null);
			DataOutputStream streamOut = new DataOutputStream(socket.getOutputStream());
			streamOut.writeUTF("join test");
			DataInputStream streamIn = new DataInputStream(socket.getInputStream());
			System.out.println(streamIn.readUTF());
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
