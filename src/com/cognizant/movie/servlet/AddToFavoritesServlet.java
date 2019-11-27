package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.FavoritesDao;
import com.cognizant.movie.dao.FavoritesDaoCollectionImpl;
import com.cognizant.movie.dao.MovieDao;
import com.cognizant.movie.dao.MovieDaoCollectionImpl;
import com.cognizant.movie.model.Movie;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToFavoritesServlet")
public class AddToFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavoritesServlet() {
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
		long userId = 1;
		String movieid = request.getParameter("movieId");
		System.out.println(movieid);
		long movieId = Long.parseLong(movieid);
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;
		favoritesDao.addFavorites(userId, movieId);
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		MovieDao movieDao = movieDaoCollectionImpl;
		List<Movie> movieList = movieDao.getMovieListCustomer();
		request.setAttribute("addFavoritesStatus", true);
		request.setAttribute("customerMovieList", movieList);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(
				request, response);

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
