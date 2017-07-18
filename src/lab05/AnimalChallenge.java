package lab05;

import java.util.Comparator;

import lab05.zoo.Zoo.Animal;
import lab05.zoo.Zoo.Pet;
import lab05.zoo.ZooKeeper;

/**
 * I agree not to talk about this lab until Tuesday, Feb 14 2017
 * 
 * @author Chloe Josien
 * 
 *         Please ask if any of the directions are unclear, we want you all to
 *         succeed. This file as a main method you can run at any time to check
 *         your progress on Task 1. Tasks 2 - 4 will require your own testing.
 * 
 *         PLEASE test Task 1 before moving on. So many points possible!
 */
public class AnimalChallenge {

	/**
	 * @name: insertInto This method visible to everyone, and is static.
	 * 
	 *        Inserts an element into a collection in the proper, sorted
	 *        position. The collection is sorted in ascending order, meaning low
	 *        to high. The collection parameter is already sorted with null
	 *        values padding the end. There is space available for the inserted
	 *        element.
	 * 
	 *        Once you get the method header written you should run your program
	 *        to ensure it is defined properly. (We have written this
	 *        functionality for you, just trust me and run it).
	 * 
	 *        You can think of the collection parameter looking like this:
	 *        [element0, element1, element2, ... , elementN, null, null, ...
	 *        ,null ]
	 * 
	 * @param collection
	 *            - the generic basic array to insert into. GUARENTEED to
	 *            already be in sorted order, and have enough space for the new
	 *            element (nulls pad the end).
	 * @param element
	 *            - The generic item to insert into collection.
	 * @param comparator
	 *            - Used for sorting. Don't forget to parameterize it!
	 * @return
	 * 
	 * @return -- NOTHING! The return type is void, this should MODIFY the
	 *         passed in collection.
	 */
	// **** TASK 1,2 ****
	// TODO: Implement the method described by the JavaDoc above
	public static <Type> void insertInto(Type[] collection, Type element, Comparator<? super Type> comparator) {

			int pos = collection.length;
			while(pos>0 && collection[pos-1]==null){
				pos--;
			}
			while(pos>0 && comparator.compare(collection[pos-1], element)>0){
				collection[pos] = collection[pos-1];
				pos--;
			}
			
			collection[pos]=element;
	}

	/**
	 * Class name : AnimalComparator
	 * 
	 * This is a public static class that is used to compare two Animal for
	 * sorting.
	 * 
	 * Animals are sorted by their taxonomic classification in lexicographical
	 * order. This means animals are first sorted by their genus, then their
	 * species, in ascending order.
	 */
	// **** TASK 1,3
	// TODO: Implement the class described by the above JavaDoc
	public static class AnimalComparator implements Comparator<Animal> {
		// compares the strings and returns either -1,0,1
		@Override
		public int compare(Animal first, Animal second) {
			int results = first.genus.compareTo(second.genus);
			if (results == 0) {
				results = first.species.compareTo(second.species);
			}

			return results;
		}
	}

	// **** TASK 4
	// Create new comparators for each method, and return them!
	/**
	 * Pet extends Animal. The Pet comparator sorts by cuteness first and
	 * foremost, and then falls back to the default Animal sort to break ties.
	 */
	public static Comparator<Pet> getNewPetComparator() {
		return new Comparator<Pet>() {
			@Override
			public int compare(Pet first, Pet second) {
				int results = first.cuteness - second.cuteness;
				if(results ==0){
					 AnimalComparator comparator = new AnimalComparator();
					results = comparator.compare(first, second);
				}
				return results;
			}
		};
	}

	/**
	 * Sort animals by how hungry they are (most hungry first!), and if they
	 * have the same hunger level, pick who ever has more teeth!
	 */
	public static Comparator<Animal> getNewHungerTeethComparator() {
		return new Comparator<Animal>() {
			@Override
			public int compare(Animal first, Animal second) {
				int results = first.hungerLevel - second.hungerLevel;
				if(results ==0){
					results = first.numOfTeeth - second.numOfTeeth;
				}
				return results;
			}
		};
	}

	/**
	 * Sort animals by putting predators first. Order animals by their teeth to
	 * height ratio (teeth / height) in descending order.
	 * 
	 * @return
	 */
	public static Comparator<Animal> getNewPredators_TeethByHeight() {
		return new Comparator<Animal>() {
			@Override
			public int compare(Animal first, Animal second){
				int result =0;
				if(first.isPredator&& second.isPredator){
					result =0;
				}else if(first.isPredator){
					result=-1;
				}else if(second.isPredator){
					result =1;
				}
				if(result==0){
					double firstRatio= first.numOfTeeth/first.height;
					double secondRatio = second.numOfTeeth/second.height;
					result = Double.compare(secondRatio, firstRatio);
				}
				return result;
			}
		};
	}
	
	/**
     *  This class implements Comparator and uses it to compare integers
     */
    public static class integerCompare implements Comparator<Integer> {

        @Override
        public int compare(Integer value, Integer num) {
            return value.compareTo(num);
        }
    }

	/**
	 * Run this method to see if you have incorrect method and class signatures.
	 * It is possible to get false positives from this method. It might 'pass',
	 * but your signature will be still be incorrect.
	 * 
	 * This does not check if your methods are implemented correctly, it only
	 * evaluates if they are declared correctly.
	 */
	public static void main(String... args) {
		ZooKeeper.gutCheck(); // a helpful method to see if you're on the right
								// track.

		// Don't forget to test insertInto!
		Integer[] testArray = new Integer[] { 1, 2, 3, 4, null };
		testArray.toString();
		// You can use testArray when your AnimalComparator.insertInto() method!
		AnimalChallenge.insertInto(testArray, 5, new integerCompare());
		System.out.println(testArray[4].toString());

		ZooKeeper.getAnimals();
		// and
		ZooKeeper.getPets();
		// will return a list of test data for you to test your getNewComparator
		// methods (task 4).
	}
}
