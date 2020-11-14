package com.testePratico.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;

	public Error() {

	}

	public Error(Integer status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}


}
