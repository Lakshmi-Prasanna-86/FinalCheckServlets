package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.MovieDao;
import com.cognizant.movie.dao.MovieDaoCollectionImpl;
import com.cognizant.movie.model.Movie;

/**
 * Servlet implementation class ShowMenuItemListAdminServlet
 */
@WebServlet("/ShowMovieListAdminServlet")
public class ShowMovieListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieDaoCollectionImpl movieDaoCollectionImpl;

	public void init() {

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMovieListAdminServlet() {
		super();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		MovieDao movieDao = movieDaoCollectionImpl;
		List<Movie> movieList = movieDao.getMovieListAdmin();
		request.setAttribute("adminMovieList", movieList);
		request.getRequestDispatcher("movie-list-admin.jsp").forward(request,
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
