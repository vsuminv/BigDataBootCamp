package dev.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementPaser;

@Configuration // Bean���� ������ ���� �� ��ü�� ������ִ� spring ��������. BankStatement�� �� ��������(IoC �����̳�)�� Ȱ���� �� �ֵ��� ���� or ����
public class BankStatementFactory {
	
//	@Bean //Bean ���� ���� ���ο� ��ϵǾ��ִ� �ϳ��� Bean
//	public BankStatementAnalyzer bankStatementAnalyzer() {
//		
//		final BankStatementPaser parser = new BankStatementCSVParser(); 
//		
//		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer(parser);
//		return analyzer;
//	}
	
	
	@Bean
	public BankStatementCSVParser bankStatementCSVParser() {
		return new BankStatementCSVParser();
	}
	
	@Bean
	public BankStatementAnalyzer bankStatementAnalyzer() {
		return new BankStatementAnalyzer(bankStatementCSVParser());
	}

	/*
	 * �������� �����ϱ� ���ؼ� ������ Java code�� �ۼ��� Factory Bean
	 * 
	 */
}