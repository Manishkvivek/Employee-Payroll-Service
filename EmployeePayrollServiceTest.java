package Employee.Payroll;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class EmployeePayrollServiceTest {
	
	@Test
	
	public void given3EmployeesWhenWrittenToFileShouldMatchNumberOfEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmployees = { 
				new EmployeePayrollData(1, "Manish K Vivek", 9000.0),
				new EmployeePayrollData(2, "Sumit Kumar", 8700.0),
				new EmployeePayrollData(3, "Vikash Kumar", 9100.0) };
		EmployeePayrollService employeePayrollService; 
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
		employeePayrollService.printEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(3, employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO));
	}
	
	@Test
	
	public void givenEmpDataInFileShouldRead() {
		EmployeePayrollService empPayrollService = new EmployeePayrollService();
		empPayrollService.readEmployeePayrollDataFromFile(EmployeePayrollService.IOService.FILE_IO);
		long entries = empPayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}
}


