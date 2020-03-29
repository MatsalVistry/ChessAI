public abstract class Piece 
{
	private int r;
	private int c;
	private boolean alive;
	private int color;
	private int type;
	
	public Piece(int r, int c, int color, boolean alive, int type)
	{
		this.r = r;
		this.c = c;
		this.color = color;
		this.alive = alive;
		this.type = type;
	}
	
	public int getType()
	{
		return type;
	}
	public int getColor()
	{
		return color;
	}
	public abstract int getRow();

	public abstract int getCol();
	
	public abstract void setRow(int x);

	public void change(int x, int y)
	{
		r=x;
		c=y;
	}
	public abstract void setCol(int y);
	
	public abstract boolean[][] getAvailableMoves(Piece[][] board);
	

}
