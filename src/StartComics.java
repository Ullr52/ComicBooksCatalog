import java.util.List;
import java.util.Scanner;

import Controller.ComicBooksListHelper;
import model.ComicBooksList;

/**
 * @author jword - jord CIS175 - Spring - 2022 Jan 28, 2022
 */
public class StartComics {

	static Scanner in = new Scanner(System.in);
	static ComicBooksListHelper cblh = new ComicBooksListHelper();

	private static void addAComic() {
		System.out.print("Enter an Issue Number: ");
		String issueNum = in.nextLine();

		System.out.print("Enter a Publisher: ");
		String publisher = in.nextLine();

		System.out.print("Enter a Series Title: ");
		String seriesTitle = in.nextLine();

		System.out.print("Enter an Author: ");
		String author = in.nextLine();

		System.out.print("Enter an Illustrator: ");
		String illustrator = in.nextLine();
		ComicBooksList toAdd = new ComicBooksList(issueNum, publisher, seriesTitle, author, illustrator);
		cblh.insertComic(toAdd);

	}

	private static void deleteAComic() {
		// TODO Auto-generated method stub
		System.out.print("Enter an Issue Number: ");
		String issueNum = in.nextLine();
		System.out.print("Enter a Publisher: ");
		String publisher = in.nextLine();
		System.out.print("Enter a Series Title: ");
		String seriesTitle = in.nextLine();
		ComicBooksList toDelete = new ComicBooksList(issueNum, publisher, seriesTitle);
		cblh.deleteAComic(toDelete);

	}

	private static void editAComic() {
		// TODO Auto-generated method stub
		System.out.println("Please select an option to search by: ");
		System.out.println("1: Search by Issue Number");
		System.out.println("2: Search by Publisher");
		System.out.println("3: Search by Series Title");
		System.out.println("4: Search by Author");
		System.out.println("5: Search by Illustrator");
		System.out.print("*  Your selection: ");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ComicBooksList> foundComics;

		if (searchBy == 1) {
			System.out.print("Enter the issue number: ");
			String issueNum = in.nextLine();
			foundComics = cblh.searchForComicByIssueNum(issueNum);

		} else if (searchBy == 2) {
			System.out.print("Enter the publisher: ");
			String publisher = in.nextLine();
			foundComics = cblh.searchForComicByPublisher(publisher);

		} else if (searchBy == 3) {
			System.out.print("Enter the series title: ");
			String seriesTitle = in.nextLine();
			foundComics = cblh.searchForComicBySeriesTitle(seriesTitle);

		} else if (searchBy == 4) {
			System.out.print("Enter the author: ");
			String seriesAuthor = in.nextLine();
			foundComics = cblh.searchForComicByAuthor(seriesAuthor);
		} else {
			System.out.print("Enter the illustrator: ");
			String seriesIllustrator = in.nextLine();
			foundComics = cblh.searchForComicByIllustrator(seriesIllustrator);

		}

		if (!foundComics.isEmpty()) {
			System.out.println("Comics Found.");
			for (ComicBooksList l : foundComics) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.println("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ComicBooksList toEdit = cblh.searchForComicById(idToEdit);
			System.out.println("Retrieved " + toEdit.getSeriesTitle() + toEdit.getIssueNum() + " , Published By "
					+ toEdit.getPublisher() + " , Written by: " + toEdit.getAuthor() + ", and Illustrated by: "
					+ toEdit.getIllustrator());
			System.out.println("1: Update Series Title");
			System.out.println("2: Update Issue Number");
			System.out.println("3: Update Publisher");
			System.out.println("4: Update Author");
			System.out.println("5: Update Illustrator");
			System.out.print("Your selection: ");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Series Title: ");
				String newSeriesTitle = in.nextLine();
				toEdit.setSeriesTitle(newSeriesTitle);
			} else if (update == 2) {
				System.out.print("New Issue Number: ");
				String newIssueNum = in.nextLine();
				toEdit.setIssueNum(newIssueNum);
			} else if (update == 3) {
				System.out.print("Publisher: ");
				String newPublisher = in.nextLine();
				toEdit.setPublisher(newPublisher);
			} else if (update == 4) {
				System.out.print("New Author: ");
				String newAuthor = in.nextLine();
				toEdit.setAuthor(newAuthor);
			} else if (update == 5) {
				System.out.print("New Illustrator: ");
				String newIllustrator = in.nextLine();
				toEdit.setIllustrator(newIllustrator);

			}
			cblh.updateComics(toEdit);
		} else {
			System.out.println("No Comics Found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("Thank you for using Comics Catalog!");
		while (goAgain) {
			System.out.println("*  Select an option:");
			System.out.println("*  1 -- Add a new Comic");
			System.out.println("*  2 -- Edit an Comic");
			System.out.println("*  3 -- Delete an Comic");
			System.out.println("*  4 -- View the comic list");
			System.out.println("*  5 -- Exit the comic catalog");
			System.out.print("*  Please make a selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAComic();
			} else if (selection == 2) {
				editAComic();
			} else if (selection == 3) {
				deleteAComic();
			} else if (selection == 4) {
				viewComicsList();
			} else {
				cblh.cleanUp();
				System.out.println("Thank you for using Comics Catalog!");
				goAgain = false;
			}
		}
	}

	private static void viewComicsList() {
		List<ComicBooksList> allItems = cblh.showAllComics();
		for (ComicBooksList singleItem : allItems) {
			System.out.println(singleItem.returnComicDetails());
		}

	}
}
