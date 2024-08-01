import java.util.Scanner;
public class Car {
	private double capienzaSerbatoio;
	private String tipoCarburante;
	private double carburanteAmount;
	private int resa;
	private String marca;
	private String modello;

	
	
	public Car() {
		capienzaSerbatoio=0.0;
		tipoCarburante="";
		resa=0;
		carburanteAmount=0;
		marca="";
		modello="";
		
		
	}
	
	
	public Car(double capienzaSerbatoio, String tipoCarburante, int resa, double carburanteAmount, String marca, String modello) {
		this.capienzaSerbatoio=capienzaSerbatoio;
		this.tipoCarburante=tipoCarburante;
		this.resa=resa;
		this.carburanteAmount = carburanteAmount;
		this.marca=marca;
		this.modello=modello;
	}


	public double getCapienzaSerbatoio() {
		return capienzaSerbatoio;
	}


	public void setCapienzaSerbatoio(double capienzaSerbatoio) {
		this.capienzaSerbatoio = capienzaSerbatoio;
	}


	public String getTipoCarburante() {
		return tipoCarburante;
	}


	public void setTipoCarburante(String tipoCarburante) {
		this.tipoCarburante = tipoCarburante;
	}


	public int getResa() {
		return resa;
	}


	public void setResa(int resa) {
		this.resa = resa;
	}


	public double getCarburanteAmount() {
		return carburanteAmount;
	}


	public void setCarburanteAmount(double carburanteAmount) {
		this.carburanteAmount = carburanteAmount;
	}
	
	
	
	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModello() {
		return modello;
	}


	public void setModello(String modello) {
		this.modello = modello;
	}


	//Metodi ausiliari
	public boolean addGas(double gas) {
		while(gas<=0) {
			Scanner input = new Scanner(System.in);
			System.out.println("Inserisci un importo maggiore di zero!!");
			String a = "Inserisci quantità: ";
			gas=stringToDouble(a);
		}
		if((carburanteAmount+gas)>capienzaSerbatoio) {
			System.out.println("La quantità richiesta: " + gas + " Litri, supera il residuo serbatoio auto: " + (carburanteAmount-capienzaSerbatoio) + " Litri"); 
			//gas = stringToDouble("Inserisci nuova quantità (max "+ (capienzaSerbatoio-carburanteAmount)+" Litri): ");
			return false;
		}else {
			carburanteAmount+=gas;
			System.out.println("Hai rifornito l'auto con " + gas + " Litri di carburante");
			System.out.println("Quantità aggiornata: " + carburanteAmount + " Litri");
			return true;
		}
		
	}
	
	public Double getConsumato(double distanza) {
		return distanza/resa;
	}
	
	public void drive(double distanza) {
		double consumoPrevisto = distanza/resa;
		if(carburanteAmount!=0) {
			if(consumoPrevisto<=carburanteAmount) {
				carburanteAmount-=consumoPrevisto;
				System.out.println("Hai percorso: " + distanza + " Km, consumando: " + consumoPrevisto + " Litri di carburante");
				System.out.println("Autonomia residua nel serbatoio: " + carburanteAmount + " Litri");
				System.out.println("Sei arrivato a destinazione !!");
			}else{
				double newDistanza = carburanteAmount*resa;
				double consumo = newDistanza/resa;
				double kmDaPercorrere=distanza-newDistanza;
				carburanteAmount-=consumo;
				System.out.println("Hai percorso: " + newDistanza + " Km");
				System.out.println("Rifornisci l'automobile per continuare il tuo viaggio (Km rimanenti: " + kmDaPercorrere + "Km )");
			}
		}else {
			System.out.println("La quantità di carburante presente nel serbatoio: " + carburanteAmount + " Litri, non consente di percorrere " + distanza + " Km, effettua prima un rifornimento");
		}
			
		/*if(consumoPrevisto<=carburanteAmount) {
			carburanteAmount-=consumoPrevisto;
			System.out.println("Hai percorso: " + distanza + " Km, consumando: " + consumoPrevisto + " Litri di carburante");
			System.out.println("Autonomia residua nel serbatoio: " + carburanteAmount + " Litri");
		}else if(carburanteAmount==0){
			System.out.println("La quantità di carburante presente nel serbatoio: " + carburanteAmount + " Litri, non consente di percorrere " + distanza + " Km, effettua un rifornimento prima");
			Scanner input= new Scanner(System.in);
			String a = "Inserisci quantità (Litri)";
			double amount = stringToDouble(a);
			addGas(amount);
		}
		
		if(distanza>(carburanteAmount*resa)){
			double newDistanza = carburanteAmount*resa;
			double consumo = newDistanza/resa;
			double kmDaPercorrere=distanza-newDistanza;
			carburanteAmount-=consumo;
			System.out.println("Tratta percorsa: " + newDistanza + " Km");
			System.out.println("Rifornisci l'automobile per continuare il viaggio e percorrere i : " + kmDaPercorrere + " Km rimanenti");
			String a = "Inserisci quantità (Litri)";
			double amount = stringToDouble(a);
			addGas(amount);
			double newConsumo=kmDaPercorrere/resa;
			carburanteAmount-=newConsumo;
			System.out.println("Hai percorso: " + kmDaPercorrere + " Km, consumando: " + newConsumo + " Litri di carburante");
			System.out.println("Autonomia residua nel serbatoio: " + carburanteAmount + " Litri");
			System.out.println("Viaggio completato. Rifornire l'automobile per ulteriori viaggi");
		}else {	
			double consumo = distanza/resa;
			carburanteAmount-=consumo;
			System.out.println("Hai percorso: " + distanza + " Km, consumando: " + consumo + " Litri di carburante");
			System.out.println("Autonomia residua nel serbatoio: " + carburanteAmount + " Litri");
		}*/
	}
		
		 
	
	
	public Double stringToDouble(String a) {
		boolean check;
		double number = 0;
		do {
			check=true;
			Scanner input = new Scanner(System.in);
			System.out.print(a + ": ");
			String s = input.nextLine();
			try {
				number = Double.parseDouble(s);
			}catch(Exception e) {
				check=false;
				System.out.println("Inserisci un double!!");
			}
		}while(!check);
		return number;
	}
	
	public int stringToInt(String a) {
		boolean check;
		int number = 0;
		do {
			check=true;
			Scanner input = new Scanner(System.in);
			System.out.print(a + ": ");
			String s = input.nextLine();
			try {
				number = Integer.parseInt(s);
			}catch(Exception e) {
				check=false;
				System.out.println("Inserisci un intero!!");
			}
		}while(!check);
		return number;
	}
	
	public void impostaAuto() {
		String a="";
		Scanner input = new Scanner(System.in);
		System.out.print("Inserisci marca automobile: ");
		marca=input.nextLine();
		System.out.print("Inserisci modello automobile: ");
		modello=input.nextLine();
		a = "Inserisci capienza serbatoio auto in litri";
		capienzaSerbatoio= stringToDouble(a);
		while(capienzaSerbatoio<=0) {
			System.out.println("Inserisci un valore maggiore di zero!!");
			capienzaSerbatoio= stringToInt(a);
		}
		System.out.print("Inserisci tipo carburante (diesel - verde): ");
		tipoCarburante = input.nextLine();
		while(!tipoCarburante.equalsIgnoreCase("diesel") && !tipoCarburante.equalsIgnoreCase("verde")) {
			System.out.println("Devi scegliere : diesel o verde!!");
			tipoCarburante = input.nextLine();
		}
		
		a = "Inserisci resa";
		resa= stringToInt(a);
		while(resa<=0) {
			System.out.println("Inserisci un valore maggiore di zero!!");
			resa= stringToInt(a);
		}
		
		
		
		
	}
	
	public boolean verificaSerbatoio(double euro, double costoCarburante){
		double amount = euro/costoCarburante;
		if(amount>capienzaSerbatoio) {
			return false;
		}
		return true;
	}
	
	
}
