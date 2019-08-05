package mum.edu.domain.dto;

 	import com.oracle.webservices.internal.api.databinding.DatabindingMode;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	import java.util.ArrayList;
	import java.util.List;

	@Data
	@NoArgsConstructor
	public class DomainErrors {
	 
	    private String errorType;
	    private String message;

	    public List<DomainError> getErrors() {
			return errors;
		}

		public void setErrors(List<DomainError> errors) {
			this.errors = errors;
		}

		private List<DomainError> errors = new ArrayList<DomainError>();
	 
 	    public void addError(DomainError error) {
 	        errors.add(error);
	    }

		public void setErrorType(String errorType) {
			this.errorType = errorType;
		}

	 

	 
 	}
	
 
