
class Square
{
	
	Square(){}
	Square(int _height, int _width){
		width = _width;
		height = _height;
	}
	
	int width;
	int height;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	int Area(int width, int height)
	{
		return width * height;
	}
	
	
}
public class AreaOfShapes {
	
	public static void main(String[] args) 
	{
		Square sq = new Square(10,10);
		int area = sq.Area(sq.height, sq.width);
		System.out.println(area);
		
		System.out.println(AreaOfShape(sq));
	}
	
	
	
public static int AreaOfShape(Object obj){
	String shapeType = obj.getClass().getName();
	System.out.println(shapeType);
	
	return ((Square) obj).getHeight() * ((Square) obj).getWidth();
}


}
