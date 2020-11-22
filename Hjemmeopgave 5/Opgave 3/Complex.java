import java.text.DecimalFormat;

public class Complex 
{
	private double real;
	private double imaginary;
	
	private static DecimalFormat formatter = new DecimalFormat("0.#");
	
	public Complex()
	{
		real = 0;
		imaginary = 0;
	}
	
	public Complex(double real, double imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public Complex(Complex other)
	{
		this.real = other.real;
		this.imaginary = other.imaginary;
	}
	
	public double getImaginary()
	{
		return imaginary;
	}
	
	public double getReal()
	{
		return real;
	}
	
	public double abs()
	{
		return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
	}
	
	public Complex plus(Complex other)
	{
		return new Complex(this.real + other.real, this.imaginary + other.imaginary);
	}
	
	public Complex times(Complex other)
	{
		return new Complex(this.real * other.real - this.imaginary * other.imaginary, this.imaginary * other.real + this.real * other.imaginary);
	}
	
	public String toString()
	{
		if(imaginary == 0)
			return formatDouble(real);
		else if(imaginary > 0)
			return formatDouble(real) + " + " + formatDouble(imaginary) + "i";
		else // Imaginary < 0
			return formatDouble(real) + " - " + formatDouble(-1 * imaginary) + "i";
	}
	
	private String formatDouble(double number)
	{
		return formatter.format(number);
	}
}
