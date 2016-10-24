package br.com.hyperclass.onauction.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoje.format(formatador));
		Date dd = new Date(1476669600000L);
		
	}

}
