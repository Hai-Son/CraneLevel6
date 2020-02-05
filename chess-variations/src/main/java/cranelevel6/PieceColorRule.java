package cranelevel6;

public class PieceColorRule extends Rule {
	boolean white;

	PieceColorRule(boolean white) {
		this.white = white;

	}

	boolean isValid(Piece p, Location l) {
		if (p.isWhite() != white) {
			return false;
		}

		return super.isValid(p, l);
	}

}