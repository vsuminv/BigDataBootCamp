package dev.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementPaser;

@Configuration // Bean으로 지정한 것을 빈 객체로 만들어주는 spring 컨데이터. BankStatement가 빈 구성정보(IoC 컨테이너)로 활용할 수 있도록 설정 or 지정
public class BankStatementFactory {
	
//	@Bean //Bean 구성 정보 내부에 등록되어있는 하나의 Bean
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
	 * 스프링을 적용하기 위해서 순수한 Java code로 작성한 Factory Bean
	 * 
	 */
}
