package dev.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementPaser;

@Configuration
@ComponentScan //������ Ŭ�������� ������Ʈ��� �θ�. Ŭ������ ã�� ����. 
// scan ���� : IoC Container(BankStatementFactory.java)�� ��ġ�� ��Ű��(dev.bank)�� root ��Ű�� ����ϱ� ������ �ű⿡ ��ġ�� ���� ��Ű���鸸 ��ĵ
public class BankStatementFactory { //root ���丮

	
}