package com.guilherme.domain.enums;



public enum TaskStatus {
	OPEN((long) 1), CLOSED((long) 2);

	private Long cod;

	private TaskStatus(Long cod) {
		this.cod = cod;
	}

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}
	
	public static TaskStatus toEnum(Long cod) {
		if(cod == null) {
			return null;
		}
		
		for(TaskStatus status : TaskStatus.values()) {
			if(cod.equals(status.getCod())) {
				return status;
			}
		}
		throw new IllegalArgumentException("cod is not valid");
	}

}
