package com.guilherme.rest.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidacaoErro extends StandardError{
	
	public List<MessagemErro> fields = new ArrayList<>();
	
	public ValidacaoErro(String msg, Integer status) {
		super(msg, status);
		
	}

	public List<MessagemErro> getFields() {
		return fields;
	}

	public void setFields(List<MessagemErro> fields) {
		this.fields = fields;
	}

	public void addError(MessagemErro mensagemErro) {
		// TODO Auto-generated method stub
		
	}
	

}
