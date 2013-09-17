//isOverlap(rect a, rect b)
class Point{
	int x;
	int y;
	public Point(int _x, int _y){
		this.x=_x;
		this.y=_y;
	}
}
class Rect{
	Point point1;
	Point point2;
	Point point3;
	Point point4;
	public Rect(Point p1, Point p2, Point p3, Point p4){ //Clockwise
		this.point1=p1;
		this.point2=p2;
		this.point3=p3;
		this.point4=p4;
	}
}
public  boolean isOverlap(Rect a, Rect b){
	int mid_x_a = (a.point1.x+a.point2.x)/2;
	int mid_y_a = (a.point1.y+a.point3.y)/2;
	int mid_x_b = (b.point1.x+b.point2.x)/2;
	int mid_y_b = (b.point1.y+b.point2.y)/2;
	
	int upper_x = Math.abs(a.point2.x-a.point1.x)/2+Math.abs(b.point2.x-b.point1.x)/2;
	int upper_y = Math.abs(a.point1.y-a.point4.y)/2+Math.abs(b.point1.y-b.point4.y)/2;
	if(Math.abs(mid_x_a-mid_x_b)<upper_x&&Math.abs(mid_y_a-mid_y_b)<upper_y)
		return true;
	else
		return false;
}
