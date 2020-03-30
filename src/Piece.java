public abstract class Piece 
{
	private int r;
	private int c;
	private boolean alive;
	private int color;
	private int type;
	private boolean hasMoved;
	private int weight;
	
	public Piece(int r, int c, int color, boolean alive, int type, boolean hasMoved, int weight)
	{
		this.r = r;
		this.c = c;
		this.color = color;
		this.alive = alive;
		this.type = type;
		this.hasMoved=hasMoved;
		this.weight=weight;
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

	public abstract boolean hasMoved();
	
	public abstract void setRow(int x);


	public abstract void setCol(int y);

	public abstract void setWeight(int x);


	public abstract int getWeight();

	public abstract void setHasMoved(boolean hasMoved);
	
	public abstract boolean[][] getAvailableMoves(Piece[][] board);
	

}
