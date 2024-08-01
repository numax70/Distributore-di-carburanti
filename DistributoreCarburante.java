/*
 *  Modificare la classe DistributoreBenzina, assegnata nell'esercizio precedente,
in modo che il distributore abbia due pompe, una di benzina verde ed una di
gasolio. Ciascun tipo di carburante ha il suo costo per litro. Conseguentemente,
dovrete raddoppiare il metodo rifornisci: dovrete avere un metodo per rifornire
la benzina verde ed un metodo per rifornire il gasolio. Il metodo vendi deve
essere modificato nel seguente modo: public void vendi(double euro, Car
unaAutomobile). Tale metodo rifornisce l'automobile specificata come parametro
esplicito nel modo appropriato (verde oppure gasolio).
Consigli:
Nel Tester create varie automobili e distributori. Fate compiere alcuni "viaggi"
alle automobili, e rifornitele di benzina in modo appropriato. Inoltre,
rifornite le pompe di benzina in caso di necessita
 * */
import java.util.Scanner;
public class DistributoreCarburante {
	private double depositoVerde;
	private double depositoGasolio;
	private double euroPerLitroVerde;
	private double euroPerLitroGasolio;
	private double incassoGiornaliero;
	private double contatoreRifornimentiGasolio;
	private double contatoreRifornimentiVerde;
	
	public DistributoreCarburante() {
		settaParametriDistributore();
		incassoGiornaliero=0.0;
	}
	
	public DistributoreCarburante(double depositoVerde, double depositoGasolio, double euroPerLitroVerde, double euroPerLitroGasolio) {
		this.depositoVerde=depositoVerde;
		this.depositoGasolio=depositoGasolio;
		this.euroPerLitroVerde=euroPerLitroVerde;
		this.euroPerLitroGasolio=euroPerLitroGasolio;
		
	}

	public double getDepositoVerde() {
		return depositoVerde;
	}

	public void setDepositoVerde(double depositoVerde) {
		this.depositoVerde = depositoVerde;
	}

	public double getDepositoGasolio() {
		return depositoGasolio;
	}

	public void setDepositoGasolio(double depositoGasolio) {
		this.depositoGasolio = depositoGasolio;
	}

	public double getEuroPerLitroVerde() {
		return euroPerLitroVerde;
	}

	public void setEuroPerLitroVerde(double euroPerLitroVerde) {
		this.euroPerLitroVerde = euroPerLitroVerde;
	}

	public double getEuroPerLitroGasolio() {
		return euroPerLitroGasolio;
	}

	public void setEuroPerLitroGasolio(double euroPerLitroGasolio) {
		this.euroPerLitroGasolio = euroPerLitroGasolio;
	}
	
	
	public double getIncassoGiornaliero() {
		return incassoGiornaliero;
	}

	public void setIncassoGiornaliero(double incassoGiornaliero) {
		this.incassoGiornaliero = incassoGiornaliero;
	}

	public double getContatoreRifornimentiGasolio() {
		return contatoreRifornimentiGasolio;
	}

	public void setContatoreRifornimentiGasolio(double contatoreRifornimentiGasolio) {
		this.contatoreRifornimentiGasolio = contatoreRifornimentiGasolio;
	}

	public double getContatoreRifornimentiVerde() {
		return contatoreRifornimentiVerde;
	}

	public void setContatoreRifornimentiVerde(double contatoreRifornimentiVerde) {
		this.contatoreRifornimentiVerde = contatoreRifornimentiVerde;
	}

	//Mrtodi Ausiliari
	public void rifornisciDepositoVerde(double amount) {
		//Rifornisce il deposito verde
		while(amount<=0) {
			Scanner input = new Scanner(System.in);
			System.out.println("Inserisci una quantità maggiore di zero!!");
			 String a = "Inserisci quantità";
			 amount=stringToDouble(a);
		}
		this.depositoVerde+=amount;
	}
	
	public void rifornisciDepositogasolio(double amount) {
		//Rifornisce il deposito gasolio
		while(amount<=0) {
			Scanner input = new Scanner(System.in);
			System.out.println("Inserisci una quantità maggiore di zero!!");
			 String a = "Inserisci quantità";
			 amount=stringToDouble(a);
		}
		this.depositoGasolio+=amount;
	}
	
		
	public void vendi(double euro, Car automobile) {
		//Vende il carburante e aggiorna il deposito
		Scanner input = new Scanner(System.in);
		while(euro<=0) {
			System.out.println("Inserisci importo maggiore di zero!!!");
			euro=stringToDouble("Inserisci nuovo importo");
		}
		String tipoAutomobile = automobile.getTipoCarburante();
		double capienza = automobile.getCapienzaSerbatoio();
		switch(tipoAutomobile) {
			case "diesel":
				double amount = euro/euroPerLitroGasolio;
				if(amount<=depositoGasolio) {
					if(amount<capienza) {
						if(automobile.addGas(amount)) {
							depositoGasolio-=amount;
							contatoreRifornimentiGasolio+=amount;
							incassoGiornaliero+=amount*euroPerLitroGasolio;
							System.out.println("L'automobile è stata rifornita con: " + amount + " Litri, per un importo di : " + euro + "€.");
							
						}
						
					}else if(amount>=capienza){
						System.out.println("La quantità richiesta: " + amount + " Litri, supera il residuo serbatoio auto: " + (capienza-automobile.getCarburanteAmount()) + " Litri.");
						
					}
				}else {
					System.out.println("La quantità richiesta: " + amount + " Litri, supera la disponibilità: " + depositoGasolio + " Litri. Effettuare un rifornimento al deposito di gasolio del distributore");
					
				}
				break;
			case "verde":
				amount = euro/euroPerLitroVerde;
				if(amount<=depositoVerde) {
					if(amount<=capienza) {
						if(automobile.addGas(amount)) {
							depositoVerde-=amount;
							contatoreRifornimentiVerde+=amount;
							incassoGiornaliero+=amount*euroPerLitroVerde;
							System.out.println("L'automobile è stata rifornita con: " + amount + " Litri, per un importo di : " + euro + "€.");
						
						}
					}else {
						System.out.println("La quantità richiesta: " + amount + " Litri, supera il residuo serbatoio auto: " + capienza + " Litri");
						return;
					}
				}else {
					System.out.println("La quantità richiesta: " + amount + " Litri, supera la disponibilità: " + depositoVerde + " Litri. Effettuare un rifornimento al deposito verde del distributore");
					return;
				}
				break;
			default:
				System.out.println("Deposito carburante non disponibile");
				break;
		}
	}
	
	public void settaPrezzoGasolio(double prezzo) {
		Scanner input = new Scanner(System.in);
		while(prezzo<=0) {
			System.out.println("Inserisci un valore maggiore di zero!!");
			prezzo=stringToDouble("Inserisci importo in euro");
		}
		this.euroPerLitroGasolio=prezzo;
	}
	
	public void settaPrezzoVerde(double prezzo) {
		Scanner input = new Scanner(System.in);
		while(prezzo<=0) {
			System.out.println("Inserisci un valore maggiore di zero!!");
			prezzo=stringToDouble("Inserisci importo in euro");
		}
		this.euroPerLitroVerde=prezzo;
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
				System.out.println("Inserisci un intero!!");
			}
		}while(!check);
		return number;
	}
	
	public void settaParametriDistributore() {
		String a = "";
		Scanner input = new Scanner(System.in);
		a = "Imposta quantità iniziale deposito gasolio";
		depositoGasolio = stringToDouble(a);
		while(depositoGasolio<=0) {
			System.out.println("inserisci quantità maggiore di zero!!");
			depositoGasolio = stringToDouble(a);
		}
		a = "Imposta quantità iniziale deposito verde";
		depositoVerde = stringToDouble(a);
		while(depositoVerde<=0) {
			System.out.println("inserisci quantità maggiore di zero!!");
			depositoVerde = stringToDouble(a);
		}
		a = "Setta prezzo gasolio";
		euroPerLitroGasolio = stringToDouble(a);
		while(euroPerLitroGasolio<=0) {
			System.out.println("inserisci importo maggiore di zero!!");
			euroPerLitroGasolio = stringToDouble(a);
		}
		a = "Setta prezzo verde";
		euroPerLitroVerde = stringToDouble(a);
		while(euroPerLitroVerde<=0) {
			System.out.println("inserisci importo maggiore di zero!!");
			euroPerLitroVerde = stringToDouble(a);
		}
		
	}
	
	
	
	
}
