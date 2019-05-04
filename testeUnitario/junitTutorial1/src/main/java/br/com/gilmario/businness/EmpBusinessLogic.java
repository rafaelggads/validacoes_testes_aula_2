package br.com.gilmario.businness;

import br.com.gilmario.model.EmployeeDetails;

/**
 * Created by gilmario on 16/02/17.
 */
public class EmpBusinessLogic {
    //calculate the yearly salary of employee
    public double calculateYearlySalary(EmployeeDetails employeeDetails){
        double yearSalary = 0;
        yearSalary = employeeDetails.getMonthlySalary() * 12;
        return yearSalary;
    }

    //Calculate the appraisal amount of employee
    public double calculateAppraisal(EmployeeDetails employeeDetails){
        double appraisal = 0;
        if(employeeDetails.getMonthlySalary() < 10000){
            appraisal = 500;
        }else{
            appraisal = 1000;
        }
        return appraisal;
    }

}
