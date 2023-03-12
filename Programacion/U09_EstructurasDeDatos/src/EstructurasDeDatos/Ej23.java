package EstructurasDeDatos;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Ej23 {
	//CREATE HASHMAP FOR THE PIECES VALUE
	private static HashMap<String, Integer> piecesValue = new HashMap<String, Integer>();
	
	//CREATE HASHMAP TO SAVE THE NUMBER OF EACH PIECE
	private static HashMap<String, Integer> numberOfPieces = new HashMap<String, Integer>();

	public static void main(String[] args) {
		//SPECIFY THE VALUE OF THE PAWN
		final int PAWN = 1;
		
		//FILL PIECES VALUE
		piecesValue.put("queen", PAWN*9);
		piecesValue.put("rook", PAWN*5);
		piecesValue.put("bishop", PAWN*3);
		piecesValue.put("knight", PAWN*2);
		piecesValue.put("pawn", PAWN);
		
		//FILL NUMBER OF PIECES
		numberOfPieces.put("queen", 1);
		numberOfPieces.put("rook", 2);
		numberOfPieces.put("bishop", 2);
		numberOfPieces.put("knight", 2);
		numberOfPieces.put("pawn", 8);
		
		//GET RANDOM NUMBER BETWEEN 0 AND 14
		int numberOfPiecesCaptured = (int) (Math.round(Math.random() * totalPieces()));
		
		//GET CAPTURED PIECES
		ArrayList<String> capturedPieces = capturePieces(numberOfPiecesCaptured);
		
		//CALCULATE TOTAL VALUE AND PRINT
		int totalValue = 0;

		System.out.printf("%d captured pieces: %n", numberOfPiecesCaptured);
		for(String piece: capturedPieces) {
			int pieceValue = piecesValue.get(piece);
			System.out.printf("%s (%d pawns)%n", piece, pieceValue);
			totalValue += pieceValue;
		}
		System.out.printf("Total value of the pieces captured: %d%n", totalValue);
				
	}
	
	private static ArrayList<String> listOfPieces() {
		//CREATE ARRAYLIST
		ArrayList<String> listOfPieces = new ArrayList<String>();
		for(Map.Entry<String, Integer> entry: numberOfPieces.entrySet()) {
			for(int i = 0; i < entry.getValue(); i++) {
				//SAVE ALL OF THE PIECES
				listOfPieces.add(entry.getKey());
			}
		}
		return listOfPieces;
	}
	private static ArrayList<String> capturePieces(int amount) {
		//GET THE LIST OF PIECES
		ArrayList<String> listOfPieces = listOfPieces();
		
		//CREATE ARRAYLIST FOR CAPTURED PIECES
		ArrayList<String> capturedPieces = new ArrayList<String>();
		for(int i = 0; i < amount; i++) {
			//CREATE RANDOM NUMBER BETWEEN 0 AND LAST INDEX OF THE ARRYLIST OF PIECES
			int pieceIndex = (int) (Math.round(Math.random() * (listOfPieces.size() -1)));
			
			//ADD PIECE TO CAPTURED PIECES
			capturedPieces.add(listOfPieces.get(pieceIndex));
			//REMOVE PIECE FROM LIST OF PIECES
			listOfPieces.remove(pieceIndex);
		}
		return capturedPieces;
	}
	private static int totalPieces() {
		int counter = 0;
		for(Map.Entry<String, Integer> entry: numberOfPieces.entrySet()) {
			counter += entry.getValue();
		}
		return counter;
	}
}
