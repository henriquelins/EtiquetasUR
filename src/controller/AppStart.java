
package controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.TelaAplicativo;

public class AppStart {
	
	

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		new AppStart().iniciar();

	}

	public void iniciar() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		UIManager
				.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		TelaAplicativo frame = new TelaAplicativo();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}
}
