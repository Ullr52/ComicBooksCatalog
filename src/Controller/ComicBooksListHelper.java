package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ComicBooksList;

/**
 * @author jword - jord CIS175 - Spring - 2022 Jan 28, 2022
 */
public class ComicBooksListHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ComicBooks");

	public void insertComic(ComicBooksList lc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lc);
		em.getTransaction().commit();
		em.close();
	}

	public List<ComicBooksList> showAllComics() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<ComicBooksList> allComics = em.createQuery("SELECT i FROM ComicBooksList i").getResultList();
		return allComics;

	}

	/**
	 * @param toDelete
	 */
	public void deleteAComic(ComicBooksList toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ComicBooksList> typedQuery = em.createQuery(
				"select lc from ComicBooksList lc where lc.issueNum  = :selectedIssueNum and lc.publisher = :selectedPublisher and lc.seriesTitle = :selectedSeriesTitle",
				ComicBooksList.class);

		typedQuery.setParameter("selectedIssueNum", toDelete.getIssueNum());
		typedQuery.setParameter("selectedPublisher", toDelete.getPublisher());
		typedQuery.setParameter("selectedSeriesTitle", toDelete.getSeriesTitle());
		// typedQuery.setParameter("selectedAuthor", toDelete.getAuthor());
		// typedQuery.setParameter("selectedIllustrator", toDelete.getIllustrator());

		typedQuery.setMaxResults(1);

		ComicBooksList result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * @param issueNum
	 * @return
	 */
	public List<ComicBooksList> searchForComicByIssueNum(String issueNum) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ComicBooksList> typedQuery = em.createQuery(
				"select lc from ComicBooksList lc where lc.issueNum = :selectedIssueNum", ComicBooksList.class);

		typedQuery.setParameter("selectedIssueNum", issueNum);

		List<ComicBooksList> foundComics = typedQuery.getResultList();
		em.close();
		return foundComics;
	}

	/**
	 * @param publisher
	 * @return
	 */
	public List<ComicBooksList> searchForComicByPublisher(String publisher) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ComicBooksList> typedQuery = em.createQuery(
				"select lc from ComicBooksList lc where lc.publisher = :selectedPublisher", ComicBooksList.class);

		typedQuery.setParameter("selectedPublisher", publisher);

		List<ComicBooksList> foundComics = typedQuery.getResultList();
		em.close();
		return foundComics;
	}

	/**
	 * @param seriesTitle
	 * @return
	 */
	public List<ComicBooksList> searchForComicBySeriesTitle(String seriesTitle) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ComicBooksList> typedQuery = em.createQuery(
				"select lc from ComicBooksList lc where lc.seriesTitle = :selectedSeriesTitle", ComicBooksList.class);

		typedQuery.setParameter("selectedSeriesTitle", seriesTitle);

		List<ComicBooksList> foundComics = typedQuery.getResultList();
		em.close();
		return foundComics;
	}

	/**
	 * @param author
	 * @return
	 */
	public List<ComicBooksList> searchForComicByAuthor(String author) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ComicBooksList> typedQuery = em.createQuery(
				"select lc from ComicBooksList lc where lc.author = :selectedAuthor", ComicBooksList.class);

		typedQuery.setParameter("selectedAuthor", author);

		List<ComicBooksList> foundComics = typedQuery.getResultList();
		em.close();
		return foundComics;
	}

	/**
	 * @param seriesTitle
	 * @return
	 */
	public List<ComicBooksList> searchForComicByIllustrator(String illustrator) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ComicBooksList> typedQuery = em.createQuery(
				"select lc from ComicBooksList lc where lc.illustrator = :selectedIllustrator", ComicBooksList.class);

		typedQuery.setParameter("selectedIllustrator", illustrator);

		List<ComicBooksList> foundComics = typedQuery.getResultList();
		em.close();
		return foundComics;
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public ComicBooksList searchForComicById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		ComicBooksList found = em.find(ComicBooksList.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateComics(ComicBooksList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * 
	 */
	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();

	}

}
