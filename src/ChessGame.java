import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class ChessGame
{

    public static final int WHITE =0;
    public static final int BLACK =1;
    public static final int PLAYING = 2;
    public static final int WHITE_WINS =3;
    public static final int BLACK_WINS =4;
	public static final int TRANSFORMATION_WHITE = 5;
	public static final int TRANSFORMATION_BLACK = 6;
    public static final int ONE_PLAYER =7;
    public static final int TWO_PLAYER =8;
    public static final int STALEMATE =9;



    private Piece[][] board;
    private int turn;
    private int playerAmount;
	ArrayList<Piece> pieces;
	private ArrayList<String> messages;
	private ArrayList<Integer> killedWhitePieces;
	private ArrayList<Integer> killedBlackPieces;
	private LinkedList<ArrayList<Piece>> ll = new LinkedList<>();
    private LinkedList<ArrayList<Integer>> llW = new LinkedList<>();
    private LinkedList<ArrayList<Integer>> llB = new LinkedList<>();



    private int status;
 
    public ChessGame()
    {
        Scanner keyboard = new Scanner(System.in);
        board = new Piece[8][8];
        pieces = new ArrayList<Piece>();
		messages = new ArrayList<>();
		killedWhitePieces = new ArrayList<>();
		killedBlackPieces = new ArrayList<>();
        reset();
        printBoard();
        
    }
    
    public void reset()
    {
    	turn = WHITE;
    	pieces.clear();
    	status = PLAYING;
		pieces.clear();
    	messages.clear();
    	killedBlackPieces.clear();
    	killedWhitePieces.clear();
    	messages.add("Press 1 for single player and 2 for multiplayer");
    	playerAmount=0;
		
		for(int x = 2;x<8;x+=3)
		{
			pieces.add(new Bishop(0,x,WHITE, true,4, false));
			pieces.add(new Bishop(7,x,BLACK, true,4, false));
		}
		for(int x = 0;x<8;x++)
		{
			pieces.add(new Pawn(1,x,WHITE, true,1, false));
			pieces.add(new Pawn(6,x,BLACK, true,1,false));
		}
		for(int x = 0;x<8;x+=7)
		{
			pieces.add(new Rook(0,x,WHITE, true,2, false));
			pieces.add(new Rook(7,x,BLACK, true,2, false));
		}
		for(int x = 1;x<8;x+=5)
		{
			pieces.add(new Knight(0,x,WHITE, true,3,false));
			pieces.add(new Knight(7,x,BLACK, true,3,false));
		}
		pieces.add(new King(0,4,WHITE, true,6, false));
		pieces.add(new Queen(0,3,WHITE, true,5,false));
		pieces.add(new Queen(7,4,BLACK, true,5,false));
		pieces.add(new King(7,3,BLACK, true,6,false));

		updateBoard();
		// doesn't set the empty spaces to null or a different value
//		for(int x=0;x<pieces.size();x++)
//		{
//			board[pieces.get(x).getRow()][pieces.get(x).getCol()] = pieces.get(x);
//		}
    }
    
    public void printBoard()
	{
		int s = 0;
		for(int x = 0;x<8;x++)
		{
			for(int y = 0;y<8;y++)
			{
				if(board[x][y]==null)
					System.out.print("0 ");
				else 
					System.out.print(board[x][y].getType()+" ");
			}
			System.out.print("\n");
		}
	}
    public Piece movePiece(int oldr, int oldc, int r, int c, Piece p)
   	{
//   	    ll.addLast((ArrayList<Piece>)pieces.clone());
//        llW.addLast((ArrayList<Integer>)killedWhitePieces.clone());
//        llB.addLast((ArrayList<Integer>)killedBlackPieces.clone());

   		Piece piece = null;
   		updateBoard();
    	for(int x=0;x<pieces.size();x++)
    	{
    		if(pieces.get(x).getRow()==r && pieces.get(x).getCol()==c && pieces.get(x).getColor()!=p.getColor())
    		{
    			piece = pieces.remove(x);
    			if(piece.getColor()==WHITE)
    				killedWhitePieces.add(piece.getType());
    			else
    				killedBlackPieces.add(piece.getType());
    		}
    	}
//    	if(p.getType()==6 && p.getRow()==0&& c-oldc==2 && p.getColor()==WHITE)
//		{
//			for(int x=0;x<pieces.size();x++)
//			{
//				if(pieces.get(x).equals(board[0][7]) && pieces.get(x).hasMoved()==false)
//				{
//      //              piece = new Rook(pieces.get(x).getRow(),pieces.get(x).getCol(),pieces.get(x).getColor(),true, 2,false);
//					pieces.get(x).setCol(5);
//					pieces.get(x).setHasMoved(true);
////                    p.setRow(r);
////                    p.setCol(c);
////                    p.setHasMoved(true);
//				}
//			}
//			System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
//		}
//		else if(p.getType()==6 &&  p.getRow()==0&& c-oldc==-2 && p.getColor()==WHITE)
//		{
//			for(int x=0;x<pieces.size();x++)
//			{
//				if(pieces.get(x).equals(board[0][0]) && pieces.get(x).hasMoved()==false)
//				{
//       //             piece = new Rook(pieces.get(x).getRow(),pieces.get(x).getCol(),pieces.get(x).getColor(),true, 2,false);
//					pieces.get(x).setCol(3);
//					pieces.get(x).setHasMoved(true);
////                    p.setRow(r);
////                    p.setCol(c);
////                    p.setHasMoved(true);
//				}
//			}
//			System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
//		}
//		else if(p.getType()==6 && p.getRow()==7&& c-oldc==2 && p.getColor()==BLACK)
//		{
//			for(int x=0;x<pieces.size();x++)
//			{
//				if(pieces.get(x).equals(board[7][7]) && pieces.get(x).hasMoved()==false)
//				{
//      //              piece = new Rook(pieces.get(x).getRow(),pieces.get(x).getCol(),pieces.get(x).getColor(),true, 2,false);
//					pieces.get(x).setCol(4);
//					pieces.get(x).setHasMoved(true);
////                    p.setRow(r);
////                    p.setCol(c);
////                    p.setHasMoved(true);
//				}
//			}
//			System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
//		}
//		else if(p.getType()==6 &&  p.getRow()==7&& c-oldc==-2 && p.getColor()==BLACK)
//		{
//			for(int x=0;x<pieces.size();x++)
//			{
//				if(pieces.get(x).equals(board[7][0]) && pieces.get(x).hasMoved()==false)
//				{
//      //              piece = new Rook(pieces.get(x).getRow(),pieces.get(x).getCol(),pieces.get(x).getColor(),true, 2,false);
//					pieces.get(x).setCol(2);
//					pieces.get(x).setHasMoved(true);
////                    p.setRow(r);
////                    p.setCol(c);
////                    p.setHasMoved(true);
//				}
//			}
//			System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
//		}
	//	else {


            p.setRow(r);
            p.setCol(c);
            p.setHasMoved(true);
     //   }

    	return piece;
   	}
	public void revertMovePiece(int oldr, int oldc, Piece p, Piece pp, boolean hasMoved)
	{
//	    pieces = ll.removeLast();
//	    killedWhitePieces=llW.removeLast();
//	    killedBlackPieces=llB.removeLast();
		if(pp!=null)
		{
			pieces.add(pp);
			if(pp.getColor()==WHITE)
				killedWhitePieces.remove(Integer.valueOf(pp.getType()));
			else
				killedBlackPieces.remove(Integer.valueOf(pp.getType()));
		}

		p.setRow(oldr);
		p.setCol(oldc);
		p.setHasMoved(hasMoved);
		if(status==TRANSFORMATION_BLACK || status==TRANSFORMATION_WHITE)
			status=PLAYING;
		updateBoard();

	}
    public void setNull(int r, int c)
    {
    	board[r][c]=null;
    }
    public ArrayList<Piece> getPieces()
    {
    	return pieces;
    }
    public void updateBoard()
    {
    	int s = 0;
		for(int x = 0;x<8;x++)
		{
			for(int y = 0;y<8;y++)
			{
				for(int a=0;a<pieces.size();a++)
				{
					if(pieces.get(a).getRow()==x && pieces.get(a).getCol()==y)
					{
						board[x][y] = pieces.get(a);
						s=1;
					}
				}
				if(s==0)
					board[x][y] = null;

				s=0;
			}
		}
    }
 

    public Piece[][] getBoard()
    {
    	return board;
    }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTurn()
    {
    	return turn;
    }
    public void setTurn(int x)
    {
    	turn = x;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public ArrayList<String> getMessages() {
		return messages;
	}

	public ArrayList<Integer> getKilledWhitePieces() {
		return killedWhitePieces;
	}

	public ArrayList<Integer> getKilledBlackPieces() {
		return killedBlackPieces;
	}

    public int getPlayerAmount() {
        return playerAmount;
    }

    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
    }
}