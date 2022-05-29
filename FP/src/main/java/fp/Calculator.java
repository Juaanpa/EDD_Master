package fp;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

public class Calculator {

	public static void main(String[] args) {
		stepThisNumber(4, 1);

	}

	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		return x.getClass();
	}

	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {
		throw new NotImplementedException("no implementado");
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int size = 0;
		for (int i = number - step; i > 0; i -= step) {
			if (number - step >= 0) {
				size++;
			}
		}

		int[] numbersArray = new int[size];
		for (int i = number - step, j = 0; i > 0; i -= step, j++) {
			numbersArray[j] = i;
		}
		return numbersArray;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int size = 0;

		for (int x = n; x > 0; x--) {
			if (n % x == 0)
				size++;
		}
		int divisores[] = new int[size];
		for (int i = n, j = 0; i > 0; i--) {
			if (n % i == 0) {
				divisores[j] = i;
				j++;
			}
		}
		return divisores;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		cadena = cadena.toLowerCase();
		cadena = cadena.replace(" ", "");
		cadena = cadena.replace(",", "");
		cadena = cadena.replace(".", "");
		cadena = cadena.replace(":", "");
		cadena = cadena.replace("·", "");
		cadena = cadena.replace("?", "");
		cadena = cadena.replace("¿", "");
		cadena = cadena.toLowerCase().replace("á", "a");
		cadena = cadena.toLowerCase().replace("é", "e");
		cadena = cadena.toLowerCase().replace("í", "i");
		cadena = cadena.toLowerCase().replace("ó", "o");
		cadena = cadena.toLowerCase().replace("ú", "u");
		cadena = cadena.toLowerCase().replace("à", "a");
		cadena = cadena.toLowerCase().replace("è", "e");
		cadena = cadena.toLowerCase().replace("ì", "i");
		cadena = cadena.toLowerCase().replace("ò", "o");
		cadena = cadena.toLowerCase().replace("ù", "u");

		System.out.print(cadena);
		int fin = cadena.length() - 1;
		int ini = 0;
		boolean espalin = true;

		while (ini < fin) {
			if (cadena.charAt(ini) != cadena.charAt(fin))
				espalin = false;

			ini++;
			fin--;
		}

		return espalin;

	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String unidades[] = { "Cero", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve" };
		String decenas[] = { "Dieci", "Veinti", "Treinta y ", "Cuarenta y ", "Cincuenta y ", "Sesesenta y ",
				"Setenta y ", "Ochenta y ", "Noventa y " };
		String especiales[] = { "Diez", "Once", "Doce", "Trece", "Catorce", "Quince", "Veinte" };
		int unidad = n % 10;
		int decena = n / 10;
		if (decena == 1 && unidad <= 5) {
			switch (unidad) {
			case 0:
				return especiales[0];
			case 1:
				return especiales[1];
			case 2:
				return especiales[2];
			case 3:
				return especiales[3];
			case 4:
				return especiales[4];
			case 5:
				return especiales[5];
			}
		}
		if (decena == 2 && unidad == 0) {
			return especiales[6];
		}
		return decenas[decena - 1] + unidades[unidad];
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		fecha = fecha.substring(fecha.length() -4, fecha.length());
		int year=Integer.parseInt(fecha);
		boolean bisiesto = false;
		if (year%4==0) {
			if (year%100==0) {
				if (year%400==0) {
					bisiesto=true;
				}else {
					bisiesto=false;
				}
			} else {
				bisiesto=true;
			}
		}else {
			bisiesto=false;
		}
		return bisiesto;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
//		if(date.length()!=10) {
//			return false;
//		}
//		int dia=Integer.parseInt(date.substring(0,1));
//		int mes=Integer.parseInt(date.substring(3,4));
//		int anio=Integer.parseInt(date.substring(6,9));
		boolean validDate=false;
//		if (dia<=0 || dia>31 || mes<=0 || mes >12 || anio==0) {
//			return false;
//		}
		
		int contador=0;
		for (int i=0;i<date.length();i++) {		
			if (date.charAt(i)=='-') {
				contador++;
			}else if ("bcdfghjklmnñpqrstvwxyz".contains(String.valueOf(date.charAt(i)))) {
				return false;
			}
			
		}
		if (contador==2 && date.length()==10) {
			if ((date.charAt(1)=='0' || date.charAt(4)=='0' || (date.substring(6)=="0000"))) {
				return false;
			}
			validDate=true;
		}
		return validDate;
	}
}
