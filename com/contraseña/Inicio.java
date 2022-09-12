package com.contraseña;

import java.util.Scanner;

public class Inicio {

	/**
	 * 
	 * @author Francisco Javier Tortosa
	 * 
	 * @implSpec
	 * En este ejercicio debemos crear una clase que genere contraseñas aleatorias
	 * compuestas por letras mayúsculas, minúsculas y números. Dichas contraseñas
	 * serán de la longitud que quiera el usuario y dicha longitud se le pedirá por
	 * teclado desde una ventana JOptionPane. Las contraseñas se almacenarán en un
	 * Array cuyo tamaño también se le pedirá al usuario por teclado a través de una
	 * ventana JOptionPane.
	 * 
	 * Recapitulando, al ejecutar el programa este pedirá al usuario el tamaño del
	 * Array (imaginemos que el usuario introduce 4) y la longitud de las
	 * contraseñas (imaginemos que el usuario introduce 7). El programa deberá
	 * generar entonces 4 contraseñas de 7 caracteres cada una.
	 * 
	 * El programa imprimirá en consola todas las contraseñas generadas, el nº de
	 * caracteres de cada una de ellas y si la contraseña es segura o débil en
	 * función de la siguiente condición:
	 * 
	 * Se considerará contraseña segura aquella que esté formada por más de cinco
	 * números, tenga más de una letra minúscula y más de dos letras mayúsculas.
	 * 

	 * Como siempre, hay infinitas formas de hacer esta aplicación, pero en este
	 * caso se pide que el programa tenga:
	 * 
	 * Una clase que construya las contraseñas y una clase principal La clase que
	 * construya las contraseñas deberá tener: Un constructor (diferente del
	 * constructor por defecto) Dos métodos getters. Uno devolverá la contraseña
	 * generada y el otro la longitud de la misma. Un método encargado de generar
	 * (construir) la contraseña. Un método que evalúe y devuelva si la contraseña
	 * es segura o débil en función de las condiciones antes descritas.
	 * 
	 * PARA REALIZAR ESTE EJERCICIO VAS A TENER QUE CONSULTAR LOS CÓDIGOS ASCII DE
	 * LAS LETRAS DEL ABACEDARIO Y NÚMEROS DEL 1 AL 9. PUEDES ENCONTRARLOS AQUÍ:
	 *
	 
	 * @category
	 * Ejercicio de Practicas
	 *
	 
	 * @link 
	 * http://www.elcodigoascii.com.ar/codigos-ascii/letra-a-mayuscula-codigo-ascii-65.html
	 *

	 * @implNote
	 * ascii
	 * 48 - 57	numeros de 0-9 // 65 - 90 Letras A-Z // 97 - 122 Letras a-z
	 *
	
	 * @implSpec
	 * 
	
	 * @serialData 2022/08/29
	 * @param args
	 */
	public static void main(String[] args) {

		// iniciamos variables
		
		int cantidadDePass	= 10; 	// cantidad de pass que queremos 
		int longitudPass	= 15;	// tamaño de cada pass 
		int longitudPassVar = 0;	// para que cambie el tamaño de las pass o no
		int longitudPassMax	= 15;	// tamaño de cada pass maximo
		int longitudPassMin	= 5;	// tamaño de cada pass maximo
		boolean seguro		= false;// si es seguro(true) o debil(false)
		String txtSeguro	= "";	// texto de "seguro" o "debil"
		
		Passwords pass;				// instanciamos el objeto pass
		
		
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner para entrada por teclado
		
		// pedimos los datos por teclado
		System.out.println("Introduzca cantidad de Passwords que desea generar:");
		cantidadDePass = entradaEscaner.nextInt();
		
		System.out.println("Longitud de las paswords unica(0) o variable(1)");
		longitudPassVar=entradaEscaner.nextInt();
		
		if (longitudPassVar==0) {
			System.out.println("Introduzca el tamaño de cada Password: ");
			longitudPass=entradaEscaner.nextInt();
			longitudPassMax = longitudPass;
			longitudPassMin = 0;
		} else{
			System.out.println("Introduzca el tamaño maximo de cada Password: ");
			longitudPassMax=entradaEscaner.nextInt();
			System.out.println("Introduzca el tamaño minimo de cada Password: ");
			longitudPassMin=entradaEscaner.nextInt();
		}
			
		
			
		System.out.println("");

		//creamos el array con el tamaño que necesitamos
		String passObtenido[][][]=new String[cantidadDePass][2][2];
		
		// iniciamos bucle para generar las claves
		for (int i = 0; i<passObtenido.length; i++) {
			//pass = new Passwords(longitudPass); // llamamos al constructor para que genere la clave
			pass = new Passwords(longitudPassMax,longitudPassMin);
			
			seguro = pass.evaluaPass(pass.getPassGenerado()); // evaluamos si es segura o debil
			
			// convertimos el true o false de la comprobacion de las pass en "Segura" o "Debil"
			if (seguro) {
				txtSeguro="Segura";
			} else { 
				txtSeguro="Debil";
			}

			// rellenamos el array
			passObtenido[i][0][0]=pass.getPassGenerado(); 					// metemos el pass
			passObtenido[i][1][0]=String.valueOf(pass.getLongitudPass());	// metemos el tamaño
			passObtenido[i][0][1]=txtSeguro;								// metemos Segura o debil
		}
		
		// mostramos por pantalla el array con las pass y si es segura o debil
		System.out.println("");
		
		String muestraPass; // clave que tiene espacios añadidos al final para verla bien por consola
		
		for (int i = 0; i<passObtenido.length; i++) {
			muestraPass=passObtenido[i][0][0];

			//ajustamos el tamaño de cada pass para que se vea bien por consola
			if (muestraPass.length()<longitudPassMax) {
				int sumaEspacios = longitudPassMax - muestraPass.length();
				for (int j =0;j<sumaEspacios; j++) {
					muestraPass += " ";
				}	
			}
			if ( i < 9 ) {
				System.out.print(" [");
			} else {
				System.out.print("[");
			}
				
			System.out.println((i+1)+"]"+" Password: " + muestraPass +"\tTamaño: "+ passObtenido[i][1][0]
					+"\tTipo: "+passObtenido[i][0][1]);
			
//			System.out.println("["+(i+1)+"]"+" Password: " + passObtenido[i][0][0] +"\tTamaño: "+ passObtenido[i][1][0]
//					+"\tTipo: "+passObtenido[i][0][1]);
		}
		
		entradaEscaner.close(); //cerramos el objeto scanner
	}

}
