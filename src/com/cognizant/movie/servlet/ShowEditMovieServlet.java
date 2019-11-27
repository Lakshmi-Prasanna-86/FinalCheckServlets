package com.cognizant.movie.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.MovieDao;
import com.cognizant.movie.dao.MovieDaoCollectionImpl;
import com.cognizant.movie.model.Movie;

/**
 * Servlet implementation class ShowEditMenuItemServlet
 */
@WebServlet("/ShowEditMovieServlet")
public class ShowEditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ShowEditMovieServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		MovieDao movieDao = movieDaoCollectionImpl;
		String movieid = request.getParameter("movieId");
		long movieId = Long.parseLong(movieid);
		Movie movie = movieDao.getMovie(movieId);
		System.out.println("Menu Item=" + movie);

		// List<MenuItem> menuItemList=menuItemDao.getMenuItemListCustomer();
		request.setAttribute("movie", movie);
		request.getRequestDispatcher("edit-movie.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
