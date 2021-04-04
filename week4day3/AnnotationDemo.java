package week4day3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class AnnotationDemo {

	public static void main(String[] args) throws Exception{
		PaintBrush brush = PaintContainer.getBrush();
		brush.doPaint();
	}

}

@Retention(RetentionPolicy.RUNTIME)
@interface Di{
	String paintclass();
}

class PaintContainer{
	
	public static PaintBrush getBrush() throws Exception{
		PaintBrush brush = new PaintBrush();
		Field f = brush.getClass().getDeclaredField("paint");
		f.setAccessible(true);
		Di di = f.getAnnotation(Di.class);
		
		if(di!=null) {
			String paintclass = di.paintclass();	
			brush.paint = (Paint)Class.forName(paintclass).getConstructor().newInstance(null);
		}else {
			
		}
		
		return brush;
	}
	
	
	
}


class PaintBrush{
	
	@Di(paintclass = "week4day3.BluePaint")
	Paint paint;
	public void doPaint() {
		System.out.println(paint);
	}
	
}



abstract class Paint{
	public Paint() {
		// TODO Auto-generated constructor stub
	}
}

class RedPaint extends Paint{
	public RedPaint() {
		// TODO Auto-generated constructor stub
	}
}

class BluePaint extends Paint{
	public BluePaint() {
		// TODO Auto-generated constructor stub
	}
}