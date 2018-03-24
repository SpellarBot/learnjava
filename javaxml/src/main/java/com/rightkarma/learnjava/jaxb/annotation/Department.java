package com.rightkarma.learnjava.jaxb.annotation;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)

//@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlType(propOrder = {"name","description","employees"})
public class Department{

    @XmlAttribute(required = true)
    String name;

    @XmlAttribute
    String description;

    @XmlElementWrapper(name="employees")
    @XmlElement(name="employee")
    List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", employees=" + employees +
                '}';
    }

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}

/*


OUTPUT

<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<department name="Maths" description="Gradulate level Mathematics">
    <employees>
        <employee>
            <dob>1998-02-02+05:30</dob>
            <id>1</id>
            <name>John</name>
        </employee>
        <employee>
            <dob>1977-12-21+05:30</dob>
            <id>1</id>
            <name>David</name>
        </employee>
    </employees>
</department>

*/

