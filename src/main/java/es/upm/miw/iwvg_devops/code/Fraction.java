package es.upm.miw.iwvg_devops.code;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    public boolean isProper() {
        return this.getNumerator() < this.getDenominator();
    }

    public boolean isImproper() {
        return !this.isProper();
    }

    public boolean isEquivalent(Fraction fraction) {
        return this.decimal() == fraction.decimal();
    }

    public Fraction add(Fraction fraction) {
        int numerator = this.getNumerator() * fraction.getDenominator() +
                fraction.getNumerator() * this.getDenominator();
        return new Fraction(numerator, this.getDenominator() * fraction.getDenominator());
    }

    public Fraction multiply(Fraction fraction) {
        return new Fraction(this.getNumerator() * fraction.getNumerator(),
                this.getDenominator() * fraction.getDenominator());
    }

    public Fraction higher(Fraction fraction){
        if(this.decimal()<fraction.decimal())
            return fraction;
        else
            return this;
    }

    public Fraction divide(Fraction fraction) {
        return new Fraction(this.getNumerator() * fraction.getDenominator(),
                this.getDenominator() * fraction.getNumerator());
    }


}
