/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Laboratorio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author Julio
 */
public class Clima {
 	public static String getHTML(String urlToRead) throws Exception {
		StringBuilder result = new StringBuilder();
		URL url = new URL(urlToRead);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
		   result.append(line);
		}
		rd.close();
		return result.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
                    
                    System.out.println("INGRESE LA CIUDAD: ");
                    Scanner jc = new Scanner(System.in);
                    String Ciudad = jc.next();
			String respuesta = getHTML("http://api.openweathermap.org/data/2.5/weather?q="+Ciudad+",uk&appid=a9f72b5fddd17a25f2b8cfb274b04486");
			//System.out.println(respuesta);
			JSONObject obj = new JSONObject(respuesta);
			double temp = obj.getJSONObject("main").getDouble("temp") - 273.15;
                        double Latitud = obj.getJSONObject("coord").getDouble("lat");
                        double Longitud = obj.getJSONObject("coord").getDouble("lon");
                        double Presion = obj.getJSONObject("main").getDouble("pressure");
                        double Humedad = obj.getJSONObject("main").getDouble("humidity");
                        double Speed = obj.getJSONObject("wind").getDouble("speed");
                        double Puestasol = obj.getJSONObject("sys").getDouble("sunset");
                        double Amanecer = obj.getJSONObject("sys").getDouble("sunrise");
                        double TemperaturaMax = obj.getJSONObject("main").getDouble("temp_max");
                
			System.out.println("La Temperatura en "+Ciudad+" es: "+temp+" Celsius");
                        System.out.println("La Latitud de " +Ciudad+" es: "+Latitud);
                        System.out.println("La Longitud de " +Ciudad+" es: "+Longitud);
                        System.out.println("La Presion de "+Ciudad+" es: "+Presion);
                        System.out.println("La Humedad de "+Ciudad+" es: "+Humedad);
                        System.out.println("La Velocidad Del Aire de "+Ciudad+" es: "+Speed);
                        System.out.println("La Puesta Del Sol en "+Ciudad+" es: "+Puestasol);
                        System.out.println("El Amanecer en "+Ciudad+" es: "+ Amanecer);
                        System.out.println("La Temperatura Maxima en "+Ciudad+" es: "+TemperaturaMax);
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}  