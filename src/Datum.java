import java.time.LocalDate;

public class Datum {
	//Aufgabe 3
	public static void main(String[] args) {

		System.out.println(LocalDate.now());
		System.out.println("vv ---------------------------- vv");
		LocalDate minus4Weeks = LocalDate.now().minusWeeks(4);
		LocalDate minus1Month = LocalDate.now().minusMonths(1);
		System.out.println(minus4Weeks);
		System.out.println(minus1Month);
		if (minus1Month.equals(minus4Weeks)){
			System.out.println("^^   Die Daten sind identisch   ^^");
		} else {
			System.out.println("^^ Die Daten unterscheiden sich ^^");
		}
		System.out.println(minus4Weeks.getDayOfWeek());
		System.out.println(minus1Month.getDayOfWeek());

	}
}