package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorContr
 */
public class CalculatorContr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;

	public static final int OP_SUMAR = 0;
	public static final int OP_RESTAR = 1;
	public static final int OP_MULTIPLICAR = 2;
	public static final int OP_DIVIDIR = 3;

	int operacion = OP_SUMAR;
	float num1 = 0f;
	float num2 = 0f;
	float resultado = 0f;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Nos llaman a traves de un enlace, peticion GET
		request.getRequestDispatcher("/views/calculadora/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			getParameters(request);

			calcular();

			// Enviar atributos a la vista (a la jsp)
			request.setAttribute("resultado", resultado);

			dispatch = request.getRequestDispatcher("views/calculadora/resultado.jsp");
		} catch (NumberFormatException e) {

			request.setAttribute("msg", "Por favor, escribe un número correcto");
			dispatch = request.getRequestDispatcher("views/calculadora/index.jsp");

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("msg", "Disculpe las molestias, tenemos un fallo sin controlar");
			dispatch = request.getRequestDispatcher("views/calculadora/index.jsp");

		} finally {

			dispatch.forward(request, response);

		}

	}

	private void calcular() {

		switch (operacion) {
		case OP_SUMAR:
			resultado = num1 + num2;
			break;
		case OP_RESTAR:
			resultado = num1 - num2;
			break;
		case OP_MULTIPLICAR:
			resultado = num1 * num2;
			break;
		case OP_DIVIDIR:
			resultado = num1 / num2;
			break;
		}

	}

	private void getParameters(HttpServletRequest request) {

		String snum1 = request.getParameter("num1");
		String snum2 = request.getParameter("num2");
		String sOperacion = request.getParameter("operacion");

		// TODO aplicar logica de negocio

		operacion = Integer.parseInt(sOperacion);
		num1 = Float.parseFloat(snum1);
		num2 = Float.parseFloat(snum2);
		resultado = 0f;

	}

}
