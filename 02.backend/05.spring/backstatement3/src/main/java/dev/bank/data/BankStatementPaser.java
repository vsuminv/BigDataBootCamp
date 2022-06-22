package dev.bank.data;

import java.util.List;

import dev.bank.domain.BankTransaction;

//parse ¼³°èµµ
public interface BankStatementPaser {
	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);

}
