
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("##OPERAZIONI INIZIALI GESTIONE DISTRIBUTORE DI CARBURANTI##");
		DistributoreCarburante distributore = new DistributoreCarburante();
		Car auto = new Car();
		Menu menu = new Menu();
		menu.operazioni(distributore, auto);

	}

}
