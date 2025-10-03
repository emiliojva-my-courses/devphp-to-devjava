package main.java.zothers.exercises;

/**
 * Exercise 1: Primitive Types in Java
 * <p>
 * - Integer Types: byte, short, int, long
 * - Approximate memory sizes:
 * - byte: 1 byte (8 bits)
 * - short: 2 bytes (16 bits)
 * - int: 4 bytes (32 bits)
 * - long: 8 bytes (64 bits)
 * <p>
 * - Floating-Point Types: float, double
 * - Approximate memory sizes:
 * - float: 4 bytes (32 bits)
 * - double: 8 bytes (64 bits)
 * - Note: Use float for single-precision and double for double-precision.
 * <p>
 * - Character Type: char
 * - Approximate memory size: 2 bytes (16 bits)
 * - Note: Represents a single 16-bit Unicode character.
 * <p>
 * - Boolean Type: boolean
 * - Approximate memory size: not precisely defined (typically 1 bit)
 * <p>
 * - Note: Java does not have a primitive type for strings; instead, it uses the String class.
 */
public class PrimitiveTypes {

    public static void main(String[] args) {

        // write message to the console
        System.out.println("===============");
        System.out.println("Primitive Types");
        System.out.println("===============");
        System.out.println();

        // Integer Types
        int ageMateus = 5;
        int ageBernardo = 3;

        // Ages of the children | age of my sons.
        System.out.println("Age of the Mateus: " + ageMateus); // concatenation string + int
        System.out.println("Age of the Bernardo: " + ageBernardo);

        // Decimal Types | Floating-Point Types
        double weightMateus = 16.5;
        double weightBernardo = 13.5;
        double weightTotal = weightMateus + weightBernardo;

        // character Type
        char genderMateus = 'M';
        char genderRose = 'F';
        System.out.println("Gender of the Mateus: " + genderMateus + " and Rose: " + genderRose);

        // Boolean Type
        boolean isMateusOlder = ageMateus > ageBernardo;
        System.out.println( (isMateusOlder ? "Mateus": " Bernardo") + " is the more older.");

        // String Type
        String versicle = "For God so loved the world that he gave his one and only Son, that whoever believes in him shall not perish but have eternal life.";
        System.out.println("John 3:16 - " + versicle);
        System.out.println("Length of the versicle: " + versicle.length() + " characters.");
    }

}
