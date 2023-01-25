package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import static br.com.erudio.converters.NumberConverter.*;

@RestController
public class MathController {

	private SimpleMath math = new SimpleMath();
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor insira um valor numérico");
		}
		return math.sum(covertToDouble(numberOne), covertToDouble(numberTwo));
	}

	@RequestMapping(value = "/times/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double times(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor insira um valor numérico");
		}
		return math.times(covertToDouble(numberOne), covertToDouble(numberTwo));

	}

	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws  Exception{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw  new UnsuportedMathOperationException("Por favor insira um valor numérico");
		}
		return math.div(covertToDouble(numberOne), covertToDouble(numberTwo));
	}

	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws  Exception{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsuportedMathOperationException("Por favor insira um valor numérico");
		}
		return math.sub(covertToDouble(numberOne), covertToDouble(numberTwo));
	}

	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsuportedMathOperationException("por favor insira um valor numérico");
		}
		return math.media(covertToDouble(numberOne), covertToDouble(numberTwo));
	}

	@RequestMapping(value = "/raiz/{number}", method = RequestMethod.GET)
	public Double raiz(
			@PathVariable(value = "number") String number) throws  Exception{
		if(!isNumeric(number)){
			throw new UnsuportedMathOperationException("por favor insira um valor numérico");
		}
	return math.raiz(covertToDouble(number));
	}



}
