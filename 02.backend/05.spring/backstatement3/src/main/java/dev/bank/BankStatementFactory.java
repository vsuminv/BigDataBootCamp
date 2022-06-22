package dev.bank;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementPaser;

public class BankStatementFactory {
	public BankStatementAnalyzer bankStatementAnalyzer() {
		
		final BankStatementPaser parser = new BankStatementCSVParser();
		
		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer(parser);
		return analyzer;
	}

}
