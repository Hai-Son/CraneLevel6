package cranelevel6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.swing.JOptionPane;

public class MultiplayerJoin {
	Integer port = 8585;
	String hostIP;
	Board board;
	Chess c;

	public MultiplayerJoin(Chess c) throws IOException {
		this.c = c;
		hostIP = JOptionPane.showInputDialog(null, "Enter Your Opponent's IP Adress", "Multiplayer Connect",
				JOptionPane.PLAIN_MESSAGE);
	}

	public void run() {
		boolean live = true;
		boolean whiteturn = true;
		String incomingString = "";
		String outgoingString = "";
		Location oldLoc;
		Location newLoc;
		try {
			Socket socket = new Socket(hostIP, port);
			Board board = new Board(c, true);
			JOptionPane.showMessageDialog(null, "You connected to the game", "Multiplayer Connect",
					JOptionPane.PLAIN_MESSAGE, null);
			DataOutputStream streamOut = new DataOutputStream(socket.getOutputStream());
			DataInputStream streamIn = new DataInputStream(socket.getInputStream());
			Piece p = null;
			while (live) {
				if (whiteturn) {
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
				} else {
					// get outgoingMove data from local board
					outgoingString = "7172";
					streamOut.writeUTF(outgoingString);
				}
				whiteturn = !whiteturn;
			}
			socket.close();
		} catch (SocketTimeoutException e) {
			System.out.println("SocketTimeoutException Caught");
			live = false;
		} catch (IOException e) {
			System.out.println("IOException Caught");
			live = false;
		}
	}
}
