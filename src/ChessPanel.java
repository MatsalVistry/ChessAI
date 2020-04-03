import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class ChessPanel extends JPanel implements MouseListener, KeyListener
{

    ChessGame cg = new ChessGame();
    private BufferedImage WhitePawn = null;
    private BufferedImage BlackPawn = null;
    private BufferedImage WhiteRook = null;
    private BufferedImage BlackRook = null;
    private BufferedImage WhiteKnight = null;
    private BufferedImage BlackKnight = null;
    private BufferedImage WhiteBishop = null;
    private BufferedImage BlackBishop = null;
    private BufferedImage WhiteQueen = null;
    private BufferedImage BlackQueen = null;
    private BufferedImage WhiteKing = null;
    private BufferedImage BlackKing = null;

	private BufferedImage SmallWhitePawn = null;
	private BufferedImage SmallBlackPawn = null;
	private BufferedImage SmallWhiteRook = null;
	private BufferedImage SmallBlackRook = null;
	private BufferedImage SmallWhiteKnight = null;
	private BufferedImage SmallBlackKnight = null;
	private BufferedImage SmallWhiteBishop = null;
	private BufferedImage SmallBlackBishop = null;
	private BufferedImage SmallWhiteQueen = null;
	private BufferedImage SmallBlackQueen = null;
	private BufferedImage SmallWhiteKing = null;
	private BufferedImage SmallBlackKing = null;
    private Piece selected = null;




    public ChessPanel ()
    {
        super();
        addMouseListener(this);
        addKeyListener(this);

        setSize(800,700);


        try
        {
            WhitePawn = ImageIO.read((new File("Images\\WhitePawn.JPG")));
            WhitePawn = scale(WhitePawn,75,75);
            BlackPawn = ImageIO.read((new File("Images\\BlackPawn.JPG")));
            BlackPawn = scale(BlackPawn,75,75);
            WhiteRook = ImageIO.read((new File("Images\\WhiteRook.JPG")));
            WhiteRook = scale(WhiteRook,75,75);
            BlackRook = ImageIO.read((new File("Images\\BlackRook.JPG")));
            BlackRook = scale(BlackRook,75,75);
            WhiteKnight = ImageIO.read((new File("Images\\WhiteKnight.JPG")));
            WhiteKnight = scale(WhiteKnight,75,75);
            BlackKnight = ImageIO.read((new File("Images\\BlackKnight.JPG")));
            BlackKnight = scale(BlackKnight,75,75);
            WhiteBishop = ImageIO.read((new File("Images\\WhiteBishop.JPG")));
            WhiteBishop = scale(WhiteBishop,75,75);
            BlackBishop = ImageIO.read((new File("Images\\BlackBishop.JPG")));
            BlackBishop = scale(BlackBishop,75,75);
            WhiteQueen = ImageIO.read((new File("Images\\WhiteQueen.JPG")));
            WhiteQueen = scale(WhiteQueen,75,75);
            BlackQueen = ImageIO.read((new File("Images\\BlackQueen.JPG")));
            BlackQueen = scale(BlackQueen,75,75);
            WhiteKing = ImageIO.read((new File("Images\\WhiteKing.JPG")));
            WhiteKing = scale(WhiteKing,75,75);
            BlackKing = ImageIO.read((new File("Images\\BlackKing.JPG")));
            BlackKing = scale(BlackKing,75,75);

			SmallWhitePawn = ImageIO.read((new File("Images\\WhitePawn.JPG")));
			SmallWhitePawn = scale(SmallWhitePawn,40,40);
			SmallBlackPawn = ImageIO.read((new File("Images\\BlackPawn.JPG")));
			SmallBlackPawn = scale(SmallBlackPawn,40,40);
			SmallWhiteRook = ImageIO.read((new File("Images\\WhiteRook.JPG")));
			SmallWhiteRook = scale(SmallWhiteRook,40,40);
			SmallBlackRook = ImageIO.read((new File("Images\\BlackRook.JPG")));
			SmallBlackRook = scale(SmallBlackRook,40,40);
			SmallWhiteKnight = ImageIO.read((new File("Images\\WhiteKnight.JPG")));
			SmallWhiteKnight = scale(SmallWhiteKnight,40,40);
			SmallBlackKnight = ImageIO.read((new File("Images\\BlackKnight.JPG")));
			SmallBlackKnight = scale(SmallBlackKnight,40,40);
			SmallWhiteBishop = ImageIO.read((new File("Images\\WhiteBishop.JPG")));
			SmallWhiteBishop = scale(SmallWhiteBishop,40,40);
			SmallBlackBishop = ImageIO.read((new File("Images\\BlackBishop.JPG")));
			SmallBlackBishop = scale(SmallBlackBishop,40,40);
			SmallWhiteQueen = ImageIO.read((new File("Images\\WhiteQueen.JPG")));
			SmallWhiteQueen = scale(SmallWhiteQueen,40,40);
			SmallBlackQueen = ImageIO.read((new File("Images\\BlackQueen.JPG")));
			SmallBlackQueen = scale(SmallBlackQueen,40,40);
			SmallWhiteKing = ImageIO.read((new File("Images\\WhiteKing.JPG")));
			SmallWhiteKing = scale(SmallWhiteKing,40,40);
			SmallBlackKing = ImageIO.read((new File("Images\\BlackKing.JPG")));
			SmallBlackKing = scale(SmallBlackKing,40,40);
        }
        catch(Exception e)
        {
            System.out.println("Error Loading Images: " + e.getMessage());
        }


    }
    public void paint(Graphics g)
    {
        updateStatus();
    	int xOffset = 100;
    	//if selected is true, print spheres on allowed locations
    	Color lightBrown = new Color(178, 113, 33);
        Color darkBrown = new Color(96, 58, 10);
        g.setColor(Color.white);
        g.fillRect(0,0,600+xOffset*2,700);


        for(int x=0+xOffset;x<600+xOffset;x+=75)
        {
        	for(int y=0;y<600;y+=75)
        	{
        		if(((x+y)/75)%2==0)
        		{
        			g.setColor(lightBrown);
        		}
        		else
        			g.setColor(darkBrown);
        		g.fillRect(x, y, 75, 75);
        	}
        }

        for(int x=0;x<600;x+=75)
        {
        	for(int y=0+xOffset;y<600+xOffset;y+=75)
        	{
        		if(cg.getBoard()[x/75][(y-xOffset)/75]!= null)
        		{
	        		if(cg.getBoard()[x/75][(y-xOffset)/75].getType()==1)
	        		{
	        			if(cg.getBoard()[x/75][(y-xOffset)/75].getColor()==0)
	            		{
	            			g.drawImage(WhitePawn,y,x,null);
	            		}
	        			else
	            			g.drawImage(BlackPawn,y,x,null);
	        		}
	        		if(cg.getBoard()[x/75][(y-xOffset)/75].getType()==2)
	        		{
	        			if(cg.getBoard()[x/75][(y-xOffset)/75].getColor()==0)
	            		{
	            			g.drawImage(WhiteRook,y,x,null);
	            		}
	        			else
	            			g.drawImage(BlackRook,y,x,null);
	        		}
	        		if(cg.getBoard()[x/75][(y-xOffset)/75].getType()==3)
	        		{
	        			if(cg.getBoard()[x/75][(y-xOffset)/75].getColor()==0)
	            		{
	            			g.drawImage(WhiteKnight,y,x,null);
	            		}
	        			else
	            			g.drawImage(BlackKnight,y,x,null);
	        		}
	        		if(cg.getBoard()[x/75][(y-xOffset)/75].getType()==4)
	        		{
	        			if(cg.getBoard()[x/75][(y-xOffset)/75].getColor()==0)
	            		{
	            			g.drawImage(WhiteBishop,y,x,null);
	            		}
	        			else
	            			g.drawImage(BlackBishop,y,x,null);
	        		}
	        		if(cg.getBoard()[x/75][(y-xOffset)/75].getType()==5)
	        		{
	        			if(cg.getBoard()[x/75][(y-xOffset)/75].getColor()==0)
	            		{
	            			g.drawImage(WhiteQueen,y,x,null);
	            		}
	        			else
	            			g.drawImage(BlackQueen,y,x,null);
	        		}
	        		if(cg.getBoard()[x/75][(y-xOffset)/75].getType()==6)
	        		{
	        			if(cg.getBoard()[x/75][(y-xOffset)/75].getColor()==0)
	            		{
	            			g.drawImage(WhiteKing,y,x,null);
	            		}
	        			else
	            			g.drawImage(BlackKing,y,x,null);
	        		}
        		}

        	}
        }

        if(selected!=null)
        {
        	boolean[][] arr = selected.getAvailableMoves(cg.getBoard());

        	for(int x=0;x<8;x++)
        	{
        		for(int y=0;y<8;y++)
        		{
        			if(arr[x][y]==true && isValidMove(selected.getRow(),selected.getCol(),x,y,selected)==true)
        			{
        				g.setColor(Color.BLUE);
        				g.fillOval(y*75+25+xOffset, x*75+25, 30, 30);
        			}


                }
        	}
        }
        if(selected==null && cg.getTurn()==cg.WHITE)
        {
            inCheck(cg.WHITE);

        }
        else if(selected==null && cg.getTurn()==cg.BLACK)
            inCheck(cg.BLACK);
		Font trb = new Font("TimesRoman", Font.BOLD, 18);
		g.setFont(trb);
		g.setColor(Color.BLUE);






		for(int x=1;x<cg.getMessages().size()+1;x++)
		{
			g.drawString(cg.getMessages().get(x-1),300+xOffset/2,600+25*x);
		}

		for(int x=0;x<cg.getKilledWhitePieces().size();x++)
		{
			int type = cg.getKilledWhitePieces().get(x);
			if(type==1)
				g.drawImage(SmallWhitePawn,25,45*x,null);
			if(type==2)
				g.drawImage(SmallWhiteRook,25,45*x,null);
			if(type==3)
				g.drawImage(SmallWhiteKnight,25,45*x,null);
			if(type==4)
				g.drawImage(SmallWhiteBishop,25,45*x,null);
			if(type==5)
				g.drawImage(SmallWhiteQueen,25,45*x,null);
		}
		for(int x=0;x<cg.getKilledBlackPieces().size();x++)
		{
			int type = cg.getKilledBlackPieces().get(x);
			if(type==1)
				g.drawImage(SmallBlackPawn,600+xOffset+25,45*x,null);
			if(type==2)
				g.drawImage(SmallBlackRook,600+xOffset+25,45*x,null);
			if(type==3)
				g.drawImage(SmallBlackKnight,600+xOffset+25,45*x,null);
			if(type==4)
				g.drawImage(SmallBlackBishop,600+xOffset+25,45*x,null);
			if(type==5)
				g.drawImage(SmallBlackQueen,600+xOffset+25,45*x,null);
		}
    }
    public void updateStatus()
    {
        cg.updateBoard();
        for(int x=0;x<cg.getPieces().size();x++)
        {
            Piece p = cg.getPieces().get(x);
            if(p.getColor()==cg.WHITE && p.getRow()==7 && p.getType()==1) {
                System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
                cg.setStatus(cg.TRANSFORMATION_WHITE);
            }
            if(p.getColor()==cg.BLACK && p.getRow()==0 && p.getType()==1)
                cg.setStatus(cg.TRANSFORMATION_BLACK);
        }

        cg.getMessages().clear();
        if(cg.getPlayerAmount()==0)
            cg.getMessages().add("Press 1 for single player and 2 for multiplayer");
        if(cg.getTurn()==ChessGame.WHITE)
            cg.getMessages().add("White's Turn");
        if(cg.getTurn()==ChessGame.BLACK)
            cg.getMessages().add("Black's Turn");
        if(inCheckmate(cg.WHITE) && cg.getTurn()==cg.WHITE)
        {
            cg.setStatus(cg.BLACK_WINS);
            cg.getMessages().clear();
            cg.getMessages().add("Black Wins!");
            cg.getMessages().add("Press r to reset");
        }
        else if(inCheckmate(cg.BLACK) && cg.getTurn()==cg.BLACK)
        {
            cg.setStatus(cg.WHITE_WINS);
            cg.getMessages().clear();
            cg.getMessages().add("White Wins!");
            cg.getMessages().add("Press r to reset");
        }
        else if(inStalemate(cg.WHITE) && cg.getTurn()==cg.WHITE)
        {
            cg.setStatus(cg.STALEMATE);
            cg.getMessages().clear();
            cg.getMessages().add("Stalemate");
            cg.getMessages().add("Press r to reset");
        }
        else if(inStalemate(cg.BLACK) && cg.getTurn()==cg.BLACK)
        {
            cg.setStatus(cg.STALEMATE);
            cg.getMessages().clear();
            cg.getMessages().add("Stalemate");
            cg.getMessages().add("Press r to reset");
        }

        else if(inCheck(cg.WHITE))
        {
    //        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
            cg.getMessages().clear();
            cg.getMessages().add("White's Turn!");
            cg.getMessages().add("Check");
        }
        else if(inCheck(cg.BLACK))
        {
      //      System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

            cg.getMessages().clear();
            cg.getMessages().add("Black's Turn!");
            cg.getMessages().add("Check");
        }
        if(cg.getStatus()==cg.TRANSFORMATION_BLACK || cg.getStatus()==cg.TRANSFORMATION_WHITE)
        {
            System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
            cg.getMessages().add("press q for queen, r for rook, b for bishop, and k for knight");
        }
     //   repaint();

    }
    public boolean isValidMove(int oldr, int oldc, int r, int c, Piece p)
    {
    	boolean [][] arr = p.getAvailableMoves(cg.getBoard());

		boolean hm = p.hasMoved();
		Piece pp = cg.movePiece(oldr,oldc,r,c,p);

    	if(arr[r][c]==true && inCheck(p.getColor())==false)
    	{
    		cg.revertMovePiece(oldr,oldc, p, pp, hm);
			return true;
		}
		cg.revertMovePiece(oldr,oldc, p, pp, hm);
		return false;
    }
    public boolean inCheck(int color)
    {
    	for(int x=0; x<cg.getPieces().size();x++)
    	{
    		if(cg.getPieces().get(x).getColor()!=color)
    		{
    			boolean [][] arr = cg.getPieces().get(x).getAvailableMoves(cg.getBoard());

    			for(int y=0;y<arr.length;y++)
    			{
    				for(int z=0;z<arr[0].length;z++)
    				{

    					if(arr[y][z]==true && cg.getBoard()[y][z]!=null && cg.getBoard()[y][z].getType()==6 && cg.getBoard()[y][z].getColor()==color)
    					{
							return true;
    					}
    				}
    			}
    		}
    	}
    	return false;
    }
    public boolean inCheckmate(int color)
	{
		if(inCheck(color)==false)
			return false;
		else
		{
			for(int s=0;s<cg.getPieces().size();s++)
			{
				if(cg.getPieces().get(s).getColor()==color)
				{
					boolean [][] arr = cg.getPieces().get(s).getAvailableMoves(cg.getBoard());

					for(int x=0;x<arr.length;x++)
					{
						for(int y=0;y<arr[0].length;y++)
						{
							if(arr[x][y]==true)
							{
								if(isValidMove(cg.getPieces().get(s).getRow(), cg.getPieces().get(s).getCol(), x,y,cg.getPieces().get(s))==true)
									return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
    public boolean inStalemate(int color)
    {
        if(inCheck(color)==true)
            return false;
        else
        {
            for(int s=0;s<cg.getPieces().size();s++)
            {
                if(cg.getPieces().get(s).getColor()==color)
                {
                    boolean [][] arr = cg.getPieces().get(s).getAvailableMoves(cg.getBoard());

                    for(int x=0;x<arr.length;x++)
                    {
                        for(int y=0;y<arr[0].length;y++)
                        {
                            if(arr[x][y]==true)
                            {
                                if(isValidMove(cg.getPieces().get(s).getRow(), cg.getPieces().get(s).getCol(), x,y,cg.getPieces().get(s))==true)
                                    return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
	public void randomAIMove()
    {
        ArrayList<Piece> blackPieces = new ArrayList<>();
        ArrayList<MoveRandom> moves = new ArrayList<>();


        for(int x=0;x<cg.getPieces().size();x++)
        {
            if(cg.getPieces().get(x).getColor()==cg.BLACK)
                blackPieces.add(cg.getPieces().get(x));
        }
        for(int x=0;x<blackPieces.size();x++)
        {
            Piece p = blackPieces.get(x);

            boolean [][] arr = p.getAvailableMoves(cg.getBoard());

            for(int xx=0;xx<8;xx++)
            {
                for(int y=0;y<8;y++)
                {
                    if(arr[xx][y]==true && isValidMove(p.getRow(),p.getCol(),xx,y,p)==true)
                    {
                        moves.add(new MoveRandom(p,xx,y));
                    }

                }
            }
        }
        int loc = (int)(Math.random()*moves.size());

        for(int x=0;x<cg.getPieces().size();x++)
        {
            if(cg.getPieces().get(x).equals(moves.get(loc).getP()))
            {
                cg.movePiece(cg.getPieces().get(x).getRow(),cg.getPieces().get(x).getCol(),moves.get(loc).getR(),moves.get(loc).getC(),cg.getPieces().get(x));
                cg.setTurn(cg.WHITE);
                selected = null;
                updateStatus();


            }
        }
        if(cg.getStatus()==cg.TRANSFORMATION_BLACK)
        {
            for(int x=0;x<cg.getPieces().size();x++)
            {
                if (cg.getPieces().get(x).getType() == 1 && cg.getPieces().get(x).getRow() == 0)
                {
                    Piece p = cg.getPieces().remove(x);


                    cg.getPieces().add(new Queen(p.getRow(), p.getCol(), p.getColor(), true, 5, true));
                    cg.setStatus(cg.PLAYING);
                }
            }
            updateStatus();
            repaint();
        }

    }
    public void easyAIMove()
    {
        ArrayList<Piece> blackPieces = new ArrayList<>();
        ArrayList<MoveWeight> moves = new ArrayList<>();


        MoveWeight bestMove = null;
        for(int x=0;x<cg.getPieces().size();x++)
        {
            if(cg.getPieces().get(x).getColor()==cg.BLACK)
                blackPieces.add(cg.getPieces().get(x));
        }
        for(int x=0;x<blackPieces.size();x++)
        {
            Piece p = blackPieces.get(x);

            boolean [][] arr = p.getAvailableMoves(cg.getBoard());



            for(int xx=0;xx<8;xx++)
            {
                for(int y=0;y<8;y++)
                {
                    if(arr[xx][y]==true && isValidMove(p.getRow(),p.getCol(),xx,y,p)==true)
                    {
                        if(bestMove==null) {
                            bestMove = new MoveWeight(p, xx, y, 0);
                        }

                        if(cg.getBoard()[xx][y]!=null)
                        {


                            if(cg.getBoard()[xx][y].getWeight()>bestMove.getWeight())
                            {
                                System.out.println("BEST MOVE WEIGHT:::::::::::::::::::::::::::::::::::::::::::::::"+bestMove.getWeight());
                                System.out.println("NEW MOVE WEIGHT:::::::::::::::::::::::::::::::::::::::::::::::"+cg.getBoard()[xx][y].getWeight());

                          //      bestMove=new MoveWeight(p, xx, y, cg.getBoard()[xx][y].getWeight());
                                bestMove.setP(p);
                                bestMove.setR(xx);
                                bestMove.setC(y);
                                bestMove.setWeight(cg.getBoard()[xx][y].getWeight());
                            }
                            else if(cg.getBoard()[xx][y].getWeight()==bestMove.getWeight() && p.getWeight()<bestMove.getP().getWeight())
                            {
                                bestMove.setP(p);
                                bestMove.setR(xx);
                                bestMove.setC(y);
                                bestMove.setWeight(cg.getBoard()[xx][y].getWeight());
                            }
                        }
                    }
                }
            }
        }
   //     System.out.println(bestMove.getP().getRow()+"                                          "+bestMove.getP().getCol()+"                     "+bestMove.getWeight());


        if(bestMove==null || bestMove.getWeight()==0) {
            System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
            randomAIMove();
        }
        else {
            for (int x = 0; x < cg.getPieces().size(); x++) {
                if (cg.getPieces().get(x).equals(bestMove.getP()))
                {
                    cg.movePiece(cg.getPieces().get(x).getRow(), cg.getPieces().get(x).getCol(), bestMove.getR(), bestMove.getC(), cg.getPieces().get(x));
                    cg.setTurn(cg.WHITE);
                    selected = null;
                    updateStatus();

                }
            }
        }
        if(cg.getStatus()==cg.TRANSFORMATION_BLACK)
        {
            for(int x=0;x<cg.getPieces().size();x++)
            {
                if (cg.getPieces().get(x).getType() == 1 && cg.getPieces().get(x).getRow() == 0)
                {
                    Piece p = cg.getPieces().remove(x);

                    cg.getPieces().add(new Queen(p.getRow(), p.getCol(), p.getColor(), true, 5, true));
                    cg.setStatus(cg.PLAYING);

                }
            }
            updateStatus();
            repaint();
        }

    }
    public void minimax()
    {
        updateStatus();
        ArrayList<Piece> blackPieces = new ArrayList<>();
        ArrayList<MoveWeight> moves = new ArrayList<>();


        MoveWeight bestMove = new MoveWeight(cg.getPieces().get(0),0,0,-10000);
       // bestMove.setWeight(-10000);
        System.out.println(bestMove.weight);
        for(int x=0;x<cg.getPieces().size();x++)
        {
            if(cg.getPieces().get(x).getColor()==cg.BLACK)
                blackPieces.add(cg.getPieces().get(x));
        }
        for(int x=0;x<blackPieces.size();x++)
        {
            Piece p = blackPieces.get(x);

            boolean [][] arr = p.getAvailableMoves(cg.getBoard());


            for(int xx=0;xx<8;xx++)
            {
                for(int y=0;y<8;y++)
                {
                    if(arr[xx][y]==true && isValidMove(p.getRow(),p.getCol(),xx,y,p)==true)
                    {

                        if(cg.getBoard()[xx][y]!=null)
                        {
                            moves.add(new MoveWeight(p, xx, y, cg.getBoard()[xx][y].getWeight()));
                            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");

                        }
                        if(cg.getBoard()[xx][y]==null)
                        {
                            moves.add(new MoveWeight(p, xx, y, 0));
                            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");

                        }
                    }
                }
            }
        }
        int status = 0;
        for(int x=0;x<moves.size();x++)
        {
            MoveWeight m = moves.get(x);
            int oldr = m.getP().getRow();
            int oldc = m.getP().getCol();
            int r = m.getR();
            int c = m.getC();
            boolean hm = m.getP().hasMoved();
            Piece pp = cg.movePiece(oldr,oldc,r,c,m.getP());
            cg.updateBoard();

            for(int y=0;y<cg.getPieces().size();y++)
            {
                Piece p = cg.getPieces().get(y);
                if(p.getColor()==cg.WHITE)
                {
                    boolean [][] arr = p.getAvailableMoves(cg.getBoard());

                    for(int xx=0;xx<arr.length;xx++)
                    {
                        for(int yy=0;yy<arr[0].length;yy++)
                        {
                            if( r==xx && c==yy &&arr[xx][yy]==true && isValidMove(p.getRow(),p.getCol(),xx,yy,p))
                            {
                                m.setWeight(m.getWeight() - m.getP().getWeight());
                                status = 1;
                                if(status==1)
                                    break;
                            }
                        }
                        if(status==1)
                            break;
                    }
                    if(status==1)
                        break;
                }
            }
            status = 0;
            cg.revertMovePiece(oldr,oldc,m.getP(),pp,hm);

        }
        for(int x=0;x<moves.size();x++)
        {
            MoveWeight m = moves.get(x);
            if(m.getWeight()>bestMove.getWeight())
            {
                bestMove.setP(m.getP());
                bestMove.setR(m.getR());
                bestMove.setC(m.getC());
                bestMove.setWeight(m.getWeight());
            }
        }

        //     System.out.println(bestMove.getP().getRow()+"                                          "+bestMove.getP().getCol()+"                     "+bestMove.getWeight());


        if(bestMove.getWeight()==-10000) {
            System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
            randomAIMove();
        }
        else {
            for (int x = 0; x < cg.getPieces().size(); x++) {
                if (cg.getPieces().get(x).equals(bestMove.getP()))
                {
                    cg.movePiece(cg.getPieces().get(x).getRow(), cg.getPieces().get(x).getCol(), bestMove.getR(), bestMove.getC(), cg.getPieces().get(x));
                    cg.setTurn(cg.WHITE);
                    selected = null;
                    updateStatus();

                }
            }
        }
        if(cg.getStatus()==cg.TRANSFORMATION_BLACK)
        {
            for(int x=0;x<cg.getPieces().size();x++)
            {
                if (cg.getPieces().get(x).getType() == 1 && cg.getPieces().get(x).getRow() == 0)
                {
                    Piece p = cg.getPieces().remove(x);

                    cg.getPieces().add(new Queen(p.getRow(), p.getCol(), p.getColor(), true, 5, true));
                    cg.setStatus(cg.PLAYING);

                }
            }
            updateStatus();
            repaint();
        }
    }
    public void minimax3(int color)
    {
        updateStatus();
        if(cg.getStatus()!=cg.WHITE_WINS && cg.getStatus()!=cg.TRANSFORMATION_WHITE) {
            boolean check = inCheck(cg.BLACK);
            ArrayList<Piece> blackPieces = new ArrayList<>();
            ArrayList<Piece> whitePieces = new ArrayList<>();
            ArrayList<MoveWeight> moves = new ArrayList<>();


            MoveWeight bestMove = new MoveWeight(cg.getPieces().get(0), 0, 0, -10000);
            // bestMove.setWeight(-10000);
            System.out.println(bestMove.weight);
            for (int x = 0; x < cg.getPieces().size(); x++) {
                if (cg.getPieces().get(x).getColor() == color)
                    blackPieces.add(cg.getPieces().get(x));
                else
                    whitePieces.add(cg.getPieces().get(x));
            }
            for (int x = 0; x < blackPieces.size(); x++) {
                Piece p = blackPieces.get(x);

                boolean[][] arr = p.getAvailableMoves(cg.getBoard());

                //if something is aiming at it then the piece itself gets a weight boost of its own weight
                //current weight is how many things its attacking vs how many things its being attacked by, or 1 thing its being attacked by
                //if something is protecting it its the attacker minus piece
                //check if anything is protecting the future move piece
                // only check the highest thing it is attacking, not all
                //check if a move can give a checkmate, if yes then automatically do it

                for (int xx = 0; xx < 8; xx++) {//check all black pieces original possible moves
                    for (int y = 0; y < 8; y++) {
                        if (arr[xx][y] == true && isValidMove(p.getRow(), p.getCol(), xx, y, p) == true) {
                            if (cg.getBoard()[xx][y] != null)
                            {

                                moves.add(new MoveWeight(p, xx, y, cg.getBoard()[xx][y].getWeight()));
                                moves.get(moves.size()-1).setChanged(true);
                                int status = 0;
//
//if move saves from being in check, add kings value to the weight;
                                for (int z = 0; z < whitePieces.size(); z++) {
                                    Piece ppp = whitePieces.get(z);
                                    boolean[][] arr2 = ppp.getAvailableMoves(cg.getBoard());

                                    for (int a = 0; a < arr2.length; a++) {//if white piece is aiming at original location
                                        for (int aa = 0; aa < arr2[0].length; aa++) {
                                            if (arr2[a][aa] == true && p.getRow() == a && p.getCol() == aa && isValidMove(ppp.getRow(), ppp.getCol(), a, aa, ppp)) {
                                                boolean hm = ppp.hasMoved();
                                                int oldr = ppp.getRow();
                                                int oldc = ppp.getCol();
                                                Piece pppp = cg.movePiece(ppp.getRow(), ppp.getCol(), a, aa, ppp);

                                                cg.updateBoard();


                                                for (int s = 0; s < blackPieces.size(); s++) {//if any black piece is defending orignal location
                                                    Piece pp = blackPieces.get(s);

                                                    boolean[][] arr4 = pp.getAvailableMoves(cg.getBoard());

//                                                    for (int zz = 0; zz < arr4.length; zz++) {
//                                                        for (int zzz = 0; zzz < arr4[0].length; zzz++) {
                                                            if (arr4[a][aa] == true &&  isValidMove(pp.getRow(), pp.getCol(), a, aa, pp)) {
                                                                status = 1;
                                                                moves.get(moves.size() - 1).setWeight(moves.get(moves.size() - 1).getWeight() - ppp.getWeight());
                                                            }
                                                            if (status == 1)
                                                                break;
//                                                        }
//                                                        if (status == 1)
//                                                            break;
//                                                    }
//                                                    if (status == 1)
//                                                        break;
                                                }
                                                cg.revertMovePiece(oldr, oldc, ppp, pppp, hm);
                                                cg.updateBoard();
                                                moves.get(moves.size() - 1).setWeight(moves.get(moves.size() - 1).getWeight() + p.getWeight());
                                            }
                                            if (status == 1)
                                                break;

                                        }
                                        if (status == 1)
                                            break;
                                    }
                                    if (status == 1)
                                        break;
                                }

                                System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");

                            }
                            if (cg.getBoard()[xx][y] == null)
                            {
                                moves.add(new MoveWeight(p, xx, y, 0));
                                int status = 0;

                                for (int z = 0; z < whitePieces.size(); z++) {
                                    Piece ppp = whitePieces.get(z);
                                    boolean[][] arr2 = ppp.getAvailableMoves(cg.getBoard());

                                    for (int a = 0; a < arr2.length; a++) {//if white piece is aiming at original location
                                        for (int aa = 0; aa < arr2[0].length; aa++) {
                                            if (arr2[a][aa] == true && p.getRow() == a && p.getCol() == aa && isValidMove(ppp.getRow(), ppp.getCol(), a, aa, ppp)) {
                                                boolean hm = ppp.hasMoved();
                                                int oldr = ppp.getRow();
                                                int oldc = ppp.getCol();
                                                Piece pppp = cg.movePiece(ppp.getRow(), ppp.getCol(), a, aa, ppp);

                                                cg.updateBoard();


                                                for (int s = 0; s < blackPieces.size(); s++) {//if any black piece is defending orignal location
                                                    Piece pp = blackPieces.get(s);

                                                    boolean[][] arr4 = pp.getAvailableMoves(cg.getBoard());

//                                                    for (int zz = 0; zz < arr4.length; zz++) {
//                                                        for (int zzz = 0; zzz < arr4[0].length; zzz++) {
                                                    if (arr4[a][aa] == true &&  isValidMove(pp.getRow(), pp.getCol(), a, aa, pp)) {
                                                        status = 1;
                                                        moves.get(moves.size() - 1).setWeight(moves.get(moves.size() - 1).getWeight() - ppp.getWeight());
                                                    }
                                                    if (status == 1)
                                                        break;
//                                                        }
//                                                        if (status == 1)
//                                                            break;
//                                                    }
//                                                    if (status == 1)
//                                                        break;
                                                }
                                                cg.revertMovePiece(oldr, oldc, ppp, pppp, hm);
                                                cg.updateBoard();
                                                moves.get(moves.size() - 1).setWeight(moves.get(moves.size() - 1).getWeight() + p.getWeight());
                                            }
                                            if (status == 1)
                                                break;

                                        }
                                        if (status == 1)
                                            break;
                                    }
                                    if (status == 1)
                                        break;
                                }

                                System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");

                            }
                        }

                    }
                }
            }
            int status = 0;
            int counter = 1;
            Piece pk = null;
            for (int x = 0; x < moves.size(); x++)
            {//piece moves to new location //use piece as null for changed
                MoveWeight m = moves.get(x);

                //go through all black pieces and see if new piece movement will be protected


                int oldr = m.getP().getRow();
                int oldc = m.getP().getCol();
                int r = m.getR();
                int c = m.getC();
                boolean hm = m.getP().hasMoved();
                Piece pp = cg.movePiece(oldr, oldc, r, c, m.getP());
                cg.updateBoard();
                //check if new piece is putting itself into danger

                if (check == true && inCheck(cg.BLACK) == false && m.getP().getType() != 6 && pk==null&& pp!=null)
                {
                    m.setWeight(m.getWeight() + 90000*counter);
                    counter++;
                    pk = m.getP();
                }
                if (check == true && inCheck(cg.BLACK) == false && m.getP().getType() != 6 && pk!=null && pk.getWeight()>m.getP().getWeight() && pp!=null) {
                    m.setWeight(m.getWeight() + 90000*counter);
                    counter++;
                    pk = m.getP();
                }
                if (check == true && inCheck(cg.BLACK) == false && m.getP().getType() != 6 && pk==null&& pp==null)
                {
                    m.setWeight(m.getWeight() + 3000);
                    pk = m.getP();
                }
                else if (check == true && inCheck(cg.BLACK) == false && m.getP().getType() == 6 && pp!=null)
                    m.setWeight(m.getWeight() + 40000);
                else if (check == true && inCheck(cg.BLACK) == false && m.getP().getType() == 6 && pp==null)
                    m.setWeight(m.getWeight() + 2000);
                if (inCheck(cg.WHITE))
                {
                    boolean win = true;
                    for(int g=0;g<whitePieces.size();g++)
                    {
                        Piece pa = whitePieces.get(g);

                        boolean [][] po = pa.getAvailableMoves(cg.getBoard());

                        for(int d=0;d<po.length;d++)
                        {
                            for(int dd=0;dd<po[0].length;dd++)
                            {
                                if(po[d][dd]==true && isValidMove(pa.getRow(),pa.getCol(),d,dd,pa))
                                    win = false;
                                if(win==false)
                                    break;
                            }
                            if(win==false)
                                break;
                        }
                        if(win==false)
                            break;

                    }
                    if(win==true) {
                        cg.setTurn(cg.WHITE);
                        selected = null;
                        updateStatus();
                        return;
                    }
                }

                for (int y = 0; y < cg.getPieces().size(); y++) {
                    Piece p = cg.getPieces().get(y);
                    if (p.getColor() != color) {//if any opposite colored piece is aiming at it, decrease weight by itself
                        boolean[][] arr = p.getAvailableMoves(cg.getBoard());

//                        for (int xx = 0; xx < arr.length; xx++) {
//                            for (int yy = 0; yy < arr[0].length; yy++) {
                        if (arr[r][c] == true && isValidMove(p.getRow(), p.getCol(), r, c, p)) {
                            //    m.setChanged(true);
                            m.setWeight(m.getWeight() - m.getP().getWeight());
                            status = 1;
                            if (status == 1)
                                break;
//                                }
//                            }

                        }

                    }
                }
                cg.revertMovePiece(oldr, oldc, m.getP(), pp, hm);
                status = 0;
            }
            boolean proceed = true;
            cg.updateBoard();
            //check if any white piece is attacking a black piece, find which black piece is worth the most that is being attacked and can be protected, if it can be protected, then protect it

            Piece attacked = null;
            Piece defender = null;

            for(int s=0;s<whitePieces.size();s++)
            {//check if any white piece is attacking a black piece
                Piece p = whitePieces.get(s);

                boolean[][] arr = p.getAvailableMoves(cg.getBoard());

                for(int x=0;x<arr.length;x++)
                {
                    for(int y=0;y<arr[0].length;y++)
                    {
                        if(arr[x][y]==true && isValidMove(p.getRow(),p.getCol(),x,y,p)==true && cg.getBoard()[x][y]!=null && cg.getBoard()[x][y].getColor()==cg.BLACK && attacked==null)
                        {
                            attacked = cg.getBoard()[x][y];
                            cg.getPieces().remove(attacked);
                            Piece o = new StandByPiece(x,y,cg.WHITE,true,8,true);
                            cg.getPieces().add(o);
                            cg.updateBoard();
                 //           arr = p.getAvailableMoves(cg.getBoard());
                            boolean protectAlready = false;
                            //check if it is already being protected

                            for(int xx=0;xx<blackPieces.size();xx++)
                            {
                                Piece f = blackPieces.get(xx);

                                if(isValidMove(f.getRow(),f.getCol(),x,y,f))
                                {
                                    protectAlready = true;


                                }
                            }

                            cg.updateBoard();

                            if(protectAlready==false)
                            {
                                for (int ss = 0; ss < moves.size(); ss++) {
                                    MoveWeight m = moves.get(ss);
                                    int oldr = m.getP().getRow();
                                    int oldc = m.getP().getCol();
                                    int r = m.getR();
                                    int c = m.getC();
                                    boolean hm = m.getP().hasMoved();
                                    Piece pp = cg.movePiece(oldr, oldc, r, c, m.getP());
                                    cg.updateBoard();

                                    if (isValidMove(r, c, attacked.getRow(), attacked.getCol(), m.getP()) && defender == null) {
                                        defender = m.getP();
                                        m.setWeight(m.getWeight() + attacked.getWeight() - 1);
                                        proceed = false;
                                        System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
                                    } else if (isValidMove(r, c, attacked.getRow(), attacked.getCol(), m.getP()) && defender != null && defender.getWeight() > m.getP().getWeight()) {
                                        defender = m.getP();
                                        m.setWeight(m.getWeight() + attacked.getWeight() - 1);
                                        proceed = false;
                                        System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");

                                    }
                                    //checks if piece is blocking
                                    cg.getPieces().remove(o);
                                    if(attacked!=null)
                                        cg.getPieces().add(attacked);
                                    cg.updateBoard();
                                    if (isValidMove(p.getRow(),p.getCol(),x,y,p)==false && defender == null)
                                    {
                                        Piece oo = new StandByPiece(r,c,cg.WHITE,true,8,true);
                                        cg.getPieces().add(o);
                                        cg.updateBoard();
                                        boolean protects = false;
                                        for(int d=0;d<blackPieces.size();d++)
                                        {
                                            Piece l = blackPieces.get(d);
                                            if(isValidMove(l.getRow(),l.getCol(),r,c,l))
                                                protects = true;
                                        }
                                        if(protects ==true)
                                        {
                                            defender = m.getP();
                                            m.setWeight(m.getWeight() + attacked.getWeight() - 1);
                                            proceed = false;
                                            System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
                                        }
                                        else
                                        {
                                            defender = m.getP();
                                            m.setWeight(m.getWeight() + attacked.getWeight() - 1-m.getP().getWeight());
                                            proceed = false;
                                            System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
                                        }
                                        cg.getPieces().remove(oo);
                                        cg.updateBoard();
                                    }
                                    else if (isValidMove(p.getRow(),p.getCol(),x,y,p)==false && defender != null && defender.getWeight() > m.getP().getWeight()) {
                                        Piece oo = new StandByPiece(r,c,cg.WHITE,true,8,true);
                                        cg.getPieces().add(o);
                                        cg.updateBoard();
                                        boolean protects = false;
                                        for(int d=0;d<blackPieces.size();d++)
                                        {
                                            Piece l = blackPieces.get(d);
                                            if(isValidMove(l.getRow(),l.getCol(),r,c,l))
                                                protects = true;
                                        }
                                        if(protects ==true)
                                        {
                                            defender = m.getP();
                                            m.setWeight(m.getWeight() + attacked.getWeight() - 1);
                                            proceed = false;
                                            System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
                                        }
                                        else
                                        {
                                            defender = m.getP();
                                            m.setWeight(m.getWeight() + attacked.getWeight() - 1-m.getP().getWeight());
                                            proceed = false;
                                            System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
                                        }
                                        cg.getPieces().remove(oo);
                                        cg.updateBoard();
                                    }
                                    cg.getPieces().remove(attacked);
                                    cg.getPieces().add(o);
                                    cg.updateBoard();
                                    cg.revertMovePiece(oldr, oldc, m.getP(), pp, hm);
                                    cg.updateBoard();
                                }
                            }
                            cg.getPieces().remove(o);
                            if(attacked!=null)
                                cg.getPieces().add(attacked);
                            cg.updateBoard();
                            arr = p.getAvailableMoves(cg.getBoard());



                        }
                        else if(arr[x][y]==true && isValidMove(p.getRow(),p.getCol(),x,y,p)==true && cg.getBoard()[x][y]!=null && cg.getBoard()[x][y].getColor()==cg.BLACK && attacked!=null && cg.getBoard()[x][y].getWeight()>attacked.getWeight())
                        {
                            attacked = cg.getBoard()[x][y];
                            cg.getPieces().remove(attacked);
                            Piece o = new StandByPiece(x,y,cg.WHITE,true,8,true);
                            cg.getPieces().add(o);

                            cg.updateBoard();
                            boolean protectAlready = false;

                            for(int xx=0;xx<blackPieces.size();xx++)
                            {
                                Piece f = blackPieces.get(xx);

                                if(isValidMove(f.getRow(),f.getCol(),x,y,f))
                                {
                                    protectAlready = true;
                                }
                            }
                            cg.updateBoard();


                            if(protectAlready==false) {
                                for (int ss = 0; ss < moves.size(); ss++) {
                                    MoveWeight m = moves.get(ss);
                                    int oldr = m.getP().getRow();
                                    int oldc = m.getP().getCol();
                                    int r = m.getR();
                                    int c = m.getC();
                                    boolean hm = m.getP().hasMoved();
                                    Piece pp = cg.movePiece(oldr, oldc, r, c, m.getP());
                                    cg.updateBoard();


                                    if (isValidMove(r, c, attacked.getRow(), attacked.getCol(), m.getP()) && defender == null) {
                                        defender = m.getP();
                                        m.setWeight(m.getWeight() + attacked.getWeight() - 1);
                                        proceed = false;
                                        System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");

                                    } else if (isValidMove(r, c, attacked.getRow(), attacked.getCol(), m.getP()) && defender != null && defender.getWeight() > m.getP().getWeight()) {
                                        defender = m.getP();
                                        m.setWeight(m.getWeight() + attacked.getWeight() - 1);
                                        proceed = false;
                                        System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");


                                    }
                                    cg.getPieces().remove(o);
                                    if(attacked!=null)
                                        cg.getPieces().add(attacked);
                                    cg.updateBoard();
                                    if (isValidMove(p.getRow(),p.getCol(),x,y,p)==false && defender == null) {
                                        Piece oo = new StandByPiece(r,c,cg.WHITE,true,8,true);
                                        cg.getPieces().add(o);
                                        cg.updateBoard();
                                        boolean protects = false;
                                        for(int d=0;d<blackPieces.size();d++)
                                        {
                                            Piece l = blackPieces.get(d);
                                            if(isValidMove(l.getRow(),l.getCol(),r,c,l))
                                                protects = true;
                                        }
                                        if(protects ==true)
                                        {
                                            defender = m.getP();
                                            m.setWeight(m.getWeight() + attacked.getWeight() - 1);
                                            proceed = false;
                                            System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
                                        }
                                        else
                                        {
                                            defender = m.getP();
                                            m.setWeight(m.getWeight() + attacked.getWeight() - 1-m.getP().getWeight());
                                            proceed = false;
                                            System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
                                        }
                                        cg.getPieces().remove(oo);
                                        cg.updateBoard();
                                    }
                                    else if (isValidMove(p.getRow(),p.getCol(),x,y,p)==false && defender != null && defender.getWeight() > m.getP().getWeight()) {
                                        Piece oo = new StandByPiece(r,c,cg.WHITE,true,8,true);
                                        cg.getPieces().add(o);
                                        cg.updateBoard();
                                        boolean protects = false;
                                        for(int d=0;d<blackPieces.size();d++)
                                        {
                                            Piece l = blackPieces.get(d);
                                            if(isValidMove(l.getRow(),l.getCol(),r,c,l))
                                                protects = true;
                                        }
                                        if(protects ==true)
                                        {
                                            defender = m.getP();
                                            m.setWeight(m.getWeight() + attacked.getWeight() - 1);
                                            proceed = false;
                                            System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
                                        }
                                        else
                                        {
                                            defender = m.getP();
                                            m.setWeight(m.getWeight() + attacked.getWeight() - 1-m.getP().getWeight());
                                            proceed = false;
                                            System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
                                        }
                                        cg.getPieces().remove(oo);
                                        cg.updateBoard();
                                    }
                                    cg.getPieces().remove(attacked);
                                    cg.getPieces().add(o);
                                    cg.updateBoard();
                                    cg.revertMovePiece(oldr, oldc, m.getP(), pp, hm);
                                    cg.updateBoard();

                                }
                            }
                            if(attacked!=null)
                                cg.getPieces().add(attacked);
                            cg.getPieces().remove(o);

                            cg.updateBoard();

                        }
                    }
                }
            }

       //     cg.updateBoard();
            for (int x = 0; x < moves.size(); x++) {
                MoveWeight m = moves.get(x);
                if (m.getWeight() > bestMove.getWeight()) {
                    bestMove.setP(m.getP());
                    bestMove.setR(m.getR());
                    bestMove.setC(m.getC());
                    bestMove.setWeight(m.getWeight());
                }
            }

            if(proceed==true && bestMove.getWeight()<=0) {

                for (int x = 0; x < moves.size(); x++)
                {//piece moves to new location //use piece as null for changed
                    MoveWeight m = moves.get(x);
                    int oldr = m.getP().getRow();
                    int oldc = m.getP().getCol();
                    int r = m.getR();
                    int c = m.getC();
                    boolean hm = m.getP().hasMoved();
                    Piece pp = cg.movePiece(oldr, oldc, r, c, m.getP());
                    cg.updateBoard();
                    if (m.changed == false)
                    {//if new location didnt originally have a piece there make another move
                        boolean[][] arr = m.getP().getAvailableMoves(cg.getBoard());
                        int status2 = 0;
                        int status4 = 0;
                        for (int s = 0; s < whitePieces.size(); s++) {
                            Piece o = whitePieces.get(s);

                            boolean[][] arr2 = o.getAvailableMoves(cg.getBoard());

                            if (arr2[m.getP().getRow()][m.getP().getCol()] == true && isValidMove(o.getRow(), o.getCol(), m.getP().getRow(), m.getP().getCol(), o) == true) {
                                m.setWeight(m.getWeight() - m.getP().getWeight());
                                status4 = 1;
                            }
                        }
                        if (status4 == 0) {
                            for (int xx = 0; xx < arr.length; xx++) {
                                for (int yy = 0; yy < arr[0].length; yy++) {
                                    if (arr[xx][yy] == true && isValidMove(r, c, xx, yy, m.getP()) && cg.getBoard()[xx][yy] != null) {
                                        int newWeight = m.getWeight() + cg.getBoard()[xx][yy].getWeight();
                                        //newWeight is current weight plus whatever is at the new location
                                        int or = r;
                                        int oc = c;
                                        boolean hm2 = m.getP().hasMoved();
                                        Piece ap = cg.movePiece(r, c, xx, yy, m.getP());
                                        cg.updateBoard();
                                        for (int g = 0; g < whitePieces.size(); g++) {//if piece is defending location, remove itself weight
                                            //needs to move piece in order to see if its valid or not
                                            Piece ppp = whitePieces.get(g);

                                            boolean[][] arr2 = ppp.getAvailableMoves(cg.getBoard());


//                                    for (int xxx = 0; xxx < arr2.length; xxx++)
//                                    {
//                                        for (int yyy = 0; yyy < arr2[0].length; yyy++)
//                                        {
                                            if (arr2[xx][yy] == true && isValidMove(ppp.getRow(), ppp.getCol(), xx, yy, ppp)) {

                                                newWeight = newWeight - m.getP().getWeight();
                                                status2 = 1;
                                            }
                                            if (status2 == 1)
                                                break;
//                                        }
//                                        if(status2==1)
//                                            break;
//                                    }
//                                    if(status2==1)
//                                        break;

                                        }
                                        cg.revertMovePiece(or, oc, m.getP(), ap, hm2);

                                        // if(newWeight>m.getWeight())
                                        m.setWeight(newWeight);


                                    }
                                    if (status2 == 1)
                                        break;

//                            }
                                }
                                if (status2 == 1)
                                    break;
                            }
                        }
                    }
                    cg.revertMovePiece(oldr, oldc, m.getP(), pp, hm);
                    status = 0;
                }

            }






            System.out.println(bestMove.getP().getRow()+"                                          "+bestMove.getP().getCol()+"                     "+bestMove.getWeight());

            for (int x = 0; x < moves.size(); x++) {
                MoveWeight m = moves.get(x);
                if (m.getWeight() > bestMove.getWeight()) {
                    bestMove.setP(m.getP());
                    bestMove.setR(m.getR());
                    bestMove.setC(m.getC());
                    bestMove.setWeight(m.getWeight());
                }
            }

                 System.out.println(bestMove.getP().getRow()+"                                          "+bestMove.getP().getCol()+"                     "+bestMove.getWeight());


            if (bestMove.getWeight() == -10000) {
                randomAIMove();
            }
            if(bestMove.getWeight()<=0)
            {
                for(int d=0;d<blackPieces.size();d++)
                {
                    Piece p = blackPieces.get(d);

                    cg.getPieces().remove(p);
                    Piece o = new StandByPiece(p.getRow(),p.getCol(),cg.WHITE,true,8,true);
                    cg.getPieces().add(o);

                    cg.updateBoard();
                    boolean protectAlready = false;

                    for(int xx=0;xx<blackPieces.size();xx++)
                    {
                        Piece f = blackPieces.get(xx);

                        if(isValidMove(f.getRow(),f.getCol(),p.getRow(),p.getCol(),f))
                        {
                            protectAlready = true;
                        }
                    }
                    if(protectAlready==false)
                    {
                        Piece protecter = null;
                        for(int i=0;i<moves.size();i++)
                        {
                            MoveWeight m = moves.get(i);
                            int oldr = m.getP().getRow();
                            int oldc = m.getP().getCol();
                            int r = m.getR();
                            int c = m.getC();
                            boolean hm = m.getP().hasMoved();
                            Piece pp = cg.movePiece(oldr, oldc, r, c, m.getP());

                            //if black piece defending new location then dont subtract else subtract
                            if(isValidMove(r,c,p.getRow(),p.getCol(),m.getP()) && p.getRow()!=6 && p.getRow()!=7 && protecter==null)
                            {
                                m.setWeight(m.getWeight() + p.getWeight() +10000-m.getP().getWeight());
                          //      protecter= m.getP();
                            }
//                            if(isValidMove(r,c,p.getRow(),p.getCol(),m.getP()) && p.getRow()!=6 && p.getRow()!=7 && protecter!=null && protecter.getWeight()>m.getP().getWeight())
//                            {
//                                m.setWeight(m.getWeight() + p.getWeight() - 1);
//                                protecter=m.getP();
//                            }

                            cg.revertMovePiece(oldr, oldc, m.getP(), pp, hm);
                            cg.updateBoard();
                        }
                    }
                    cg.getPieces().remove(o);
                    cg.getPieces().add(p);
                    cg.updateBoard();
                }
            }

            for (int x = 0; x < moves.size(); x++) {
                MoveWeight m = moves.get(x);
                if (m.getWeight() > bestMove.getWeight()) {
                    bestMove.setP(m.getP());
                    bestMove.setR(m.getR());
                    bestMove.setC(m.getC());
                    bestMove.setWeight(m.getWeight());
                }
            }
            System.out.println(bestMove.getP().getRow()+"                                          "+bestMove.getP().getCol()+"                     "+bestMove.getWeight());

            if(bestMove.getWeight()<=0)
            {
                //if moving piece blocks a piece protecting another piece
                //if piece is being attacked and moving a piece can block it while still being safe
                //prioritize taking a piece over check if it is safe to take a piece
                //piece should check if already being protected, if not then try to save its own life
                //if protecting something thats being attacked and is the only one then move subtract the protected things weight
                //check if protecting black piece even if not being attacked, do best move check again, if still 0 then random
                //do look ahead only if no black pieces are in danger and unprotected
                //check if any white piece is attacking a black piece, find which black piece is worth the most that is being attacked and can be protected, if it can be protected, then protect it
                //check all white pieces if they are attacking anything, if they are, remove what they are attacking and check if any black piece is attacking that, if not, then try to attack(defend) that spot
                ArrayList<MoveWeight> mw = new ArrayList<>();
                System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
                for(int x=0;x<moves.size();x++)
                {
                    if(moves.get(x).getWeight()==0)
                        mw.add(moves.get(x));
                }
                int random = (int)(Math.random()*mw.size());

                cg.movePiece(mw.get(random).getP().getRow(),mw.get(random).getP().getCol(),mw.get(random).getR(), mw.get(random).getC(),mw.get(random).getP());
                cg.setTurn(cg.WHITE);
                selected = null;
                updateStatus();
            }
            else {
                for (int x = 0; x < cg.getPieces().size(); x++) {
                    if (cg.getPieces().get(x).equals(bestMove.getP())) {
                        cg.movePiece(cg.getPieces().get(x).getRow(), cg.getPieces().get(x).getCol(), bestMove.getR(), bestMove.getC(), cg.getPieces().get(x));
                        cg.setTurn(cg.WHITE);
                        selected = null;
                        updateStatus();

                    }
                }
            }
            if (cg.getStatus() == cg.TRANSFORMATION_BLACK) {
                for (int x = 0; x < cg.getPieces().size(); x++) {
                    if (cg.getPieces().get(x).getType() == 1 && cg.getPieces().get(x).getRow() == 0) {
                        Piece p = cg.getPieces().remove(x);

                        cg.getPieces().add(new Queen(p.getRow(), p.getCol(), p.getColor(), true, 5, true));
                        cg.setStatus(cg.PLAYING);

                    }
                }
                updateStatus();
                repaint();
            }
        }
        updateStatus();
        repaint();
    }

 
    public void mouseClicked(MouseEvent e)
    {
    	inCheck(cg.WHITE);
    	inCheck(cg.BLACK);
    	int xOffset = 100;
    	updateStatus();
    	if(cg.getStatus()==cg.PLAYING && cg.getPlayerAmount()!=0)
    	{
			if (cg.getTurn() == cg.WHITE)
			{
				for (int y = 0; y < 600; y += 75)
				{
					for (int x = 0+xOffset; x < 600+xOffset; x += 75)
					{
						if (selected == null && e.getX() > x && e.getX() < x + 75 && e.getY() > y && e.getY() < y + 75 && cg.getBoard()[y / 75][(x-xOffset) / 75] != null && cg.getBoard()[y / 75][(x-xOffset) / 75].getColor() == cg.WHITE)
						{
							selected = cg.getBoard()[y / 75][(x-xOffset) / 75];
                            updateStatus();
						}
						else if (selected != null && e.getX() > x && e.getX() < x + 75 && e.getY() > y && e.getY() < y + 75 && cg.getBoard()[y / 75][(x-xOffset) / 75] != null && cg.getBoard()[y / 75][(x-xOffset) / 75].getColor() == cg.WHITE && selected.equals(cg.getBoard()[y / 75][(x-xOffset) / 75]) == false)
						{
							selected = cg.getBoard()[y / 75][(x-xOffset) / 75];
                            updateStatus();
						}
						else if (selected != null && e.getX() > x && e.getX() < x + 75 && e.getY() > y && e.getY() < y + 75 && cg.getBoard()[y / 75][(x-xOffset) / 75] != null && cg.getBoard()[y / 75][(x-xOffset) / 75].equals(selected))
						{
							selected = null;
                            updateStatus();
						}
						else if (selected != null && e.getX() > x && e.getX() < x + 75 && e.getY() > y && e.getY() < y + 75 && (cg.getBoard()[y / 75][(x-xOffset) / 75] == null || cg.getBoard()[y / 75][(x-xOffset) / 75].getColor() != selected.getColor()) && isValidMove(selected.getRow(), selected.getCol(), y / 75, (x-xOffset) / 75, selected) == true)
						{

                            if(selected.getType()==6 && selected.getRow()==0&& (x-xOffset) / 75-selected.getCol()==2 && selected.getColor()==cg.WHITE)
                            {
                                for(int xx=0;xx<cg.getPieces().size();xx++)
                                {
                                    if(cg.getPieces().get(xx).equals(cg.getBoard()[0][7]) && cg.getPieces().get(xx).hasMoved()==false)
                                    {
                                        //              piece = new Rook(pieces.get(xx).getRow(),pieces.get(xx).getCol(),pieces.get(xx).getColor(),true, 2,false);
                                        cg.getPieces().get(xx).setCol(5);
                                        cg.getPieces().get(xx).setHasMoved(true);
//                    p.setRow(r);
//                    p.setCol(c);
//                    p.setHasMoved(true);
                                    }
                                }
                                System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
                            }
                            else if(selected.getType()==6 &&  selected.getRow()==0&& (x-xOffset) / 75-selected.getCol()==-2 && selected.getColor()==cg.WHITE)
                            {
                                for(int xx=0;xx<cg.getPieces().size();xx++)
                                {
                                    if(cg.getPieces().get(xx).equals(cg.getBoard()[0][0]) && cg.getPieces().get(xx).hasMoved()==false)
                                    {
                                        //             piece = new Rook(pieces.get(xx).getRow(),pieces.get(xx).getCol(),pieces.get(xx).getColor(),true, 2,false);
                                        cg.getPieces().get(xx).setCol(3);
                                        cg.getPieces().get(xx).setHasMoved(true);
//                    p.setRow(r);
//                    p.setCol(c);
//                    p.setHasMoved(true);
                                    }
                                }
                                System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
                            }
                            else if(selected.getType()==6 && selected.getRow()==7&& (x-xOffset) / 75-selected.getCol()==2 && selected.getColor()==cg.BLACK)
                            {
                                for(int xx=0;xx<cg.getPieces().size();xx++)
                                {
                                    if(cg.getPieces().get(xx).equals(cg.getBoard()[7][7]) && cg.getPieces().get(xx).hasMoved()==false)
                                    {
                                        //              piece = new Rook(pieces.get(xx).getRow(),pieces.get(xx).getCol(),pieces.get(xx).getColor(),true, 2,false);
                                        cg.getPieces().get(xx).setCol(4);
                                        cg.getPieces().get(xx).setHasMoved(true);
//                    p.setRow(r);
//                    p.setCol(c);
//                    p.setHasMoved(true);
                                    }
                                }
                                System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
                            }
                            else if(selected.getType()==6 &&  selected.getRow()==7&& (x-xOffset) / 75-selected.getCol()==-2 && selected.getColor()==cg.BLACK)
                            {
                                for(int xx=0;xx<cg.getPieces().size();xx++)
                                {
                                    if(cg.getPieces().get(xx).equals(cg.getBoard()[7][0]) && cg.getPieces().get(xx).hasMoved()==false)
                                    {
                                        //              piece = new Rook(pieces.get(xx).getRow(),pieces.get(xx).getCol(),pieces.get(xx).getColor(),true, 2,false);
                                        cg.getPieces().get(xx).setCol(2);
                                        cg.getPieces().get(xx).setHasMoved(true);
//                    p.setRow(r);
//                    p.setCol(c);
//                    p.setHasMoved(true);
                                    }
                                }
                                System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
                            }


                            cg.movePiece(selected.getRow(), selected.getCol(), y / 75, (x-xOffset) / 75, selected);


							selected = null;
							cg.setTurn(cg.BLACK);
							//updateStatus();
							repaint();
						}
					}
				}
			}
			if (cg.getTurn() == cg.BLACK)
			{
			    if(cg.getPlayerAmount()==cg.TWO_PLAYER)
			    {
                    for (int y = 0; y < 600; y += 75)
                    {
                        for (int x = 0 + xOffset; x < 600 + xOffset; x += 75)
                        {
                            if (selected == null && e.getX() > x && e.getX() < x + 75 && e.getY() > y && e.getY() < y + 75 && cg.getBoard()[y / 75][(x - xOffset) / 75] != null && cg.getBoard()[y / 75][(x - xOffset) / 75].getColor() == cg.BLACK)
                            {
                                selected = cg.getBoard()[y / 75][(x - xOffset) / 75];
                                updateStatus();
                            }
                            else if (selected != null && e.getX() > x && e.getX() < x + 75 && e.getY() > y && e.getY() < y + 75 && cg.getBoard()[y / 75][(x - xOffset) / 75] != null && cg.getBoard()[y / 75][(x - xOffset) / 75].getColor() == cg.BLACK && selected.equals(cg.getBoard()[y / 75][(x - xOffset) / 75]) == false)
                            {
                                selected = cg.getBoard()[y / 75][(x - xOffset) / 75];
                                updateStatus();
                            }
                            else if (selected != null && e.getX() > x && e.getX() < x + 75 && e.getY() > y && e.getY() < y + 75 && cg.getBoard()[y / 75][(x - xOffset) / 75] != null && cg.getBoard()[y / 75][(x - xOffset) / 75].equals(selected)) {
                                selected = null;
                                updateStatus();
                            }
                            else if (selected != null && e.getX() > x && e.getX() < x + 75 && e.getY() > y && e.getY() < y + 75 && (cg.getBoard()[y / 75][(x - xOffset) / 75] == null || cg.getBoard()[y / 75][(x - xOffset) / 75].getColor() != selected.getColor()) && isValidMove(selected.getRow(), selected.getCol(), y / 75, (x - xOffset) / 75, selected) == true) {
                                if(selected.getType()==6 && selected.getRow()==0&& (x-xOffset) / 75-selected.getCol()==2 && selected.getColor()==cg.WHITE)
                                {
                                    for(int xx=0;xx<cg.getPieces().size();xx++)
                                    {
                                        if(cg.getPieces().get(xx).equals(cg.getBoard()[0][7]) && cg.getPieces().get(xx).hasMoved()==false)
                                        {
                                            //              piece = new Rook(pieces.get(xx).getRow(),pieces.get(xx).getCol(),pieces.get(xx).getColor(),true, 2,false);
                                            cg.getPieces().get(xx).setCol(5);
                                            cg.getPieces().get(xx).setHasMoved(true);
//                    p.setRow(r);
//                    p.setCol(c);
//                    p.setHasMoved(true);
                                        }
                                    }
                                    System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
                                }
                                else if(selected.getType()==6 &&  selected.getRow()==0&& (x-xOffset) / 75-selected.getCol()==-2 && selected.getColor()==cg.WHITE)
                                {
                                    for(int xx=0;xx<cg.getPieces().size();xx++)
                                    {
                                        if(cg.getPieces().get(xx).equals(cg.getBoard()[0][0]) && cg.getPieces().get(xx).hasMoved()==false)
                                        {
                                            //             piece = new Rook(pieces.get(xx).getRow(),pieces.get(xx).getCol(),pieces.get(xx).getColor(),true, 2,false);
                                            cg.getPieces().get(xx).setCol(3);
                                            cg.getPieces().get(xx).setHasMoved(true);
//                    p.setRow(r);
//                    p.setCol(c);
//                    p.setHasMoved(true);
                                        }
                                    }
                                    System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
                                }
                                else if(selected.getType()==6 && selected.getRow()==7&& (x-xOffset) / 75-selected.getCol()==2 && selected.getColor()==cg.BLACK)
                                {
                                    for(int xx=0;xx<cg.getPieces().size();xx++)
                                    {
                                        if(cg.getPieces().get(xx).equals(cg.getBoard()[7][7]) && cg.getPieces().get(xx).hasMoved()==false)
                                        {
                                            //              piece = new Rook(pieces.get(xx).getRow(),pieces.get(xx).getCol(),pieces.get(xx).getColor(),true, 2,false);
                                            cg.getPieces().get(xx).setCol(4);
                                            cg.getPieces().get(xx).setHasMoved(true);
//                    p.setRow(r);
//                    p.setCol(c);
//                    p.setHasMoved(true);
                                        }
                                    }
                                    System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
                                }
                                else if(selected.getType()==6 &&  selected.getRow()==7&& (x-xOffset) / 75-selected.getCol()==-2 && selected.getColor()==cg.BLACK)
                                {
                                    for(int xx=0;xx<cg.getPieces().size();xx++)
                                    {
                                        if(cg.getPieces().get(xx).equals(cg.getBoard()[7][0]) && cg.getPieces().get(xx).hasMoved()==false)
                                        {
                                            //              piece = new Rook(pieces.get(xx).getRow(),pieces.get(xx).getCol(),pieces.get(xx).getColor(),true, 2,false);
                                            cg.getPieces().get(xx).setCol(2);
                                            cg.getPieces().get(xx).setHasMoved(true);
//                    p.setRow(r);
//                    p.setCol(c);
//                    p.setHasMoved(true);
                                        }
                                    }
                                    System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
                                }
                                cg.movePiece(selected.getRow(), selected.getCol(), y / 75, (x - xOffset) / 75, selected);

                                selected = null;
                                cg.setTurn(cg.WHITE);
                                updateStatus();

                            }
                        }
                    }
                }
			    else
                {
                    updateStatus();

                    //    randomAIMove();
                    //    easyAIMove();
                    //    minimax();
                          minimax3(cg.BLACK);
                }
			}

		}
        updateStatus();
        repaint();
    }
 
    public void mousePressed(MouseEvent e) {
 
    }
 
    public void mouseReleased(MouseEvent e) {
 
    }
 
    public void mouseEntered(MouseEvent e) {
 
    }
 
    public void mouseExited(MouseEvent e) {
 
    }
 
    public void keyTyped(KeyEvent e)
    {
       
    }
 
    public void keyPressed(KeyEvent e) {
 
    }
 
    public void keyReleased(KeyEvent e)
	{
        updateStatus();
	    if(cg.getPlayerAmount()==0)
        {
            if (e.getKeyChar() == '1')
            {
                cg.setPlayerAmount(cg.ONE_PLAYER);
                repaint();
            }
            if (e.getKeyChar() == '2')
            {
                cg.setPlayerAmount(cg.TWO_PLAYER);

                repaint();
            }
        }

		if(cg.getStatus()==cg.BLACK_WINS || cg.getStatus()==cg.WHITE_WINS)
		{
			if (e.getKeyChar() == 'r')
			{
				cg.reset();
				repaint();
			}
		}
		else if(cg.getStatus()==cg.TRANSFORMATION_WHITE )
		{

			for(int x=0;x<cg.getPieces().size();x++)
			{
				if(cg.getPieces().get(x).getType()==1 && cg.getPieces().get(x).getRow()==7)
				{
					Piece p;
					if(e.getKeyChar()=='q')
					{
                        p = cg.getPieces().remove(x);
						cg.getPieces().add(new Queen(p.getRow(), p.getCol(), p.getColor(), true, 5, true));
						cg.setStatus(cg.PLAYING);
					}
					if(e.getKeyChar()=='r') {
                        p = cg.getPieces().remove(x);

                        cg.getPieces().add(new Rook(p.getRow(), p.getCol(), p.getColor(), true, 2, true));
						cg.setStatus(cg.PLAYING);

					}
					if(e.getKeyChar()=='b') {
                        p = cg.getPieces().remove(x);

                        cg.getPieces().add(new Bishop(p.getRow(), p.getCol(), p.getColor(), true, 4, true));
						cg.setStatus(cg.PLAYING);

					}
					if(e.getKeyChar()=='k') {
                        p = cg.getPieces().remove(x);

                        cg.getPieces().add(new Knight(p.getRow(), p.getCol(), p.getColor(), true, 3, true));
						cg.setStatus(cg.PLAYING);

					}
				}
			}
			cg.updateBoard();
		}
		else if(cg.getStatus()==cg.TRANSFORMATION_BLACK && cg.getPlayerAmount()==cg.TWO_PLAYER)
		{

			for(int x=0;x<cg.getPieces().size();x++)
			{
				if(cg.getPieces().get(x).getType()==1 && cg.getPieces().get(x).getRow()==0)
				{
					Piece p;
					if(e.getKeyChar()=='q') {
                        p = cg.getPieces().remove(x);

                        cg.getPieces().add(new Queen(p.getRow(), p.getCol(), p.getColor(), true, 5, true));
						cg.setStatus(cg.PLAYING);

					}
					if(e.getKeyChar()=='r') {
                        p = cg.getPieces().remove(x);

                        cg.getPieces().add(new Rook(p.getRow(), p.getCol(), p.getColor(), true, 2, true));
						cg.setStatus(cg.PLAYING);

					}
					if(e.getKeyChar()=='b') {
                        p = cg.getPieces().remove(x);

                        cg.getPieces().add(new Bishop(p.getRow(), p.getCol(), p.getColor(), true, 4, true));
						cg.setStatus(cg.PLAYING);

					}
					if(e.getKeyChar()=='k') {
                        p = cg.getPieces().remove(x);

                        cg.getPieces().add(new Knight(p.getRow(), p.getCol(), p.getColor(), true, 3, true));
						cg.setStatus(cg.PLAYING);

					}
				}
			}
			cg.updateBoard();
		}
        updateStatus();
		repaint();
    }
 
    public void addNotify()
    {
        super.addNotify();
        requestFocus();
    }
    public BufferedImage scale(BufferedImage src, int w, int h)
    {
        BufferedImage img = 
                new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int x, y;
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[h];
        for (y = 0; y < h; y++)
            ys[y] = y * hh / h;
        for (x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }
    public static class MoveRandom
    {
        Piece p;
        int r;
        int c;

        public MoveRandom(Piece p, int r, int c)
        {
            this.p=p;
            this.r=r;
            this.c=c;
        }

        public Piece getP() {
            return p;
        }

        public void setP(Piece p) {
            this.p = p;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
    }
    public static class MoveWeight
    {
        Piece p;
        int r;
        int c;
        int weight;
        boolean changed = false;

        public MoveWeight(Piece p, int r, int c, int weight)
        {
            this.p=p;
            this.r=r;
            this.c=c;
            this.weight=weight;

        }

        public Piece getP() {
            return p;
        }

        public void setP(Piece p) {
            this.p = p;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public boolean getChanged() {
            return changed;
        }

        public void setChanged(boolean changed) {
            this.changed = changed;
        }
    }
}