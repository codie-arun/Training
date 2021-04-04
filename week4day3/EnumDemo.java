package week4day3;

public class EnumDemo {

	public static void main(String[] args) {
		
		Characters ch = Characters.CaptainAmerica;
		
		met(ch);
		
		switch(ch) {
		
		case Hulk:{
			System.out.println("switch Hulk");
			break;
		}
		case BlackPanther:{
			System.out.println("switch BlackPanther");
			break;
		}
		case CaptainAmerica:{
			System.out.println("switch CaptainAmerica");
			break;
		}
		
		}
		
		Characters c[] = Characters.values();
		
		for(Characters cc:c) {
			System.out.println(cc.getPower());
		}
		
		System.out.println("BlackPanther Power : "+Characters.BlackPanther.getPower());
	}
	
	public static void met(Characters c) {
		if(c == Characters.CaptainAmerica) {
			System.out.println("CaptainAmerica");
		}
		else if(c == Characters.Hulk) {
			System.out.println("Hulk");
		}
	}

}

enum Characters{
	
	Ironman(5000),Thor(4000),BlackPanther(3000),BlackWidow(2000),CaptainAmerica(1000),Hulk(10000);
	int power;
	
	Characters(int power){
		this.power = power;
	}
	
	public int getPower() {
		return this.power;
	}
	
}
