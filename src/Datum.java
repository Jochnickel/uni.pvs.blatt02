import java.time.LocalDate;

public class Datum {
	//Aufgabe 3
	public static void main(String[] args) {

		System.out.println(LocalDate.now());
		System.out.println("vv ---------------------------- vv");
		System.out.println(LocalDate.now().minusWeeks(4));
		System.out.println(LocalDate.now().minusMonths(1));
		System.out.println("^^ Die Daten unterscheiden sich ^^");
		System.out.println(LocalDate.now().minusWeeks(4).getDayOfWeek());
		System.out.println(LocalDate.now().minusMonths(1).getDayOfWeek());

	}
}