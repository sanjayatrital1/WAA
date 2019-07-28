/**
 * 
 */
package com.students.domain;

import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author B.Pirasanth
 *
 */
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Range(min = 100, max = 999, message = "{Phone.areaCode.Validation}")
 	private Integer area;
	@NotNull
	@Min(value = 100,message = "{Phone.Prefix.Validation}")
	@Max(value = 999,message = "{Phone.Prefix.Validation}")
 	private Integer prefix;
	@NotNull
	@Min(value = 1000,message = "{Phone.Number.Validation}")
	@Max(value = 9999,message = "{Phone.Number.Validation}")
 	private Integer number;
	

 
	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

 	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}
}
