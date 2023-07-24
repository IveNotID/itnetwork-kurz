package cz.klb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplikace {

    private List<Pojistenec> pojistenci;
    public Scanner sc;

    public Aplikace() {
        pojistenci = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void start() {
        int vstupMenu = 0;
        while (vstupMenu != 4) {
            vstupMenu = 0;
            System.out.println("-------------------------");
            System.out.println("Evidence pojištěných");
            System.out.println("-------------------------");
            System.out.println();
            System.out.println("Vyberte akci:");
            System.out.println("1 - Přidat nového pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");
            while (vstupMenu < 1 || vstupMenu > 4) {
                System.out.println();
                try {
                    vstupMenu = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Zadejte prosím číslo.");
                    continue;
                }
                switch (vstupMenu) {
                    case 1:
                        pridatPojistence();
                        break;
                    case 2:
                        vypisPojistene();
                        break;
                    case 3:
                        najdiPojisteneho();
                        break;
                    case 4:
                        System.out.println("Zavírám aplikaci...");
                        break;
                    default:
                        System.out.println("Zadejte prosím číslo v menu.");
                        break;
                }
            }
        }
    }

    private void pridatPojistence() {
        System.out.println();
        System.out.println("Zadejte křestní jméno:");
        String jmeno = sc.nextLine();
        jmeno = jmeno.trim().substring(0, 1).toUpperCase() + jmeno.substring(1).toLowerCase();
        System.out.println("Zadejte příjmení:");
        String prijmeni = sc.nextLine();
        prijmeni = prijmeni.trim().substring(0, 1).toUpperCase() + prijmeni.substring(1).toLowerCase();
        System.out.println("Zadejte věk:");
        int vek = -99;
        while (vek < 0) {
            try {
                vek = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Zadávejte pouze čísla.");
                continue;
            }
            if (vek < 0) {
                System.out.println("Zadejte platný věk.");
            }
        }
        System.out.println("Zadejte telefonní číslo:");
        int telCislo = 0;
        String telCisloDelka = Integer.toString(telCislo);
        while (telCisloDelka.length() != 9) {
            try {
                telCislo = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Zadávejte pouze čísla.");
                continue;
            }
            telCisloDelka = Integer.toString(telCislo);
            if (telCisloDelka.length() != 9) {
                System.out.println("Zadejte devítimístné číslo bez předvolby.");
            }
        }
        pojistenci.add(new Pojistenec(jmeno, prijmeni, vek, telCislo));
        System.out.println();
        System.out.println("Pojištěný přidán");
        System.out.println();
        System.out.println("Stiskněte ENTER pro pokračování...");
        sc.nextLine();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private void vypisPojistene() {
        System.out.println();
        System.out.println("Seznam pojištěných:");
        System.out.println();
        for (Pojistenec pojistenec : pojistenci) {
            System.out.println(pojistenec);
            System.out.println();
        }
        System.out.println();
        System.out.println("Stiskněte ENTER pro pokračování...");
        sc.nextLine();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private void najdiPojisteneho() {
        System.out.println();
        System.out.println("Zadejte křestní jméno pojištěného:");
        String jmeno = sc.nextLine().trim();
        System.out.println("Zadejte přijmení pojištěného:");
        String prijmeni = sc.nextLine().trim();
        int pocetNalezenych = 0;
        System.out.println();
        for (Pojistenec pojistenec : pojistenci) {
            if (pojistenec.getJmeno().equalsIgnoreCase(jmeno) && pojistenec.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                pocetNalezenych++;
                System.out.println(pojistenec);
                System.out.println();
            }
        }
        System.out.println("Nalezeno " + pocetNalezenych + " záznamů.");
    }


}
