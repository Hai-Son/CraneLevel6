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
	Integer port = 8585;
	ServerSocket socket1;
	Board board;
	Chess c;

	public MultiplayerHost(Chess c) throws IOException {
		this.c = c;
		socket1 = new ServerSocket(port);
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
		boolean live = true;
		boolean whiteturn = true;
		String incomingString = "";
		String outgoingString = "";
		Location oldLoc;
		Location newLoc;
		try {
			JOptionPane.showMessageDialog(null, "Waiting for opponent to connect...", "Multiplayer Connect",
					JOptionPane.PLAIN_MESSAGE, null);
			Socket socket2 = socket1.accept();
			Board board = new Board(c, true);
			JOptionPane.showMessageDialog(null, "Oppenent connected to the game", "Multiplayer Connect",
					JOptionPane.PLAIN_MESSAGE, null);
			DataOutputStream streamOut = new DataOutputStream(socket2.getOutputStream());
			DataInputStream streamIn = new DataInputStream(socket2.getInputStream());
			Piece p = null;
			while (live) {
				if (whiteturn) {
					outgoingString = board.getTransfer();
					streamOut.writeUTF(outgoingString);
				} else {
					incomingString = streamIn.readUTF();
					oldLoc = board.getTiles()[Integer.parseInt(incomingString.substring(0, 1))][Integer
							.parseInt(incomingString.substring(1, 2))];
					newLoc = board.getTiles()[Integer.parseInt(incomingString.substring(2, 3))][Integer
							.parseInt(incomingString.substring(3, 4))];
					if (oldLoc == null) {
						System.out.println("could not find oldLoc");
					} else {
						p = board.getPiece(oldLoc);
						if (p == null) {
							System.out.println("could not find piece");
						}
					}
					if (newLoc == null) {
						System.out.println("could not find newLoc");

					}
					if (p != null && newLoc != null) {
						board.movePieceTo(p, newLoc);
					}
					board.movePieceTo(oldLoc.getPiece(), newLoc);
				}
				whiteturn = !whiteturn;
			}
			socket2.close();
		} catch (SocketTimeoutException e) {
			System.out.println("SocketTimeoutException Caught");
			live = false;
		} catch (IOException e) {
			System.out.println("IOException Caught");
			live = false;
		}
	}
}