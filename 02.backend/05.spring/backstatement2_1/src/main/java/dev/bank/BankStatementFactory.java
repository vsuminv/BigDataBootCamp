package dev.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementPaser;

@Configuration
@ComponentScan //각각의 클래스들을 컴포넌트라고 부름. 클래스를 찾는 역할. 
// scan 범위 : IoC Container(BankStatementFactory.java)가 위치한 패키지(dev.bank)를 root 패키지 취급하기 때문에 거기에 위치한 하위 패키지들만 스캔
public class BankStatementFactory { //root 디렉토리

	
}
