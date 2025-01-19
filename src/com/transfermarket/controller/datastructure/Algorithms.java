package com.transfermarket.controller.datastructure;

import com.transfermarket.model.TransferModel;
import java.util.LinkedList;

/**
 *
 * @author Samir Adhikari
 */
public class Algorithms {

    /**
     * Sorts a LinkedList of TransferModel objects by age using the merge sort
     * algorithm.
     *
     * @param list The LinkedList of TransferModel objects to be sorted.
     * @return A new LinkedList sorted by age in ascending order.
     */
    public static LinkedList<TransferModel> mergeSortByAge(LinkedList<TransferModel> list) {
        // Base case: If the list has 0 or 1 element, it's already sorted, so return it as is.
        if (list.size() <= 1) {
            return list;
        }

        // Find the middle index to split the list into two halves.
        int mid = list.size() / 2;

        // Create two sublists: left and right, split at the middle index.
        LinkedList<TransferModel> left = new LinkedList<>(list.subList(0, mid));
        LinkedList<TransferModel> right = new LinkedList<>(list.subList(mid, list.size()));

        // Recursively sort each half.
        left = mergeSortByAge(left);
        right = mergeSortByAge(right);

        // Merge the two sorted halves into a single sorted list and return it.
        return mergeByAge(left, right);
    }

    /**
     * Merges two sorted LinkedLists of TransferModel objects into one sorted
     * list.
     *
     * @param left The first sorted LinkedList.
     * @param right The second sorted LinkedList.
     * @return A new LinkedList that merges both input lists in ascending order
     * of age.
     */
    private static LinkedList<TransferModel> mergeByAge(LinkedList<TransferModel> left, LinkedList<TransferModel> right) {
        // Create a new list to store the merged result.
        LinkedList<TransferModel> merged = new LinkedList<>();
        int i = 0, j = 0; // Pointers for traversing the left and right lists.

        // Compare elements from both lists and add the smaller one to the merged list.
        while (i < left.size() && j < right.size()) {
            // If the current element in the left list is smaller or equal, add it to the merged list.
            if (left.get(i).getAge() <= right.get(j).getAge()) {
                merged.add(left.get(i++)); // Increment the pointer for the left list.
            } else {
                // Otherwise, add the current element from the right list to the merged list.
                merged.add(right.get(j++)); // Increment the pointer for the right list.
            }
        }

        // If there are remaining elements in the left list, add all of them to the merged list.
        while (i < left.size()) {
            merged.add(left.get(i++));
        }

        // If there are remaining elements in the right list, add all of them to the merged list.
        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        // Return the merged list, which is now sorted.
        return merged;
    }

    /**
     * Sorts a LinkedList of TransferModel objects by player name using the
     * selection sort algorithm.
     *
     * @param list The LinkedList of TransferModel objects to be sorted.
     * @return The same LinkedList sorted by player name in ascending
     * alphabetical order.
     */
    public static LinkedList<TransferModel> selectionSortByName(LinkedList<TransferModel> list) {
        // Loop through the list, treating each index as the starting point for finding the minimum.
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i; // Assume the current index has the smallest player name.

            // Inner loop to find the actual minimum player name in the unsorted part of the list.
            for (int j = i + 1; j < list.size(); j++) {
                // Compare the player name of the current element with the element at minIndex.
                if (list.get(j).getPlayerName().compareTo(list.get(minIndex).getPlayerName()) < 0) {
                    minIndex = j; // Update minIndex if a smaller player name is found.
                }
            }

            // Swap the current element with the element at minIndex to place the smallest player name at the correct position.
            TransferModel temp = list.get(i); // Temporarily store the element at index i.
            list.set(i, list.get(minIndex)); // Move the element with the smallest player name to index i.
            list.set(minIndex, temp); // Place the original element from index i at minIndex.
        }

        // Return the sorted list.
        return list;
    }

    /**
     * Sorts a LinkedList of TransferModel objects by goal contributions using
     * the insertion sort algorithm.
     *
     * @param list The LinkedList of TransferModel objects to be sorted.
     * @return The same LinkedList sorted by goal contributions in ascending
     * order.
     */
    public static LinkedList<TransferModel> insertionSortByGoalContribution(LinkedList<TransferModel> list) {
        // Loop through the list starting from the second element (index 1).
        // The element at index 0 is considered already sorted.
        for (int i = 1; i < list.size(); i++) {
            TransferModel key = list.get(i); // The current element to be inserted into the sorted portion of the list.
            int j = i - 1; // Start comparing with the elements in the sorted portion (from right to left).

            // Shift elements in the sorted portion to the right if they are greater than the key.
            while (j >= 0 && list.get(j).getGoalContribution() > key.getGoalContribution()) {
                list.set(j + 1, list.get(j)); // Move the larger element one position to the right.
                j--; // Move the comparison to the previous element.
            }

            // Insert the key into its correct position within the sorted portion.
            list.set(j + 1, key);
        }

        // Return the sorted list.
        return list;
    }

    /**
     * Searches for a specific player name in a sorted LinkedList of
     * TransferModel objects using the binary search algorithm.
     *
     * @param transferList The sorted LinkedList of TransferModel objects to be
     * searched.
     * @param targetName The player name to search for.
     * @return The index of the target player name if found; otherwise, -1.
     */
    public static int binarySearchByName(LinkedList<TransferModel> transferList, String targetName) {
        int low = 0; // Starting index of the search range.
        int high = transferList.size() - 1; // Ending index of the search range.

        // Continue searching as long as the search range is valid.
        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the middle index of the current range.
            String midName = transferList.get(mid).getPlayerName(); // Get the player name at the middle index.

            // Check if the middle element matches the target player name.
            if (midName.compareToIgnoreCase(targetName) == 0) {
                return mid; // Name found; return its index.
            } // If the target name is alphabetically after the middle name, search the right half.
            else if (midName.compareToIgnoreCase(targetName) < 0) {
                low = mid + 1; // Adjust the starting index to narrow the search range.
            } // If the target name is alphabetically before the middle name, search the left half.
            else {
                high = mid - 1; // Adjust the ending index to narrow the search range.
            }
        }

        // Return -1 if the target player name is not found in the list.
        return -1;
    }

}
