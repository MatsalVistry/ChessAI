import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
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
    private Piece selected = null;
    
    

    
    public ChessPanel ()
    {
        super();
        addMouseListener(this);
        addKeyListener(this);
 
        setSize(600,600);
        
        
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
        }
        catch(Exception e)
        {
            System.out.println("Error Loading Images: " + e.getMessage());
        }
 
 
    }
    public void paint(Graphics g)
    {
    	//if selected is true, print spheres on allowed locations
    	Color lightBrown = new Color(178, 113, 33);
        Color darkBrown = new Color(96, 58, 10);
        
        for(int x=0;x<600;x+=75)
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
        	for(int y=0;y<600;y+=75)
        	{
        		if(cg.getBoard()[x/75][y/75]!= null)
        		{
	        		if(cg.getBoard()[x/75][y/75].getType()==1)
	        		{
	        			if(cg.getBoard()[x/75][y/75].getColor()==0)
	            		{
	            			g.drawImage(WhitePawn,y,x,null);
	            		}
	        			else 
	            			g.drawImage(BlackPawn,y,x,null);
	        		}
	        		if(cg.getBoard()[x/75][y/75].getType()==2)
	        		{
	        			if(cg.getBoard()[x/75][y/75].getColor()==0)
	            		{
	            			g.drawImage(WhiteRook,y,x,null);
	            		}
	        			else 
	            			g.drawImage(BlackRook,y,x,null);
	        		}
	        		if(cg.getBoard()[x/75][y/75].getType()==3)
	        		{
	        			if(cg.getBoard()[x/75][y/75].getColor()==0)
	            		{
	            			g.drawImage(WhiteKnight,y,x,null);
	            		}
	        			else 
	            			g.drawImage(BlackKnight,y,x,null);
	        		}
	        		if(cg.getBoard()[x/75][y/75].getType()==4)
	        		{
	        			if(cg.getBoard()[x/75][y/75].getColor()==0)
	            		{
	            			g.drawImage(WhiteBishop,y,x,null);
	            		}
	        			else 
	            			g.drawImage(BlackBishop,y,x,null);
	        		}
	        		if(cg.getBoard()[x/75][y/75].getType()==5)
	        		{
	        			if(cg.getBoard()[x/75][y/75].getColor()==0)
	            		{
	            			g.drawImage(WhiteQueen,y,x,null);
	            		}
	        			else 
	            			g.drawImage(BlackQueen,y,x,null);
	        		}
	        		if(cg.getBoard()[x/75][y/75].getType()==6)
	        		{
	        			if(cg.getBoard()[x/75][y/75].getColor()==0)
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
        			
        			if(arr[x][y]==true)
        			{
        				g.setColor(Color.BLUE);
        				g.fillOval(y*75+25, x*75+25, 30, 30);
        			}
        			
        		}
        	}
        }
        
        
        
        
       
 
    }
    public boolean isValidMove(int oldr, int oldc, int r, int c, Piece p)
    {
    	boolean [][] arr = selected.getAvailableMoves(cg.getBoard());

		Piece pp = cg.movePiece(oldr,oldc,r,c,p);
    	
    	if(arr[r][c]==true && inCheck(selected.getColor())==false)
    	{
    		cg.revertMovePiece(oldr,oldc, selected, pp);
			return true;
		}
		cg.revertMovePiece(oldr,oldc, selected, pp);
		return false;
    }
    public boolean inCheck(int color)
    {
    	// get available moves of all pieces of opposite color
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
    						System.out.print("SFHAIUSHFBGYUIASBGYUFBGDUAYSFBYUSDBGYUFBGSEDUFYBUYSDFBGYUBGSDFUYG");
    						return true;
    					}
    				}
    			}
    		}
    	}
    	
    	
    	return false;
    }
 
    public void mouseClicked(MouseEvent e)
    {
    	if(cg.getTurn() == cg.WHITE)
    	{
    		for(int y=0;y<600;y+=75)
    		{
    			for(int x=0;x<600;x+=75)
    			{
    				if (selected == null && e.getX() > x && e.getX() < x+75 && e.getY()>y && e.getY()<y+75 && cg.getBoard()[y/75][x/75]!=null && cg.getBoard()[y/75][x/75].getColor()==cg.WHITE) 
    	    		{
    	                selected = cg.getBoard()[y/75][x/75];
    	                System.out.println("Color:"+ selected.getColor()+" Piece:"+selected.getType());
    	                
    	                boolean [][] arr = selected.getAvailableMoves(cg.getBoard());
    	            	
    	            	for(int z=0;z<8;z++)
    	        		{
    	        			for(int c=0; c<8; c++)
    	        			{
    	        				System.out.print(arr[z][c]);
    	        			}
    	        			System.out.print("\n");
    	        		}
    	            }
    				else if (selected != null && e.getX() > x && e.getX() < x+75 && e.getY()>y && e.getY()<y+75 && cg.getBoard()[y/75][x/75]!=null && cg.getBoard()[y/75][x/75].equals(selected)) 
    	    		{
    	                selected = null;
    	                System.out.println("Unselected");
    	            }
    				else if (selected != null && e.getX() > x && e.getX() < x+75 && e.getY()>y && e.getY()<y+75 && (cg.getBoard()[y/75][x/75]==null || cg.getBoard()[y/75][x/75].getColor()!=selected.getColor()) && isValidMove(selected.getRow(),selected.getCol(),y/75,x/75,selected)==true)
    	    		{
    					cg.movePiece(selected.getRow(),selected.getCol(),y/75,x/75, selected);
    					
    	                selected = null;
    	                cg.setTurn(cg.BLACK);
    	                System.out.println("Successful Move White Player");
    	                cg.printBoard();
    	            }				
    			}
    		}
    	}
    	else if(cg.getTurn() == cg.BLACK)
    	{
    		for(int y=0;y<600;y+=75)
    		{
    			for(int x=0;x<600;x+=75)
    			{
    				if (selected == null && e.getX() > x && e.getX() < x+75 && e.getY()>y && e.getY()<y+75 && cg.getBoard()[y/75][x/75]!=null && cg.getBoard()[y/75][x/75].getColor()==cg.BLACK) 
    	    		{
    	                selected = cg.getBoard()[y/75][x/75];
    	                System.out.println("Color:"+ selected.getColor()+" Piece:"+selected.getType());
    	            }
    				else if (selected != null && e.getX() > x && e.getX() < x+75 && e.getY()>y && e.getY()<y+75 && cg.getBoard()[y/75][x/75]!=null && cg.getBoard()[y/75][x/75].equals(selected)) 
    	    		{
    	                selected = null;
    	                System.out.println("Unselected");
    	            }
    				else if (selected != null && e.getX() > x && e.getX() < x+75 && e.getY()>y && e.getY()<y+75 && (cg.getBoard()[y/75][x/75]==null || cg.getBoard()[y/75][x/75].getColor()!=selected.getColor())&& isValidMove(selected.getRow(),selected.getCol(),y/75,x/75,selected)==true)
    	    		{
    					cg.movePiece(selected.getRow(),selected.getCol(),y/75,x/75,selected);
    	                selected = null;
    	                cg.setTurn(cg.WHITE);
    	                System.out.println("Successful Move Black Player");
    	                cg.printBoard();
    	            }				
    			}
    		}
    	}
    	
    	
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
 
    public void keyReleased(KeyEvent e) {
 
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
}