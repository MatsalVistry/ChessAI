import java.util.ArrayList;
import java.util.Scanner;
public class ChessGame
{

    public static final int WHITE =0;
    public static final int BLACK =1;
    public static final int WHITE_WINS =8;
    public static final int BLACK_WINS =9;

    private Piece[][] board;
    private int turn;
	ArrayList<Piece> pieces;
	
	
 
    public ChessGame()
    {
        Scanner keyboard = new Scanner(System.in);

        board = new Piece[8][8];
        pieces = new ArrayList<Piece>();
        reset(pieces);
        printBoard();
        
    }
    
    public void reset(ArrayList<Piece>pieces)
    {
    	turn = WHITE;
    	pieces.clear();
		
		for(int x = 2;x<8;x+=3)
		{
			pieces.add(new Bishop(0,x,WHITE, true,4));
			pieces.add(new Bishop(7,x,BLACK, true,4));
		}
		for(int x = 0;x<8;x++)
		{
			pieces.add(new Pawn(1,x,WHITE, true,1));
			pieces.add(new Pawn(6,x,BLACK, true,1));
		}
		for(int x = 0;x<8;x+=7)
		{
			pieces.add(new Rook(0,x,WHITE, true,2));
			pieces.add(new Rook(7,x,BLACK, true,2));
		}
		for(int x = 1;x<8;x+=5)
		{
			pieces.add(new Knight(0,x,WHITE, true,3));
			pieces.add(new Knight(7,x,BLACK, true,3));
		}
		pieces.add(new King(0,4,WHITE, true,6));
		pieces.add(new Queen(0,3,WHITE, true,5));
		pieces.add(new Queen(7,4,BLACK, true,5));
		pieces.add(new King(7,3,BLACK, true,6));

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
   		Piece piece = null;
    	for(int x=0;x<pieces.size();x++)
    	{
    		if(pieces.get(x).getRow()==r && pieces.get(x).getCol()==c && pieces.get(x).getColor()!=p.getColor())
    		{
    			piece = pieces.remove(x);
    		}

    	}
    	p.setRow(r);
    	p.setCol(c);

   		updateBoard();
    	return piece;
   	}
	public void revertMovePiece(int oldr, int oldc, Piece p, Piece pp)
	{
		if(pp!=null)
			pieces.add(pp);

		p.setRow(oldr);
		p.setCol(oldc);

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
 
    public int status()
    {
    	return -1;
    }
    public Piece[][] getBoard()
    {
    	return board;
    }
    public int getTurn()
    {
    	return turn;
    }
    public void setTurn(int x)
    {
    	turn = x;
    }


}