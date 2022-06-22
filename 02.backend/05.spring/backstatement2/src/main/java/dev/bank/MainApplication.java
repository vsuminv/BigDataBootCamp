package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementPaser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

// Ŭ���̾�Ʈ�� ���� ���� ȭ��
public class MainApplication {
	
	public static void main(String[] args) throws IOException {
		
		//before spring
//		BankStatementFactory factory = new BankStatementFactory();
//		BankStatementAnalyzer analyzer = factory.bankStatementAnalyzer();
		
		//after spring
		//spring IoC �����̳��� applicationContext ��ü ����,
		//Bean ���� ������ ������ ����ϰ� �ִ� BankStatementFactory�� ���
		//���⼭ new�� ���� spring ������ ������ 
		
		// IoC �����̳� ����
		final ApplicationContext applicationContext
		= new AnnotationConfigApplicationContext(BankStatementFactory.class); //���� ���� �� �ƴ�

		
		//IoC ���Ϳ��ʿ��� Analyzer �ν��Ͻ�(Bean) ��������
		final BankStatementAnalyzer analyzer =applicationContext.getBean(BankStatementAnalyzer.class);
		BankStatementCSVParser bean = applicationContext.getBean(BankStatementCSVParser.class);
		
		// �м� ����
		analyzer.analyze("bank-data-simple.csv");
		
	}
	

}