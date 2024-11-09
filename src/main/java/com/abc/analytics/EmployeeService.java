package com.abc.analytics;

import com.abc.Employee;
import com.abc.EmployeeDao;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

public class EmployeeService {

    public EmployeeDao getEmployeeRepository() {
        return employeeRepository;
    }

    private EmployeeDao employeeRepository;

    public TransactionTemplate getDefaultTransactionTemplate() {
        return defaultTransactionTemplate;
    }

    private TransactionTemplate defaultTransactionTemplate; // Default transaction template

    /**
     * Main method to evaluate and trigger the batch insert process.
     */
    public void evaluate(List<Employee> employees, int batchSize) {
        initialize();
        preprocess();
        process(employees, batchSize);
    }

    /**
     * Method to initialize, executed under a read-only transaction.
     */
    public void initialize() {
        // Create a read-only transaction definition
        TransactionDefinition readOnlyTransaction = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
        ((DefaultTransactionDefinition) readOnlyTransaction).setReadOnly(true);

        // Create a TransactionTemplate with the read-only transaction definition
        TransactionTemplate readOnlyTransactionTemplate = new TransactionTemplate(defaultTransactionTemplate.getTransactionManager(), readOnlyTransaction);

        readOnlyTransactionTemplate.execute(status -> {
            // Read-only initialization logic
            System.out.println("Initialization under read-only transaction.");
            return null;
        });
    }

    /**
     * Method to preprocess data, executed under a read-only transaction.
     */
    public void preprocess() {
        // Create a read-only transaction definition
        TransactionDefinition readOnlyTransaction = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
        ((DefaultTransactionDefinition) readOnlyTransaction).setReadOnly(true);

        // Create a TransactionTemplate with the read-only transaction definition
        TransactionTemplate readOnlyTransactionTemplate = new TransactionTemplate(defaultTransactionTemplate.getTransactionManager(), readOnlyTransaction);

        readOnlyTransactionTemplate.execute(status -> {
            // Read-only preprocessing logic
            System.out.println("Preprocessing under read-only transaction.");
            return null;
        });
    }

    /**
     * Method to process the actual insertion of employees in batches, requires a write transaction.
     */
    public void process(List<Employee> employees, int batchSize) {
        // Create a non-read-only transaction definition (default behavior)
        TransactionDefinition writeTransaction = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);

        // Create a TransactionTemplate with the write transaction definition
        TransactionTemplate writeTransactionTemplate = new TransactionTemplate(defaultTransactionTemplate.getTransactionManager(), writeTransaction);

        writeTransactionTemplate.execute(status -> {
            employeeRepository.saveEmployeesInBatches(employees, batchSize);
            return null;
        });

        System.out.println("Batch insert process completed under non-read-only transaction.");
    }

    public List<Employee> getEmployees(){
        TransactionDefinition readOnlyTransaction = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
        ((DefaultTransactionDefinition) readOnlyTransaction).setReadOnly(true);

        // Create a TransactionTemplate with the read-only transaction definition
        TransactionTemplate readOnlyTransactionTemplate = new TransactionTemplate(defaultTransactionTemplate.getTransactionManager(), readOnlyTransaction);
       return readOnlyTransactionTemplate.execute(status -> {
            // Read-only preprocessing logic
            System.out.println("Preprocessing under read-only transaction.");
            return (List<Employee>) employeeRepository.queryEmployee();
        });
    }

    public void setEmployeeRepository(EmployeeDao employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void setDefaultTransactionTemplate(TransactionTemplate defaultTransactionTemplate) {
        this.defaultTransactionTemplate = defaultTransactionTemplate;
    }
}
