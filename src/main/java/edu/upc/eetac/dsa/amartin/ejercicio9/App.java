/*
 * Copyright 2014 Alejandro Martin Cruz
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.upc.eetac.dsa.amartin.ejercicio9;

class CuentaAtras implements Runnable {
    String id;
    int cuenta;
    
    public CuentaAtras (String id, int cuenta) {
    	this.id = id;
    	this.cuenta = cuenta;
    }
    
    public void run()  {
    	try {
	    	while (cuenta > 0) {
	    		Thread.sleep(1000);
	    		System.out.println("Thread " + id + " contando " + --cuenta);
	    	}
	    	System.out.println ("Cuenta terminada");
    	}
    	catch (Exception ex) {
    		System.out.println ("ERROR " + ex.getMessage());
    	}
    }
}

/**
 * Hello world!
 *
 */

public class App {
	
    public static void main (String [] args) throws Exception {
    	CuentaAtras contador1 = new CuentaAtras("ID1", 4);
    	CuentaAtras contador2 = new CuentaAtras("ID2", 7);
    	CuentaAtras contador3 = new CuentaAtras("ID3", 8);
    	Thread c1 = new Thread(contador1);
    	Thread c2 = new Thread(contador2);
    	Thread c3 = new Thread(contador3);
    	c1.start();
    	c2.start();
    	c3.start();
    	
    	while (c1.isAlive() || c2.isAlive() || c3.isAlive()) {
    		Thread.sleep (10);
    	}
    	System.out.println ("Ya han terminado todos los hilos");
    }
}