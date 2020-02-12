package cranelevel6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class MultiplayerJoin {
	String hostIP;

	public MultiplayerJoin() throws IOException {
		hostIP = JOptionPane.showInputDialog(null, "Enter Your Opponent's IP Adress", "Multiplayer Connect",
				JOptionPane.PLAIN_MESSAGE);
	}

	public void run() {
		Integer port = 8585;
		try {
			Socket sock = new Socket(hostIP, port);
			DataOutputStream streamOut = new DataOutputStream(sock.getOutputStream());
			streamOut.writeUTF("join test");
			DataInputStream streamIn = new DataInputStream(sock.getInputStream());
			System.out.println(streamIn.readUTF());
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
