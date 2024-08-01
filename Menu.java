import java.util.Scanner;
public class Menu extends Exception{
	public void mainMenu() {
		System.out.println("\n##MENU' DI GESTIONE##\n1) - Giacenza deposito gasolio;\n2) - Giacenza deposito Verde;\n3) - Imposta prezzo gasolio/litro;\n4) - Imposta prezzo verde/litro;\n5) - Rifornisci gasolio;\n6) - Rifornisci verde;\n7) - Vendi carburante;\n8) - Effettua un viaggio;\n9) - Incassi;\n10) - Esci dal programma");
	}
	
	public void operazioni(DistributoreCarburante distributore, Car automobile) {
		int scelta=0;
		String a="";
		double amount=0;
		do {
			mainMenu();
			scelta = stringToInt("\nInserisci scelta");
			switch(scelta) {
			case 1:
				//Giacenza deposito gasolio
				System.out.println("\nQuantità gasolio disponibile: " + distributore.getDepositoGasolio() + " Litri\n");
				break;
			case 2:
				//Giacenza deposito Verde
				System.out.println("\nQuantità verde disponibile: " + distributore.getDepositoVerde() + " Litri\n");
				break;
			case 3:
				//Imposta prezzo gasolio/litro
				System.out.println("prezzo attuale: " + distributore.getEuroPerLitroGasolio());
				a="Inserisci prezzo gasolio";
				double prezzoGasolio = stringToDouble(a);
				distributore.settaPrezzoGasolio(prezzoGasolio);
				System.out.println("Nuovo prezzo gasolio: " + prezzoGasolio + "€.");
				break;
			case 4:
				//Imposta prezzo euro/litro
				System.out.println("prezzo attuale: " + distributore.getEuroPerLitroVerde());
				a="Inserisci prezzo verde";
				double prezzoVerde = stringToDouble(a);
				distributore.settaPrezzoVerde(prezzoVerde);
				System.out.println("Nuovo prezzo verde: " + prezzoVerde + "€.");
				break;
			case 5:
				//Rifornisci gasolio
				System.out.println("Quantità attuale: " + distributore.getDepositoGasolio()+ " Litri");
				a = "Inserisci quantità";
				amount = stringToDouble(a);
				distributore.rifornisciDepositogasolio(amount);
				System.out.println("Hai rifornito il deposito gasolio con: " + amount + " Litri di carburante");
				System.out.println("Quantità aggiornata: " + distributore.getDepositoGasolio()+ " Litri");
				break;
			case 6:
				//Rifornisci verde
				System.out.println("Quantità attuale: " + distributore.getDepositoVerde()+ " Litri");
				a = "Inserisci quantità";
				amount = stringToDouble(a);
				distributore.rifornisciDepositoVerde(amount);
				System.out.println("Hai rifornito il deposito verde con: " + amount + " Litri di carburante");
				System.out.println("Quantità aggiornata: " + distributore.getDepositoVerde()+ " Litri");
				break;	
			case 7:
				//Vendi carburante
				Scanner input = new Scanner(System.in);
				String marca="";
				String modello="";
				System.out.print("Nuovo rifornimento - ");
				if(automobile.getTipoCarburante()=="") {
					automobile.impostaAuto();
				}
				a = "Inserisci importo in euro";
				double euro=stringToDouble(a);
				String tipoCarburante = automobile.getTipoCarburante();
				distributore.vendi(euro, automobile);
				break;
			case 8:
				//Effettua un viaggio
				while(automobile.getTipoCarburante()=="") {
					automobile.impostaAuto();
				}
				a="Inserisci distanza da percorrere";
				double distanza = stringToDouble(a);
				automobile.drive(distanza);
				break;
			case 9:
				System.out.println("Gasolio erogato: " + distributore.getContatoreRifornimentiGasolio() + " Litri");
				System.out.println("Verde erogata: " + distributore.getContatoreRifornimentiVerde() + " Litri");
				System.out.println("Incasso odierno: " + distributore.getIncassoGiornaliero() + "€.");
				break;
			case 10:
				System.out.println("Grazie per aver utilizzato il programma");
				break;
			default:
				System.out.println("Scelta non disponibile");
			}
		}while(scelta!=10);
		
		
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
}
