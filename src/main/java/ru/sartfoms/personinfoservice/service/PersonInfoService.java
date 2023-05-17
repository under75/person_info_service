package ru.sartfoms.personinfoservice.service;

import java.time.format.DateTimeFormatter;

public abstract class PersonInfoService {
	protected final static Integer SOAP_ERR = 1;
	protected final static Integer LOGIC_ERR = 2;
	protected final static String INTERNAL_SERVICE_ERROR = "500";
	protected final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public enum POLICY_TYPE {
		С, В, Е, П, Э, К, Ц, Х, М
	}

	protected abstract void process();
}
