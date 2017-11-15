package com.demo.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import com.demo.model.Employee;

/**
 * @author Mehraj Malik
 *
 */
public class CSVHelper {
	

	private static final String CSV = "/backup/July_WS/Java8/src/csv/employee.csv";
	//private static final String CSV = "/home/user/Desktop/employee (copy).csv";
	public static void main(String[] args) throws IOException {

		// Create the CSVFormat object
		CSVFormat format = CSVFormat.RFC4180.withFirstRecordAsHeader().withDelimiter(',');

		// initialize the CSVParser object
		CSVParser parser = new CSVParser(new FileReader(CSV), format);
		List<Employee> emps = new ArrayList<Employee>();
		for (CSVRecord record : parser) {
			isValid(record.get("ID"));
			isValid(record.get("Name"));
			isValid(record.get("Role"));
			isValid(record.get("Salary"));
			/*Employee emp = new Employee();
			emp.setId(record.get("ID"));
			emp.setName(record.get("Name"));
			emp.setRole(record.get("Role"));
			emp.setSalary(record.get("Salary"));
			emps.add(emp);*/
		}
		// close the parser
		parser.close();

		System.out.println(emps);

		// CSV Write Example using CSVPrinter
		CSVPrinter printer = new CSVPrinter(System.out, format.withDelimiter(','));
		System.out.println("********");
		//printer.printRecord("ID", "Name", "Role", "Salary");
		for (Employee emp : emps) {
			List<String> empData = new ArrayList<String>();
			empData.add(emp.getId());
			empData.add(emp.getName());
			empData.add(emp.getRole());
			empData.add(emp.getSalary());
			printer.printRecord(empData);
		}
		// close the printer
		printer.close();
	}
	
	public static boolean isValid(String value) {
		if(!StringUtils.isBlank(value)) {
			return true;
		} else {
			throw new NullPointerException("Not well formed");
		}
	}

}
