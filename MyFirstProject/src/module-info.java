/**
 * 
 */
/**
 * @author danielbeck
 *
 */
module MyFirstProject {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	
	opens GUI to javafx.base, javafx.controls, javafx.graphics, java.desktop;
	opens Logic to javafx.base, javafx.controls, javafx.graphics, java.desktop;
}