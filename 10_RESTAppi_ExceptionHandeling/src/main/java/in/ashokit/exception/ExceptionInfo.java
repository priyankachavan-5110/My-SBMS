package in.ashokit.exception;

import java.time.LocalDate;
//this is user define class just to set/get some data
public class ExceptionInfo {
	
private String expCode;
private String expDesc;
private LocalDate expDate;

//to initialize this variable create constructor
public ExceptionInfo(String expCode, String expDesc, LocalDate expDate) {
	super();
	this.expCode = expCode;
	this.expDesc = expDesc;
	this.expDate = expDate;	
}

public String getExpCode() {
	return expCode;
}

public void setExpCode(String expCode) {
	this.expCode = expCode;
}

public String getExpDesc() {
	return expDesc;
}

public void setExpDesc(String expDesc) {
	this.expDesc = expDesc;
}

public LocalDate getExpDate() {
	return expDate;
}

public void setExpDate(LocalDate expDate) {
	this.expDate = expDate;
}

}
