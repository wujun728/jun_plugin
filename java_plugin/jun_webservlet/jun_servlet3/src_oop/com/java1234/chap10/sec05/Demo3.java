package com.java1234.chap10.sec05;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class Demo3 {

	public static void main(String[] args) throws Exception {
		File file=new File("C://�����ļ�.txt");
		Writer out=new FileWriter(file);
		out.write("�����л�");
		out.close();
	}
}