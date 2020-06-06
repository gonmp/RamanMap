package raman;

public class RegistroDato {
	private int x;
	private int y;
	private double RamanShift;
	private double Intensidad;
	
	public RegistroDato(){
		this(0, 0, 0.0, 0.0);		
	}
	
	public RegistroDato(int a, int b, double c, double d){
		establecerX(a);
		establecerY(b);
		establecerRamanShift(c);
		establecerIntensidad(d);
	}
	public void establecerX(int a){
		x = a;
	}
	public int obtenerX(){
		return x;
	}
	public void establecerY(int b){
		y = b;		
	}
	public int obtenerY(){
		return y;		
	}
	public void establecerRamanShift(double c){
		RamanShift = c;
	}
	public double obtenerRamanShift(){
		return RamanShift;
	}
	public void establecerIntensidad(double d){
		Intensidad = d;
	}
	public double obtenerIntesidad(){
		return Intensidad;
	}
}
