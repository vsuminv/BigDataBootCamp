package com.todo.data;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import com.todo.model.Todo;

public class TodoTSVWriter {
	
		FileOutputStream fileOutputStream;
		OutputStreamWriter outputStreamWriter;
		BufferedWriter bufferedWriter;
		Long numberOfRows;
		
//	새로운 Todo를 등록
	public boolean save(String RESOURCES, Path filePath, Todo newTodo) {
		boolean result = false;
		
		
		try {
//			데이터를 파일에 쓰기 위한 준비
			fileOutputStream = new FileOutputStream(RESOURCES + "todo-data-simple.txt",true);
			outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
			bufferedWriter = new BufferedWriter(outputStreamWriter);
			
			numberOfRows = Files.lines(filePath).count();	
			int numberOfTodos = numberOfRows.intValue();
			
			numberOfTodos++;//할 일 순서 번호 1 증가
			bufferedWriter.newLine();
//			bufferedWriter.write(numberOfTodos + "\t" );
//			bufferedWriter.write("밥먹기" + "\t" );
//			bufferedWriter.write("2022-03-08" + "\t" );
//			bufferedWriter.write("밥을 맛있게 먹는다" + "\t" );
			
			bufferedWriter.write(numberOfTodos + "\t" );
			bufferedWriter.write(newTodo.getTitle() + "\t" );
			bufferedWriter.write(newTodo.getDueDate().toString() + "\t" );
			bufferedWriter.write(newTodo.getDescription() + "\t" );
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {	
			try {
//			자원 해제 --> 마지막 열린 거부터 닫아야함
				
				bufferedWriter.close();
				outputStreamWriter.close();
				fileOutputStream.close();
				
				if(numberOfRows < Files.lines(filePath).count()) {
					return true;
				}else {
					return false;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
}
