package com.ifpvg.tema2;

import com.db4o.Db4oEmbedded;

public class Importa {
	final static String BDEmpleado="CUARENTENA.YAP";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmpleado);

	}

}
