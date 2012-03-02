package model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "companies")
@XmlType(propOrder = { "company" })
public class Companies {
	private List<Company> company;

	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
	}
}
