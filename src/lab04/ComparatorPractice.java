package lab04;

import java.util.Comparator;
import java.util.List;

import lab04.database.Database;
import lab04.database.Student;
import lab04.database.Tester;

/**
 * Comparator Practice for Lab 06, CS2420 - Spring 2017 
 * @author ryans
 */
public class ComparatorPractice {
	
	public static void main(String[] args) {
		Database database = new Database();
		Tester tester = new Tester();
		
		/*
		 * This is an example of using a named Comparator Class. 
		 * Check it out at the bottom of this file!
		 */
		tester.sortByName(new NameComparator());
		/** OR */
		/*
		 * This is an example of using a comparator as an "Anonymous Class"
		 */
		tester.sortByName(new Comparator<Student>() {
			@Override
			public int compare(Student leftHandSide, Student rightHandSide) {
				return leftHandSide.name.compareTo(rightHandSide.name);
			}
		});
		/** OR */
		/*
		 * This is an example of using Java 8's Lambda notation.
		 */
		tester.sortByName((leftHandSide, rightHandSide) -> leftHandSide.name.compareTo(rightHandSide.name));
		
		/*
		 * The rest are up to you! How many can you get?
		 * You can test your comparator against the "Database" like so...
		 */
		
		List<Student> studentsOrderedByName = database.getStudentsOrderedBy(new NameComparator()); // or any other Comparator synatx.
		printStudentList(studentsOrderedByName);
		
		/* 
		 * Sort the students by their Major alphabetically, 
		 * 	then by their gpas in reverse order (high to low), 
		 * 		and list all the girls before the boys.
		 */
		tester.sortByMajor_ReverseGPA_GirlsFirst(null);
		
		/*
		 * Sort the students by the number of cast they have, 
		 *   then number of dogs,
		 *      finally by reverse order of their LAST name.
		 *      (All names have the format: First Last)
		 */
		tester.sortBy_numCats_numDogs_ReverseLastName(new CatsDogsRvLastNameComparator());
		
		/*
		 * Sort the students by the length of their name (shorter first)
		 *    then by their uid in lexigraphical order.
		 */
		tester.sortByNameLength_UID(null);
		
		/*
		 * Sort by UID in lexigraphical order
		 *    sort by GPA (high to low)
		 *       sort by age (Younger to older)
		 */
		tester.sortByUid_ReverseGPA__age(null);
		
		/*
		 * Sort by names that have the fewest number of vowels (aeiou) first
		 *    then by who has more dogs
		 *       then by GPA (high to low)
		 *       
		 *       These are the best students.
		 */
		tester.sortBySmallestNumberOfVowels_Dogs_GPA(null);
		
		tester.runTest();
	}
	
	/**
	 * You can use this method to print out the list returned from the database.
	 * Only use it for debugging purposes.
	 * @param students
	 */
	private static void printStudentList(List<Student> students) {
		students.forEach(System.out::println); // <-- this is some funky Java 8 syntax! 
	}
	
	/**
	 * This is an example of how you can define a class to be a comparator.
	 * Usually this is done if the comparator has dependencies on other data, and needs 
	 * work done inside its constructor.
	 * @author ryans
	 */
	private static class NameComparator implements Comparator<Student> {
		@Override
		public int compare(Student leftHandSide, Student rightHandSide) {
			return leftHandSide.name.compareTo(rightHandSide.name);
		}
		
	}
	
	private static class CatsDogsRvLastNameComparator implements Comparator<Student> {
		/*
		 * Sort the students by the number of cast they have, 
		 *   then number of dogs,
		 *      finally by reverse order of their LAST name.
		 *      (All names have the format: First Last)
		 *      returns -value is L<R, 0 if L=R, and and a +valye if L>R.
		 */
		@Override
		public int compare(Student left, Student right) {
			// check cats
			int results= left.numCats - right.numCats;
			if(results ==0){
				// compare dogs
				results = left.numDogs - right.numDogs;
				if(results==0){
					//compare by reverse last name
					String rightLast = lastName(right.name);
					String leftLast = lastName(left.name);
					
					results = rightLast.compareTo(leftLast);
				}
			}
			
			return results;
		}
		/**
		 * returns the last name of the given students name
		 * @param name
		 * @return
		 */
		private String lastName(String name) {

			String [] names = name.split(" ");
			return names[names.length-1];
		}
		
	}

}
