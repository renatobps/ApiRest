package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import br.com.erudio.exceptions.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor insira um valor numérico");
		}
		return covertToDouble(numberOne) + covertToDouble(numberTwo);
	}

	private Double covertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number  = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");

	}

}
