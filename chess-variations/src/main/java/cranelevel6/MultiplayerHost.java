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

	public MultiplayerHost() throws IOException {
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
				System.out.println("Waiting for client to connect...");
				Socket socket2 = socket1.accept();
				System.out.println("Client connected to server");
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
