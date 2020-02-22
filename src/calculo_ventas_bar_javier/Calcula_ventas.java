package calculo_ventas_bar_javier;

import java.util.Scanner;

public class Calcula_ventas {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		String codigo_ingresado = "";
		String precio_ingresado = "";
		
		double precio_desayunos = 0;
		double precio_comidas = 0;
		double precio_meriendas = 0;
		double precio_cenas = 0;
		double precio_copas = 0;
		
		double precio_minimo = 0;
		double precio_maximo = 0;
		
		int indice_salida_max = 0;
		int indice_salida_min = 0;
		
		double ingresos_totales = 0;		
		double media_total = 0;		
		double media_comidas = 0;		
		int ventas_comidas = 0;
		
		String supera_media = "";
		
		int empate_min = 0;
		int empate_max = 0;
		
//SOLICITA CÓDIGOS, LOS EVALÚA Y SOLICITA VALORES HASTA DAR FIN CON "N"
		
		do {
			System.out.println("Ingresa el código");		
			codigo_ingresado = entrada.nextLine();
		
		switch (codigo_ingresado) {
		
		case "D":
			
			System.out.println("Ingresa el precio");			
			precio_ingresado = entrada.nextLine();
			
			precio_desayunos = Double.parseDouble(precio_ingresado) + precio_desayunos;
			break;
			
		case "A":
			
			System.out.println("Ingresa el precio");			
			precio_ingresado = entrada.nextLine();
			
			precio_comidas = Double.parseDouble(precio_ingresado) + precio_comidas;
			
			ventas_comidas++;
			break;
			
		case "M":
			
			System.out.println("Ingresa el precio");			
			precio_ingresado = entrada.nextLine();
			
			precio_meriendas = Double.parseDouble(precio_ingresado) + precio_meriendas;			
			break;
			
		case "I":
			
			System.out.println("Ingresa el precio");			
			precio_ingresado = entrada.nextLine();
			
			precio_cenas = Double.parseDouble(precio_ingresado) + precio_cenas;			
			break;
			
		case "C":
			
			System.out.println("Ingresa el precio");			
			precio_ingresado = entrada.nextLine();
			
			precio_copas= Double.parseDouble(precio_ingresado) + precio_copas;			
			break;
			
		case "N": 
			
// EVALÚA VALORES Y DETERMINA MÁXIMOS, MÍNIMOS Y VALORES TOTALES PARA CALCULAR LA MEDIA
			
			
			double[] precios_totales = {precio_desayunos, precio_comidas, precio_meriendas, precio_cenas, precio_copas};
			
			for(int i=0; i<precios_totales.length;i++) {
				if(precio_maximo < precios_totales[i]) {
					
					precio_maximo = precios_totales[i];
					
					indice_salida_max = i;
				}				
			}
			
			precio_minimo = precio_maximo;
			
			for(int i=0; i<precios_totales.length; i++) {
				if(precio_minimo > precios_totales[i]) {
					
					precio_minimo=precios_totales[i];
					
					indice_salida_min = i;
				}
			}
			
			for(int i=0; i<precios_totales.length; i++) {
				ingresos_totales+=precios_totales[i];
			}
			
			String[] salida_max = {"DESAYUNOS", "COMIDAS", "MERIENDAS", "CENAS", "COPAS"};
			String[] salida_min = {"DESAYUNOS", "COMIDAS", "MERIENDAS", "CENAS", "COPAS"};
	
			
// DETERMINA EMPATE DE MIN			
			for(int i=0; i<precios_totales.length; i++) {
				if(precio_minimo == precios_totales[i]) {
					empate_min++;
				}
			}
			
			if(empate_min>1) {
				
				salida_min[indice_salida_min] = "EMPATE";
			}
			
// DETERMINA EMPATE DE MAX			
			
			for(int i=0; i<precios_totales.length;i++) {
				if(precio_maximo == precios_totales[i]) {
					empate_max++;
				}
			}
			
			if(empate_max>1) {
				
				salida_max[indice_salida_max] = "EMPATE";
			}
			
// DETERMINA MEDIA			
			media_total = ingresos_totales/5;
			media_comidas = precio_comidas/ventas_comidas;
			
			if(media_comidas > media_total) {
				supera_media = "SI";
			}else {
				supera_media = "NO";
			}

// SALIDA 			
			System.out.println(salida_max[indice_salida_max] + "#" + salida_min[indice_salida_min] + "#" + supera_media);
			
						
			break;
			
		default:
			
			System.out.println("INGRESA UN CÓDIGO VÁLIDO\n\n (VERIFICA CAPSLOCK)\n\n");
		}	
		
		} while (!codigo_ingresado.equals("N"));
		
		entrada.close();

	} 

}
